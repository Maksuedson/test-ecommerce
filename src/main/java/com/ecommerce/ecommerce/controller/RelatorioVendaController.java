package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.report.VendaRelatorioDTO;
import com.ecommerce.ecommerce.service.RelatorioVendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/relatorios/vendas")
public class RelatorioVendaController {

    private final RelatorioVendaService relatorioVendaService;

    public RelatorioVendaController(RelatorioVendaService relatorioVendaService) {
        this.relatorioVendaService = relatorioVendaService;
    }

    @GetMapping
    public ResponseEntity<List<VendaRelatorioDTO>> listarRelatorioVendas() {
        List<VendaRelatorioDTO> relatorio = relatorioVendaService.gerarRelatorioVendas();
        return ResponseEntity.ok(relatorio);
    }
}
