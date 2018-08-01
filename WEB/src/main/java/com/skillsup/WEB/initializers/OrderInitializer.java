package com.skillsup.WEB.initializers;

import com.skillsup.DAO.model.Order;
import com.skillsup.DAO.model.Product;
import com.skillsup.DAO.repo.OrderDAO;
import com.skillsup.DAO.repo.ProductDAO;
import com.skillsup.DAO.repo.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class OrderInitializer implements ApplicationListener<ContextRefreshedEvent> {
    private final ProductDAO productDAO;
    private final UserDAO userDAO;
    private final OrderDAO orderDAO;

    @Autowired
    public OrderInitializer(ProductDAO productDAO, UserDAO userDAO, OrderDAO orderDAO) {
        this.productDAO = productDAO;
        this.userDAO = userDAO;
        this.orderDAO = orderDAO;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Set<Product> products = new HashSet<>();
        products.add(productDAO.get(1L));
        products.add(productDAO.get(2L));
        products.add(productDAO.get(3L));

        orderDAO.create(new Order(userDAO.get(1L), products, "initialized", new Date(2017, 10, 12), null));
        orderDAO.create(new Order(userDAO.get(1L), products, "initialized", new Date(2017, 11, 12), null));
        orderDAO.create(new Order(userDAO.get(1L), products, "initialized", new Date(2017, 11, 18), null));

        products.remove(productDAO.get(2L));

        orderDAO.create(new Order(userDAO.get(2L), products, "initialized", new Date(2017, 11, 18), null));
        orderDAO.create(new Order(userDAO.get(2L), products, "initialized", new Date(2018, 1, 8), null));
    }
}
