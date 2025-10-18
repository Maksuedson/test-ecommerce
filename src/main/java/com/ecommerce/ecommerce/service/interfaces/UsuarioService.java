package com.ecommerce.ecommerce.service.interfaces;

import com.ecommerce.ecommerce.controller.response.UsuarioResponse;
import com.ecommerce.ecommerce.dto.UsuarioDto;

import java.util.List;

public interface UsuarioService {

    UsuarioDto cadastrar(UsuarioDto usuarioDto);
    List<UsuarioDto> cadastrarLista(List<UsuarioDto> lista);

    UsuarioDto buscaUsuarioPorId(Long id);

    List<UsuarioDto> buscaUsuarioPorNome(String nome);

    UsuarioDto alterar(Long id, UsuarioDto usuarioDto);

    List<UsuarioResponse> listaUsuarios();

    void deleteById(Long id);
}
