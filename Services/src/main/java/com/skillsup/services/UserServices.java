package com.skillsup.services;

//import com.skillsup.DAO.model.User;
import com.skillsup.services.DTO.UserDTO;

import java.util.List;

public interface UserServices {
    void create(UserDTO user);
    List<UserDTO> findAll();
    void delete(Long id);
    void update(Long id, UserDTO user);
    UserDTO get(Long id);
}
