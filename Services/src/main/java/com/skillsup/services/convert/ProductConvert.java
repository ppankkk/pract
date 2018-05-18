package com.skillsup.services.convert;

import com.skillsup.DAO.model.Product;
import com.skillsup.DAO.model.User;
import com.skillsup.services.DTO.ProductDTO;
import com.skillsup.services.DTO.UserDTO;

public interface ProductConvert {
    Product toEntity(ProductDTO dto);
    ProductDTO toDto(Product entity);
}
