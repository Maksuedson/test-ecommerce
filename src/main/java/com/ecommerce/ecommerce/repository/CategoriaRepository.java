package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.entity.Categoria;
import com.ecommerce.ecommerce.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

    @Query("select c from Categoria c where c.nome ilike %?1%")
    List<Categoria> findByName(String nome);

}
