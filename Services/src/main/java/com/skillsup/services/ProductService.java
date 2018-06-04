package com.skillsup.services;

import com.skillsup.services.DTO.ProductDTO;

import java.util.List;

public interface ProductService {
    void create(ProductDTO product);
    List<ProductDTO> findAll();
    void delete(Long id);
    void update(Long id, ProductDTO product);
    ProductDTO get(Long id);
}
