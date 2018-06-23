package com.skillsup.DAO.repo;

import com.skillsup.DAO.model.Order;
import com.skillsup.DAO.model.Product;
import com.skillsup.DAO.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context-dao-test.xml")
@Transactional
public class OrderDAOTest {
    
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private UserDAO userDAO;

    @PersistenceContext
    private EntityManager entityManager;

    @Before
    public void clean() {
        System.out.println("Remove all Orders from DB !!!");
        entityManager.createQuery("DELETE FROM Order o").executeUpdate();
        entityManager.clear();
    }

    @Test
    public void createTest() {
        //Given
        Set<Product> products = new HashSet<>();
        Date date = new Date(2017, 10, 12);
        products.add(productDAO.get(1L));
        User user = userDAO.get(1L);

        Order order = new Order(user, products, "test", date);

        //When
        orderDAO.create(order);
        System.out.println(orderDAO.findAll().toString());;
        //Then
        Order actualOrder = entityManager.find(Order.class, order.getId());
        Assert.assertEquals(order, actualOrder);
    }

    @Test
    public void findAllTest() {
        //Given
        Set<Product> products1 = new HashSet<>();
        Set<Product> products2 = new HashSet<>();
        Date date1 = new Date(2017, 10, 12);
        Date date2 = new Date(2017, 11, 12);
        products1.add(productDAO.get(1L));
        products1.add(productDAO.get(2L));
        products2.add(productDAO.get(2L));
        User user1 = userDAO.get(1L);
        User user2 = userDAO.get(2L);
        List<Order> expectedOrders = new ArrayList<>();
        expectedOrders.add(new Order(user1, products1, "testU1P1", date1));
        expectedOrders.add(new Order(user2, products2, "testU2P2", date2));

        expectedOrders.forEach(entityManager::persist);

        //When
        List<Order> actualOrders = orderDAO.findAll();

        //Then
        Assert.assertEquals(2, expectedOrders.size());
        Assert.assertTrue(actualOrders.containsAll(expectedOrders));
    }

    @Test
    public void deleteTest() {
        //Given
        Set<Product> products = new HashSet<>();
        Date date = new Date(2017, 10, 12);
        products.add(productDAO.get(1L));
        User user = userDAO.get(1L);

        Order order = new Order(user, products, "test", date);

        entityManager.persist(order);

        //When
        orderDAO.delete(order.getId());

        //Then
        entityManager.clear();
        Assert.assertNull(entityManager.find(Order.class, order.getId()));
    }

    @Test
    public void getByIdTest() {
        //Given
        Set<Product> products = new HashSet<>();
        Date date = new Date(2017, 10, 12);
        products.add(productDAO.get(1L));
        User user = userDAO.get(1L);

        Order order = new Order(user, products, "test", date);

        entityManager.persist(order);

        //When
        Order actualOrder = orderDAO.get(order.getId());

        //Then
        Assert.assertEquals(actualOrder, order);
    }

    @Test
    public void updateTest() {
        //Given
        Set<Product> products = new HashSet<>();
        Date date1 = new Date(2017, 10, 12);
        Date date2 = new Date(2017, 11, 12);
        products.add(productDAO.get(1L));
        products.add(productDAO.get(2L));
        User user = userDAO.get(2L);

        Order order = new Order(user, products, "testU1P1", date1);

        products.add(productDAO.get(3L));

        Order updatedOrder = new Order(user, products, "testUpdated", date1);

        entityManager.persist(order);

        //When
        orderDAO.update(order.getId(), updatedOrder);

        //Then
        Order actualOrder = entityManager.find(Order.class, order.getId());
        Assert.assertEquals(actualOrder, updatedOrder);
    }
}
