package com.ecommerce.ecommerce.mapper;

import com.ecommerce.ecommerce.controller.response.UsuarioResponse;
import com.ecommerce.ecommerce.dto.UsuarioDto;
import com.ecommerce.ecommerce.entity.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioDto usuarioDto){
        return Usuario.builder()
                .id(usuarioDto.getId())
                .username(usuarioDto.getUsername())
                .password(usuarioDto.getPassword())
                .roles(usuarioDto.getRoles())
                .dataCadastro(usuarioDto.getDataCadastro())
                .dataUltimaModificacao(usuarioDto.getDataUltimaModificacao())
                .build();
    }

    public static Usuario toEntity(UsuarioResponse response){
        return Usuario.builder()
                .id(response.getId())
                .username(response.getUsername())
                .roles(response.getRoles())
                .build();
    }

    public static UsuarioResponse toResponse(UsuarioDto usuarioDto){
        return UsuarioResponse.builder()
                .id(usuarioDto.getId())
                .username(usuarioDto.getUsername())
                .roles(usuarioDto.getRoles())
                .build();
    }

    public static UsuarioDto toDto(UsuarioResponse response){
        return UsuarioDto.builder()
                .id(response.getId())
                .username(response.getUsername())
                .roles(response.getRoles())
                .build();
    }

    public static UsuarioDto toDto(Usuario usuario){
        return UsuarioDto.builder()
                .id(usuario.getId())
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(usuario.getRoles())
                .dataCadastro(usuario.getDataCadastro())
                .dataUltimaModificacao(usuario.getDataUltimaModificacao())
                .build();
    }
}
