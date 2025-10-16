package com.ecommerce.ecommerce.entity;

import com.ecommerce.ecommerce.enums.PedidoSituacao;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido")
@Entity
public class Pedido {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private PedidoSituacao pedidoSituacao;
    private String usuario;
    private String vendedor;
    private BigDecimal valorTotal;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> items;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaModificacao;
    private LocalDateTime dataCancelamento;
}
