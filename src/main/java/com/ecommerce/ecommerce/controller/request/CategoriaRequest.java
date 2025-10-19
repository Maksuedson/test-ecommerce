package com.ecommerce.ecommerce.controller.request;

import com.ecommerce.ecommerce.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaRequest {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
}
