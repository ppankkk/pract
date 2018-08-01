package com.skillsup.services;

import com.skillsup.services.DTO.OrderDTO;
import com.skillsup.services.DTO.UserDTO;

import java.util.List;

public interface OrderService {
    void create(OrderDTO order);
    List<OrderDTO> findAll();
    List<OrderDTO> findAllUserOrders(UserDTO user);
    void delete(Long id);
    void update(Long id, OrderDTO order);
    OrderDTO get(Long id);
}
