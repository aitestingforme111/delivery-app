package com.delivery.app.restaurant.rabbitmq;

import com.delivery.app.order.dto.OrderDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantProducer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RestaurantProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrder(OrderDTO orderDTO) {
        rabbitTemplate.convertAndSend(RestaurantRabbitMqConfig.RESTAURANT_QUEUE, orderDTO);
        //rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, "order", orderDTO);
    }
}
