package com.skillsup.DAO.repo;

import com.skillsup.DAO.model.User;

import java.util.List;

public interface UserDAO {

    void create(User user);
    List<User> findAll();
}
