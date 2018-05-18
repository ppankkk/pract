package com.skillsup.services;

import com.skillsup.services.DTO.UserDTO;

import java.util.List;

public interface UserServices {
    void create(UserDTO user);
    List<UserDTO> findAll();

}
