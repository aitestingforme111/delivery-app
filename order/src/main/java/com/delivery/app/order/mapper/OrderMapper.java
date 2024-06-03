package com.delivery.app.order.mapper;

import com.delivery.app.order.dto.OrderDTO;
import com.delivery.app.order.model.Order;

public abstract class OrderMapper {
    public static Order toEntity(OrderDTO orderDTO) {
        Order orderEntity = new Order();
        orderEntity.setOrderId(orderDTO.getOrderId());
        orderEntity.setUserId(orderDTO.getUserId());
        orderEntity.setRestaurantId(orderDTO.getRestaurantId());
        orderEntity.setOrderedItems(orderDTO.getOrderedItems());
        orderEntity.setOrderStatus(orderDTO.getOrderStatus());
        return orderEntity;
    }

    public static OrderDTO toDTO(Order orderEntity) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(orderEntity.getOrderId());
        orderDTO.setUserId(orderEntity.getUserId());
        orderDTO.setRestaurantId(orderEntity.getRestaurantId());
        orderDTO.setOrderedItems(orderEntity.getOrderedItems());
        orderDTO.setOrderStatus(orderEntity.getOrderStatus());
        return orderDTO;
    }
}
