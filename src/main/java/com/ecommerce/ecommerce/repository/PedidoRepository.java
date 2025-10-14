package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.entity.Pedido;
import com.ecommerce.ecommerce.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
}
