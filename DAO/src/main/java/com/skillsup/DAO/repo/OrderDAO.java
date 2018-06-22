package com.skillsup.DAO.repo;

import com.skillsup.DAO.model.Order;

import java.util.List;

public interface OrderDAO {

    void create(Order order);
    List<Order> findAll();
    void delete(Long id);
    void update(Long id, Order order);
    Order get(Long id);
}
