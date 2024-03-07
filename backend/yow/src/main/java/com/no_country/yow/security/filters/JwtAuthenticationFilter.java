package com.no_country.yow.security.filters;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.no_country.yow.dto.UserDTO;
import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Person;
import com.no_country.yow.security.jwt.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


@Slf4j
public class JwtAuthenticationFilter  extends UsernamePasswordAuthenticationFilter {
    private JwtUtils jwtUtils;



    public JwtAuthenticationFilter(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    // Intento de autenticación del usuario
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        UserDTO user = null;
        String userDocument = "";
        String password = "";

        try {
            // Lee los datos del usuario desde el cuerpo de la solicitud
            user = new ObjectMapper().readValue(request.getInputStream(), UserDTO.class);
            userDocument = user.getUsername();
            password = user.getPassword();
            
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Crea un token de autenticación utilizando el nombre de usuario y la contraseña proporcionados
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDocument, password);

        // Retorna la autenticación utilizando el Administrador de Autenticación
        return getAuthenticationManager().authenticate(authenticationToken);
    }

    // Método llamado cuando la autenticación es exitosa
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException {

        User user = (User) authResult.getPrincipal();
        // Genera un token JWT utilizando JwtUtils
        String token = jwtUtils.generateToken(user.getUsername());
        // Agrega el token JWT al encabezado de la respuesta
        response.addHeader("Authorization", token);
        
        String number = (String) user.getUsername();
         UserDTO message = jwtUtils.message(number);
        
        // Crea un mapa para la respuesta HTTP
        Map<String, Object> httpResponse = new HashMap<>();
        httpResponse.put("token", token);
        httpResponse.put("message", "Authentication successful");
        httpResponse.put("User", message);

        // Escribe la respuesta en formato JSON en el cuerpo de la respuesta
        response.getWriter().write(new ObjectMapper().writeValueAsString(httpResponse));

        // Establece el código de estado y el tipo de contenido de la respuesta
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().flush();
    }
}
