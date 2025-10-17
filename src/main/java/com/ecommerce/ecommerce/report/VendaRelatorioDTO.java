package com.ecommerce.ecommerce.report;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class VendaRelatorioDTO {
    private Long pedidoId;
    private String cliente;
    private String vendedor;
    private LocalDateTime dataCadastro;
    private String situacao;
    private String pagamento;
    private BigDecimal valorTotal;
    private List<ItemRelatorioDTO> itens;
}
