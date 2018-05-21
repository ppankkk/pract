package com.skillsup.DAO.repo;

import com.skillsup.DAO.model.User;

import java.util.List;

public interface UserDAO {

    void create(User user);
    List<User> findAll();
    void delete(Long id);
    void update(Long id, User user);
    User get(Long id);
}
