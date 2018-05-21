package com.skillsup.services;

import com.skillsup.services.DTO.ProductDTO;

import java.util.List;

public interface ProductService {
    void create(ProductDTO product);
    List<ProductDTO> findAll();
}
