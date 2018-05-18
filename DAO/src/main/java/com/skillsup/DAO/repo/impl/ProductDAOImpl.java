package com.skillsup.DAO.repo.impl;

import com.skillsup.DAO.model.Product;
import com.skillsup.DAO.model.User;
import com.skillsup.DAO.repo.ProductDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDAOImpl implements ProductDAO{
    private final Map<Long,Product> productMap = new HashMap<>();
    private static volatile long idGenerator =1L;
    @Override
    public void create(Product product) {
        product.setId(idGenerator++);
        productMap.put(product.getId(),product);
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(productMap.values());
    }
    public Map<Long, Product> getProductMap() {
        return productMap;
    }
}
