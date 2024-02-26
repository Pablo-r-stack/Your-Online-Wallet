package com.no_country.yow.security.filters;

import com.no_country.yow.security.jwt.JwtUtils;
import com.no_country.yow.security.uservalid.UserValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {
    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserValid userValid;

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {

        // Obtiene el encabezado 'Authorization' de la solicitud
        String tokenHeader = request.getHeader("Authorization");

        // Verifica si el encabezado no es nulo y comienza con 'Bearer'
        if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
            // Extrae el token eliminando el prefijo 'Bearer '
            String token = tokenHeader.substring(7, tokenHeader.length());

            // Verifica si el token es válido
            if (jwtUtils.isTokenValid(token)) {
                // Obtiene el nombre de usuario del token
                String username = jwtUtils.getUserToke(token);

                // Carga los detalles del usuario utilizando el servicio UserValid
                UserDetails userDetails = userValid.loadUserByUsername(username);

                // Crea un objeto de autenticación con el nombre de usuario y los roles del usuario
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());

                // Establece la autenticación en el contexto de seguridad
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        // Continúa con la cadena de filtros
        filterChain.doFilter(request, response);
    }
}