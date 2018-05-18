package com.skillsup.services.convert;

import com.skillsup.DAO.model.User;
import com.skillsup.services.DTO.UserDTO;

public interface UserConvert {
    User toEntity(UserDTO dto);
    UserDTO toDto(User entity);
}
