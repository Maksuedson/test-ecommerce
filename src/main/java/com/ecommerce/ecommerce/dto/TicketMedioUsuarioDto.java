package com.ecommerce.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class TicketMedioUsuarioDto {
    private Long usuarioId;
    private String login;
    private Long totalPedidos;
    private BigDecimal somaTotal;
    private BigDecimal ticketMedio;
}
