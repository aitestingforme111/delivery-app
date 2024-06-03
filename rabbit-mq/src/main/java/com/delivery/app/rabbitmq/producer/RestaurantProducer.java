package com.delivery.app.rabbitmq.producer;

import com.delivery.app.rabbitmq.config.RabbitMqConfig;
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

    public void sendOrder(Object orderDTO) {
        rabbitTemplate.convertAndSend(RabbitMqConfig.RESTAURANT_QUEUE, orderDTO);
    }
}
