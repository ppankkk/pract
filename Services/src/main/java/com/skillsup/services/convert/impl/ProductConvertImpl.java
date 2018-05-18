package com.skillsup.services.convert.impl;

import com.skillsup.DAO.model.Product;
import com.skillsup.services.DTO.ProductDTO;
import com.skillsup.services.convert.ProductConvert;
import org.springframework.stereotype.Component;

@Component
public class ProductConvertImpl implements ProductConvert {

    @Override
    public Product toEntity(ProductDTO dto) {
        return new Product(dto.getName(), dto.getCategory(), dto.getColor(), dto.getGender(), dto.getCount(), dto.getPrice(), dto.getSize(), null);
    }

    @Override
    public ProductDTO toDto(Product entity) {
        return new ProductDTO(entity.getName(),entity.getCategory(),entity.getColor(),entity.getGender(),entity.getCount(),entity.getPrice(),entity.getSize());
    }
}