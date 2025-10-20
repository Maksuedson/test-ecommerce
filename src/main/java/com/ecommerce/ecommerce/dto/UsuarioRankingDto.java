package com.ecommerce.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class UsuarioRankingDto {
    private Long usuarioId;
    private String login;
    private BigDecimal totalComprado;
}
