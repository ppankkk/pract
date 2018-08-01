package com.skillsup.DAO.repo;

import com.skillsup.DAO.model.Order;
import com.skillsup.DAO.model.User;

import java.util.List;

public interface OrderDAO {

    void create(Order order);
    List<Order> findAll();
    List<Order> findAllUserOrders(User user);
    void delete(Long id);
    void update(Long id, Order order);
    Order get(Long id);
}
