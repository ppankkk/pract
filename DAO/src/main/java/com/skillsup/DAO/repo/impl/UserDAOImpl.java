package com.skillsup.DAO.repo.impl;

import com.skillsup.DAO.model.User;
import com.skillsup.DAO.repo.UserDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDAOImpl implements UserDAO{

    private final Map<Long,User> userMap = new HashMap<>();
    private static volatile long idGenerator =1L;
    @Override
    public void create(User user) {
        user.setId(idGenerator++);
        userMap.put(user.getId(),user);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }

    public Map<Long, User> getUserMap() {
        return userMap;
    }
}
