package com.skillsup.DAO.repo.impl;

import com.skillsup.DAO.model.Order;
import com.skillsup.DAO.model.Product;
import com.skillsup.DAO.repo.OrderDAO;
import com.skillsup.DAO.repo.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProductDAO productDAO;

    @Override
    public void create(Order order) {
        Set<Product> productsInOrder = order.getProducts();
        Product productToUpdate;

        for (Product product: productsInOrder) {
            productToUpdate = productDAO.get(product.getId());
            productToUpdate.setCount(productToUpdate.getCount() - product.getCount());
            productDAO.update(productToUpdate.getId(), productToUpdate);
        }

        order.setStatus("created");
        entityManager.persist(order);
    }

    @Override
    public List<Order> findAll() {
        TypedQuery<Order> findAllOrders = entityManager.createQuery("SELECT o FROM Order o", Order.class);

        return findAllOrders.getResultList();
    }

    @Override
    public void delete(Long id) {
        Order order = this.get(id);
        Set<Product> productsInOrder = order.getProducts();
        Product productToUpdate;

        for (Product product: productsInOrder) {
            productToUpdate = productDAO.get(product.getId());
            productToUpdate.setCount(productToUpdate.getCount() + product.getCount());
            productDAO.update(productToUpdate.getId(), productToUpdate);
        }
        order.setStatus("deleted");

        Query query = entityManager.createQuery("DELETE FROM Order o WHERE o.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void update(Long id, Order order) {
        order.setId(id);
        entityManager.merge(order);
    }

    @Override
    public Order get(Long id) {
        return entityManager.find(Order.class, id);
    }

    public OrderDAOImpl() {
    }
}
