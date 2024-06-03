package com.delivery.app.order.service;

import com.delivery.app.order.dto.OrderDTO;
import com.delivery.app.order.mapper.OrderMapper;
import com.delivery.app.order.model.Order;
import com.delivery.app.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDTO placeOrder(OrderDTO orderDTO) {
        Order orderEntity = OrderMapper.toEntity(orderDTO);
        Order savedEntity = orderRepository.save(orderEntity);
        return OrderMapper.toDTO(savedEntity);
    }
}
