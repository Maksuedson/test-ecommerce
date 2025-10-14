package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

    List<Categoria> findByNomeContaining(String nome);

}
