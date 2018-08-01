package com.skillsup.services.convert;

import com.skillsup.DAO.model.Product;
import com.skillsup.services.DTO.ProductDTO;

public interface ProductConvert {
    Product toEntity(ProductDTO dto);
    ProductDTO toDto(Product entity);
}
