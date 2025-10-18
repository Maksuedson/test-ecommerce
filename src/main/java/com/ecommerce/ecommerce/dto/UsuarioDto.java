package com.ecommerce.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String password;
    private List<String> roles;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaModificacao;

}
