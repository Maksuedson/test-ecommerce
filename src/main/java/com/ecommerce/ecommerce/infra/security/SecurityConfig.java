package com.ecommerce.ecommerce.infra.security;

import com.ecommerce.ecommerce.repository.UsuarioRepository;
import com.ecommerce.ecommerce.service.AuthUserDetailsService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    SecurityFilter securityFilter;

    @Autowired
    private AuthUserDetailsService authUserDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers( "/api/login").permitAll()
                        .requestMatchers("/api/usuarios").permitAll()
                        .requestMatchers("/api/clientes").hasRole("ADMIN")
                        .requestMatchers("/api/categorias").hasRole("ADMIN")
                        .requestMatchers("/api/produtos").hasRole("ADMIN")
                        .requestMatchers("/api/pedidos").hasRole("ADMIN")
                        .requestMatchers("/api/relatorios").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/produtos").hasRole("USER")
                        .requestMatchers(HttpMethod.POST,"/api/pedidos").hasRole("USER")

                        .anyRequest().authenticated()
                )

//                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable())) // para H2
//                .addFilterBefore(filterToken, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                            response.setContentType("application/json");
                            response.getWriter().write(
                                    "{\"error\": \"Credenciais inválidas ou ausentes. " + HttpServletResponse.SC_UNAUTHORIZED + "\"}"
                            );
                        })
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                            response.setContentType("application/json");
                            response.getWriter().write(
                                    "{\"error\": \"Acesso negado: permissão insuficiente. " + HttpServletResponse.SC_FORBIDDEN + "\"}"
                            );
                        })
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)

                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UsuarioRepository usuarioRepository) {
        return username -> usuarioRepository.findByLogin(username);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(authUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

}
