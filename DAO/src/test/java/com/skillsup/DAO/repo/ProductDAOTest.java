package com.skillsup.DAO.repo;


import com.skillsup.DAO.model.Product;
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
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context-dao-test.xml")
@Transactional
public class ProductDAOTest {

    @Autowired
    private ProductDAO productDAO;

    @PersistenceContext
    private EntityManager entityManager;

    @Before
    public void clean() {
        System.out.println("Remove all Products from DB !!!");
        entityManager.createQuery("DELETE FROM Product p").executeUpdate();
        entityManager.clear();
    }

    @Test
    public void testCreate() {
        //Given
        Product product = new Product(
                        "Maseratti", "Car", "Blue",
                        "Unisex", 1, 100000, "XL", null);
        //When
        productDAO.create(product);

        //Then
        Product actualProduct = entityManager.find(Product.class, product.getId());
        Assert.assertEquals(product, actualProduct);
    }

    @Test
    public void testfindAll() {
        //Given
        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product(
                "Maseratti","Car","Blue","Unisex",
                1,100000,"XL",null));
        expectedProducts.add(new Product(
                "Zapor","Car","White","Unisex",
                100,1000,"Small",null));

        expectedProducts.forEach(entityManager::persist);

        //When
        List<Product> actualProducts = productDAO.findAll();

        //Then
        Assert.assertEquals(2, actualProducts.size());
        Assert.assertTrue(actualProducts.containsAll(expectedProducts));
    }

    @Test
    public void testDelete() {
        //Given
        Product product = new Product(
                "Maseratti", "Car", "Blue",
                "Unisex", 1, 100000, "XL", null);
        entityManager.persist(product);

        //When
        productDAO.delete(product.getId());

        //Then
        entityManager.clear();
        Assert.assertNull(entityManager.find(Product.class, product.getId()));
    }

    @Test
    public void testUpdate() {
        //Given
        Product product = new Product(
                "Maseratti", "Car", "Blue", "Unisex",
                1, 100000, "XL", null);
        Product updatedProduct = new Product(
                "Zapor", "Car", "White", "Unisex",
                100, 1000, "Small", null);
        entityManager.persist(product);

        //When
        productDAO.update(product.getId(), updatedProduct);

        //Then
        Product actualProduct = entityManager.find(Product.class, product.getId());
        Assert.assertEquals(actualProduct, updatedProduct);
    }

    @Test
    public void testGet() {
        //Given
        Product product = new Product(
                "Maseratti", "Car", "Blue",
                "Unisex", 1, 100000, "XL", null);
        entityManager.persist(product);

        //When
        Product actualProduct = productDAO.get(product.getId());

        //Then
        Assert.assertEquals(actualProduct, product);
    }
}
