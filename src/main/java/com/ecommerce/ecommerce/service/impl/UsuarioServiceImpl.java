package com.ecommerce.ecommerce.service.impl;

import com.ecommerce.ecommerce.controller.response.UsuarioResponse;
import com.ecommerce.ecommerce.dto.UsuarioDto;
import com.ecommerce.ecommerce.entity.Usuario;
import com.ecommerce.ecommerce.exception.NaoEncontradoException;
import com.ecommerce.ecommerce.mapper.UsuarioMapper;
import com.ecommerce.ecommerce.repository.UsuarioRepository;
import com.ecommerce.ecommerce.service.interfaces.UsuarioService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioDto cadastrar(UsuarioDto usuarioDto) {
        Usuario user = UsuarioMapper.toEntity(usuarioDto);
        user.setDataCadastro(LocalDateTime.now().withNano(0));
        Usuario usuarioSalvo = usuarioRepository.save(user);
        return UsuarioMapper.toDto(usuarioSalvo);
    }

    @Override
    public List<UsuarioDto> cadastrarLista(List<UsuarioDto> lista) {

        return null;
    }

    @Override
    public UsuarioDto buscaUsuarioPorId(Long id) {
        Usuario user =buscaPorId(id);
        return UsuarioMapper.toDto(user);
    }

    @Override
    public List<UsuarioDto> buscaUsuarioPorNome(String nome) {
        return null;
    }

    @Override
    public UsuarioDto alterar(Long id, UsuarioDto usuarioDto) {
        return null;
    }

    @Override
    public List<UsuarioResponse> listaUsuarios() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    private Usuario buscaPorId(Long id) {
        return usuarioRepository
                .findById(id)
                .orElseThrow(
                        () -> new NaoEncontradoException("Usuário não existe!"));
    }
}
