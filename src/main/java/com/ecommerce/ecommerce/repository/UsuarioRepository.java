package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
