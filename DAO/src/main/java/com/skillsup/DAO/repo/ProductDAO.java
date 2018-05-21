package com.skillsup.DAO.repo;

import com.skillsup.DAO.model.Product;

import java.util.List;

public interface ProductDAO {

    void create(Product product);
    List<Product> findAll();
    void delete(Long id);
    void update(Long id, Product product);
    Product get(Long id);
}
