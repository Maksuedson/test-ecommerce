package com.ecommerce.ecommerce.service.impl;

import com.ecommerce.ecommerce.controller.response.UsuarioResponse;
import com.ecommerce.ecommerce.dto.UsuarioDto;
import com.ecommerce.ecommerce.entity.Usuario;
import com.ecommerce.ecommerce.exception.NaoEncontradoException;
import com.ecommerce.ecommerce.exception.SqlInterityContraintViolationException;
import com.ecommerce.ecommerce.mapper.UsuarioMapper;
import com.ecommerce.ecommerce.repository.UsuarioRepository;
import com.ecommerce.ecommerce.service.interfaces.UsuarioService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public UsuarioDto cadastrar(UsuarioDto usuarioDto) {

        if (usuarioRepository.existsByLogin(usuarioDto.getUsername())) {
            throw new SqlInterityContraintViolationException("Username já cadastrado: " + usuarioDto.getUsername());
        }

        Usuario user = UsuarioMapper.toEntity(usuarioDto);
        String encryptedPassword = new BCryptPasswordEncoder().encode(usuarioDto.getPassword());
        user.setPassword(encryptedPassword);
        user.setDataCadastro(LocalDateTime.now().withNano(0));

        Usuario usuarioSalvo = usuarioRepository.save(user);
        return UsuarioMapper.toDto(usuarioSalvo);
    }


    public List<UsuarioDto> cadastrarLista(List<UsuarioDto> lista) {

        return null;
    }

    public UsuarioDto buscaUsuarioPorId(Long id) {
        Usuario user =buscaPorId(id);
        return UsuarioMapper.toDto(user);
    }

    public List<UsuarioDto> buscaUsuarioPorNome(String nome) {
        return null;
    }

    public UsuarioDto alterar(Long id, UsuarioDto usuarioDto) {
        return null;
    }

    public List<UsuarioResponse> listaUsuarios() {
        return null;
    }

    public void deleteById(Long id) {

    }

    private Usuario buscaPorId(Long id) {
        return usuarioRepository
                .findById(id)
                .orElseThrow(
                        () -> new NaoEncontradoException("Usuário não existe!"));
    }

}
