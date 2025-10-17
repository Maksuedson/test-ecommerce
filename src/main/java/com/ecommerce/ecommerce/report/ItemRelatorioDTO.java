package com.ecommerce.ecommerce.report;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ItemRelatorioDTO {
    private String nomeProduto;
    private BigDecimal precoUnitario;
    private BigDecimal quantidade;
    private BigDecimal subtotal;
}
