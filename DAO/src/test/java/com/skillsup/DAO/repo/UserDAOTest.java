package com.skillsup.DAO.repo;

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
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context-dao-test.xml")
@Transactional
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @PersistenceContext
    private EntityManager entityManager;

    @Before
    public void cleanup(){
        System.out.println("Clean DB !!!");
        entityManager.createQuery("DELETE FROM User u").executeUpdate();
        entityManager.clear();
    }

    @Test
    public void testFindById(){
        //Given
        User user = new User("Ann", "Lee", 23, null);
        entityManager.persist(user);

        //When
        User actualUser = userDAO.get(user.getId());

        //Then
        Assert.assertEquals(user, actualUser);
    }

    @Test
    public void testDelete(){
        // Given
        User user = new User("Ann", "Lee", 23, null);
        entityManager.persist(user);
        Long id = user.getId();

        // When
        userDAO.delete(id);

        // Then
        entityManager.clear();
        User deletedUser = entityManager.find(User.class, id);
        Assert.assertNull(deletedUser);
    }

    @Test
    public void testUpdate(){
        // Given
        User user = new User("Ann", "Lee", 23, null);
        User newUser = new User("UpdatedAnn", "Eel", 32, null);

        entityManager.persist(user);

        // When
        userDAO.update(user.getId(), newUser);

        // Then
        User actualUser = entityManager.find(User.class, user.getId());

        Assert.assertEquals(newUser, actualUser);
    }

    @Test
    public void testCreate(){
        //Given
        User user = new User("Ann", "Lee", 23, null);

        //When
        userDAO.create(user);

        //Then
        User actualUser = entityManager.find(User.class, user.getId());
        Assert.assertEquals(user, actualUser);
    }

    @Test
    public void testFindAll(){
        //Given
        User user1 = new User("Ann", "Lee", 23, null);
        User user2 = new User("UpdatedAnn", "Eel", 32, null);

        List<User> allExpectedUsers = Arrays.asList(user1, user2);
//        entityManager.persist(user1);
//        entityManager.persist(user2);

//Как две строки сверху, только через СТРИМЫ...
        allExpectedUsers.forEach(entityManager::persist);

        //When
        List<User> allActualUsers = userDAO.findAll();

        //Then
        Assert.assertEquals(2, allActualUsers.size());
        Assert.assertTrue(allActualUsers.containsAll(allExpectedUsers));

    }

}
