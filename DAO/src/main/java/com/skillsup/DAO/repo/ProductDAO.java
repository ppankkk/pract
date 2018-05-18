package com.skillsup.DAO.repo;

import com.skillsup.DAO.model.Product;

import java.util.List;

public interface ProductDAO {
    void create(Product product);
    List<Product> getAll();
}
