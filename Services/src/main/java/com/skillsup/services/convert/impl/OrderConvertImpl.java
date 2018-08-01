package com.skillsup.services.convert.impl;

import com.skillsup.DAO.model.Order;
import com.skillsup.services.DTO.OrderDTO;
import com.skillsup.services.convert.OrderConvert;
import org.springframework.stereotype.Component;

@Component
public class OrderConvertImpl implements OrderConvert {
    @Override
    public Order toEntity(OrderDTO dto) {
        return new Order(dto.getUser(), dto.getProducts(), dto.getStatus(), dto.getDate(), null);
    }

    @Override
    public OrderDTO toDto(Order entity) {
        return new OrderDTO(entity.getUser(), entity.getProducts(), entity.getStatus(), entity.getDate());
    }
}