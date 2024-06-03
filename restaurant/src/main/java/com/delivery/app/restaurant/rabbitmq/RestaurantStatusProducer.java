package com.delivery.app.restaurant.rabbitmq;

import com.delivery.app.order.dto.OrderDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantStatusProducer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RestaurantStatusProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrder(OrderDTO orderDTO) {
        rabbitTemplate.convertAndSend(RestaurantRabbitMqConfig.STATUS_QUEUE, orderDTO);
    }
}
