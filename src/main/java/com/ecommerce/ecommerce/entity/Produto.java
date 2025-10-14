package com.ecommerce.ecommerce.entity;

import jakarta.persistence.*;
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

    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String codigoBarras;
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    private BigDecimal estoque;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaModificacao;


}
