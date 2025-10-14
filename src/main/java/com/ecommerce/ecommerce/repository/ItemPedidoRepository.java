package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.entity.ItemPedido;
import com.ecommerce.ecommerce.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{
    
}
