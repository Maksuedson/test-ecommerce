package com.ecommerce.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String endereco;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String telefone;
    private String celular;
    private String email;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaModificacao;
}
