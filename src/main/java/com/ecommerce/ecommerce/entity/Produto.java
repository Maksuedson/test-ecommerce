package com.ecommerce.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produto")
@Entity
public class Produto {

    private UUID id;
    private String nome;
    private BigDecimal preco;
    private Categoria categoria;
    private BigDecimal estoque;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaModificacao;


}
