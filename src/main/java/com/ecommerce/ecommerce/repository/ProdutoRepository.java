package com.ecommerce.ecommerce.repository;

import java.util.List;

import com.ecommerce.ecommerce.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	@Query("select p from Produto p where p.nome like %?1%")
	List<Produto> findProdutoByName(String nome);
	
    @Query("select p from Produto p where p.codigoBarras = ?1")
    Produto findProdutoByCodigoBarras(String codigoBarras);
    
    @Query("select p from Produto p where p.nome like %?1% or p.codigoBarras = ?1")
    List<Produto> findProdutoByNameOrCodigoBarras(String nomeOuCodigoBarras);
}
