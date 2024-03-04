package com.no_country.yow.security.jwt;

import com.no_country.yow.dto.UserDTO;
import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Person;
import com.no_country.yow.repositories.PersonRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
public class JwtUtils {

    @Value("${jwt.secret.key}")
// Anotación para inyectar el valor de la propiedad 'jwt.secret.key' en la variable 'secretKey'
    private String secretKey;

    @Value("${jwt.time.expiration}")
// Anotación para inyectar el valor de la propiedad 'jwt.time.expiration' en la variable 'timeExpiration'
    private String timeExpiration;

    @Autowired
    private PersonRepository beanPerson;

    // Método para generar un token de acceso
    public String generateToken(String userIdentification) {
        return Jwts.builder() // Comienza la construcción del token
                .setSubject(userIdentification) // Establece el sujeto del token como la identificación de usuario
                .setIssuedAt(new Date(System.currentTimeMillis())) // Establece la fecha de emisión del token como la fecha y hora actuales
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(timeExpiration))) // Establece la fecha de vencimiento del token según el tiempo de expiración configurado
                .signWith(getSignatureKey(), SignatureAlgorithm.HS256) // Firma el token utilizando la clave de firma obtenida y el algoritmo HS256
                .compact(); // Compacta el token y devuelve una cadena
    }

    // Método para validar un token de acceso
    public boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder() // Inicia el proceso de análisis del token
                    .setSigningKey(getSignatureKey()) // Establece la clave de firma para verificar la autenticidad del token
                    .build() // Construye el parser
                    .parseClaimsJws(token) // Analiza el token y obtiene el cuerpo de los reclamos
                    .getBody(); // Devuelve los reclamos del token, si el token es válido
            return true; // Devuelve verdadero si el token es válido
        } catch (Exception e) {
            log.error("Token invalido: ".concat(e.getMessage())); // Registra un mensaje de error si ocurre alguna excepción al validar el token
            return false; // Devuelve falso si el token no es válido
        }
    }

    // Método para obtener el usuario del token
    public String getUserToke(String token) {
        return getClaim(token, Claims::getSubject); // Obtiene el sujeto del token utilizando el método getClaim
    }

    // Método para obtener un reclamo específico del token
    public <T> T getClaim(String token, Function<Claims, T> claimsFunction) {
        Claims claim = extractAllClaims(token); // Extrae todos los reclamos del token
        return claimsFunction.apply(claim); // Aplica la función de reclamos al reclamo específico y devuelve el resultado
    }

    // Método para extraer todos los reclamos del token
    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder() // Inicia el proceso de análisis del token
                .setSigningKey(getSignatureKey()) // Establece la clave de firma para verificar la autenticidad del token
                .build() // Construye el parser
                .parseClaimsJws(token) // Analiza el token y obtiene el cuerpo de los reclamos
                .getBody(); // Devuelve los reclamos del token
    }

    // Método para obtener la clave de firma del token
    public Key getSignatureKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey); // Decodifica la clave secreta del formato BASE64
        return Keys.hmacShaKeyFor(keyBytes); // Devuelve la clave de firma generada utilizando la clave secreta
    }

    public UserDTO message(String number) {
        try {
            Person result = beanPerson.data(number);
            if (result == null) {
                throw new Exception("Usuario no existe: " + number);
            }

            UserDTO person = new UserDTO();
            person.setId(result.getId());
            person.setName(result.getName());
            person.setLastname(result.getLastName());
            person.setUsername(result.getNumberIdentification());
            person.setRol(result.getRol().name());
            return person;
        } catch (Exception e) {
            log.info("Aqui");
            log.info("Error: " + e.getMessage());
            return null;

        }
    }

}
