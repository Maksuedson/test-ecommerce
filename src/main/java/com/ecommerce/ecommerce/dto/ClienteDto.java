package com.ecommerce.ecommerce.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
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


    public ClienteDto(Long id, String nome, String endereco, String numero, String bairro, String cep, String cidade, String estado, String telefone, String celular, String email, LocalDateTime dataCadastro, LocalDateTime dataUltimaModificacao) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.dataCadastro = dataCadastro;
        this.dataUltimaModificacao = dataUltimaModificacao;
    }

    public ClienteDto(Long id, String nome, String endereco, String numero, String bairro, String cep, String cidade, String estado, String telefone, String celular, String email) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
    }
}
