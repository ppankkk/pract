package com.skillsup.services.impl;

import com.skillsup.DAO.model.Order;
import com.skillsup.DAO.model.Product;
import com.skillsup.DAO.repo.OrderDAO;
import com.skillsup.DAO.repo.ProductDAO;
import com.skillsup.DAO.repo.UserDAO;
import com.skillsup.services.DTO.OrderDTO;
import com.skillsup.services.DTO.UserDTO;
import com.skillsup.services.OrderService;
import com.skillsup.services.convert.OrderConvert;
import com.skillsup.services.convert.UserConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;
    private final OrderConvert orderConvert;
    private final UserConvert userConvert;
    private final ProductDAO productDAO;
    private final UserDAO userDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO, OrderConvert orderConvert, UserConvert userConvert, ProductDAO productDAO, UserDAO userDAO) {
        this.orderDAO = orderDAO;
        this.orderConvert = orderConvert;
        this.userConvert = userConvert;
        this.productDAO = productDAO;
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void create(OrderDTO order) {
        orderDAO.create(orderConvert.toEntity(order));
    }

    @Override
    @Transactional
    public List<OrderDTO> findAll() {

        List<Order> orders = orderDAO.findAll();
        List<OrderDTO> orderDTOS = new ArrayList<>();

        orders.forEach(order -> orderDTOS.add(orderConvert.toDto(order)));

        return orderDTOS;
    }

    @Override
    @Transactional
    public List<OrderDTO> findAllUserOrders(UserDTO user) {

        List<Order> userOrders = orderDAO.findAllUserOrders(userConvert.toEntity(user));
        List<OrderDTO> userOrderDTOS = new ArrayList<>();

        userOrders.forEach(userOrder -> userOrderDTOS.add(orderConvert.toDto(userOrder)));

        return userOrderDTOS;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Order order = orderDAO.get(id);
        Set<Product> productsInOrder = order.getProducts();

        for (Product product: productsInOrder) {
            product.getOrders().remove(order);
            productDAO.update(product.getId(), product);
        }
        order.setStatus("deleted");
        orderDAO.delete(id);
    }

    @Override
    @Transactional
    public void update(Long id, OrderDTO order) {
        orderDAO.update(id, orderConvert.toEntity(order));
    }

    @Override
    @Transactional
    public OrderDTO get(Long id) {
        return null;
    }
}