package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.entity.Cliente;
import com.ecommerce.ecommerce.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
