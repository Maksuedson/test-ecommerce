package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.dto.TicketMedioUsuarioDto;
import com.ecommerce.ecommerce.dto.UsuarioRankingDto;
import com.ecommerce.ecommerce.entity.Pedido;
import com.ecommerce.ecommerce.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    @Query("SELECT new com.ecommerce.ecommerce.dto.UsuarioRankingDto(u.id, u.login, SUM(p.valorTotal)) " +
            "FROM Pedido p " +
            "JOIN p.usuario u " +
            "WHERE p.dataCadastro BETWEEN :dataInicial AND :dataFinal " +
            "GROUP BY u.id, u.login " +
            "ORDER BY SUM(p.valorTotal) DESC")
    List<UsuarioRankingDto> findTopUsuariosCompradores(
            @Param("dataInicial") LocalDateTime dataInicial,
            @Param("dataFinal") LocalDateTime dataFinal
    );

    @Query("SELECT new com.ecommerce.ecommerce.dto.TicketMedioUsuarioDto(" +
            "u.id, u.login, COUNT(p.id), SUM(p.valorTotal), SUM(p.valorTotal) / COUNT(p.id)) " +
            "FROM Pedido p " +
            "JOIN p.usuario u " +
            "WHERE p.dataCadastro BETWEEN :dataInicial AND :dataFinal " +
            "GROUP BY u.id, u.login")
    List<TicketMedioUsuarioDto> calcularTicketMedioPorUsuario(
            @Param("dataInicial") LocalDateTime dataInicial,
            @Param("dataFinal") LocalDateTime dataFinal
    );


}
