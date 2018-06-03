package com.skillsup.services.impl;

import com.skillsup.DAO.model.User;
import com.skillsup.DAO.repo.UserDAO;
import com.skillsup.services.DTO.UserDTO;
import com.skillsup.services.UserServices;
import com.skillsup.services.convert.UserConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserServices{
    private final UserDAO userDao;
    private final UserConvert userConvert;

    @Autowired
    public UserServiceImpl(UserDAO userDao,UserConvert userConvert) {
        this.userDao = userDao;
        this.userConvert = userConvert;
    }

    @Override
    @Transactional
    public void create(UserDTO user) {

        userDao.create(userConvert.toEntity(user));
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        List<User> users = userDao.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for(User user: users){
            userDTOS.add(userConvert.toDto(user));
        }
        return userDTOS;
    }

// 21-05-2018 homework
    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void update(Long id, UserDTO user) {
        userDao.update(id, userConvert.toEntity(user));
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO get(Long id) {
        userDao.get(id);
        return null;
    }
}
