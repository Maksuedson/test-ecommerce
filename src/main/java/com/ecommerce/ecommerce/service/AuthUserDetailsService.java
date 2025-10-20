package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public AuthUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(">> [AuthUserDetailsService] buscando usuário: " + username);
        return usuarioRepository.findByLogin(username);
    }
}