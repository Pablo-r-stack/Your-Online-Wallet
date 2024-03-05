/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.no_country.yow.security;

import com.no_country.yow.security.filters.JwtAuthenticationFilter;
import com.no_country.yow.security.filters.JwtAuthorizationFilter;
import com.no_country.yow.security.jwt.JwtUtils;
import com.no_country.yow.security.uservalid.UserValid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author jpach
 */
@Slf4j
@Configuration // Indica que esta clase es una configuración de Spring
@EnableWebSecurity // Habilita la seguridad web de Spring Security
@EnableMethodSecurity
public class ConfigSecurity {

    @Autowired
    private UserValid userValid; // Inyecta el servicio de Personas

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private JwtAuthorizationFilter jwtAuthorizationFilter;
    

// Configura la cadena de filtros de seguridad
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) throws Exception {
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtUtils);
        jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/yow/login");
        return httpSecurity
                .csrf().disable() // Deshabilita la protección CSRF La vamos a deshabilitar por que estamos trabajando con jwt
                .cors()
                .and()
                .authorizeHttpRequests() // Configura las reglas de autorización para las solicitudes HTTP
                .antMatchers("/yow", "/yow/register", "/yow/login/change-password","/yow/save-register").permitAll() // Permite el acceso público a estas rutas
                .anyRequest().authenticated() // Todas las demás rutas requieren autenticación
                .and()
                .sessionManagement(session -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Configura la política de creación de sesiones
                })
                .addFilter(jwtAuthenticationFilter)
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .build(); // Construye la cadena de filtros de seguridad
    }

//   @Bean
//    UserDetailsService userDefault() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//
//        // Crea un usuario en memoria con nombre "appYow", contraseña "Yow2024" y rol "admin"
//        manager.createUser(User.withUsername("appYow")
//                .password("Yow2024")
//                .roles("admin")
//                .build());
//
//        return manager; // Retorna el administrador de detalles de usuario
//    }
// Configura el codificador de contraseñas
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Utiliza el codificador BCrypt para las contraseñas
    }

// Configura el administrador de autenticación
    @Bean
    AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class) // Obtiene el constructor de autenticación compartido
                .userDetailsService(userValid) // Configura el servicio de detalles de usuario
                .passwordEncoder(passwordEncoder()) // Configura el codificador de contraseñas
                .and()
                .build(); // Construye el administrador de autenticación
    }

}