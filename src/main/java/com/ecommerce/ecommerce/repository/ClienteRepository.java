package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.entity.Cliente;
import com.ecommerce.ecommerce.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    @Query("select c from Cliente c where c.nome like %?1%")
    List<Cliente> findByName(String nome);
    
}
