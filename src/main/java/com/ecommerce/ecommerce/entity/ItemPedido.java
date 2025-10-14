package com.ecommerce.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item_pedido")
@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valorProdutos;
    private BigDecimal valorDesconto;
    private BigDecimal valorAcrescimo;
    private BigDecimal valorTotal;
    private BigDecimal preco;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaModificacao;
    private BigDecimal quantidade;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;


    @ManyToOne
    @JoinColumn(name = "venda_id")
    @JsonIgnore
    private Pedido pedido;
}
