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
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
        
    }

    @Test
    public void deleteTest() {
        
    }

    @Test
    public void getByIdTest() {
        
    }

    @Test
    public void updateTest() {
    }

    //    void create(Order order);
//    List<Order> findAll();
//    void delete(Long id);
//    void update(Long id, Order order);
//    Order get(Long id);    
}
