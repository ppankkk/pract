    package com.skillsup.services.impl;

import com.skillsup.DAO.model.Product;
import com.skillsup.DAO.repo.ProductDAO;
import com.skillsup.services.DTO.ProductDTO;
import com.skillsup.services.ProductService;
import com.skillsup.services.convert.ProductConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductDAO productDAO;
    private final ProductConvert productConvert;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO, ProductConvert productConvert) {
        this.productDAO = productDAO;
        this.productConvert = productConvert;
    }

    @Override
    @Transactional
    public void create(ProductDTO product) {
        productDAO.create(productConvert.toEntity(product));
    }

    @Override
    @Transactional
    public List<ProductDTO> findAll() {
        List<Product> products = productDAO.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for(Product product: products){
            productDTOS.add(productConvert.toDto(product));
        }
        return productDTOS;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productDAO.delete(id);
    }

    @Override
    @Transactional
    public void update(Long id, ProductDTO product) {
        productDAO.update(id, productConvert.toEntity(product));
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO get(Long id) {
        return productConvert.toDto(productDAO.get(id));
    }
}
