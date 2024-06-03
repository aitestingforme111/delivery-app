package com.delivery.app.order.rabbitmq;

import com.delivery.app.order.dto.OrderDTO;
import com.delivery.app.order.model.OrderStatus;
import com.delivery.app.rabbitmq.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantStatusConsumer {

    private final StatusProducer statusProducer;

    @Autowired
    public RestaurantStatusConsumer(StatusProducer statusProducer) {
        this.statusProducer = statusProducer;
    }

    @RabbitListener(queues = RabbitMqConfig.RESTAURANT_QUEUE)
    public void receiveMessage(OrderDTO orderDTO) {
        System.out.println("Order no: " + orderDTO.getOrderId() + " status in order: " + orderDTO.getOrderStatus());

        if (orderDTO.getOrderStatus() == OrderStatus.PLACED) {
            statusProducer.sendOrder(orderDTO);
        }
        if (orderDTO.getOrderStatus() == OrderStatus.READY_TO_DELIVER) {
            orderDTO.setOrderStatus(OrderStatus.DISPATCHED);
            statusProducer.sendOrder(orderDTO);
        }
        if (orderDTO.getOrderStatus() == OrderStatus.ACCEPTED) {
            orderDTO.setOrderStatus(OrderStatus.DELIVERED);
            statusProducer.sendOrder(orderDTO);
        }
    }
}
