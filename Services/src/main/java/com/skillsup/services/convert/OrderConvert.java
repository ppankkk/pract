package com.skillsup.services.convert;

import com.skillsup.DAO.model.Order;
import com.skillsup.services.DTO.OrderDTO;

public interface OrderConvert {
    Order toEntity(OrderDTO dto);
    OrderDTO toDto(Order entity);
}
