package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.dto.UsuarioRankingDto;
import com.ecommerce.ecommerce.report.VendaRelatorioDTO;
import com.ecommerce.ecommerce.service.RelatorioVendaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/relatorios")
public class RelatorioVendaController {

    private final RelatorioVendaService relatorioVendaService;

    public RelatorioVendaController(RelatorioVendaService relatorioVendaService) {
        this.relatorioVendaService = relatorioVendaService;
    }

    @GetMapping("/vendas")
    public ResponseEntity<List<VendaRelatorioDTO>> listarRelatorioVendas() {
        List<VendaRelatorioDTO> relatorio = relatorioVendaService.gerarRelatorioVendas();
        return ResponseEntity.ok(relatorio);
    }

    @GetMapping("/top-usuarios")
    public List<UsuarioRankingDto> topUsuarios(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal) {

        return relatorioVendaService.top5UsuariosCompradores(dataInicial, dataFinal);
    }
}
