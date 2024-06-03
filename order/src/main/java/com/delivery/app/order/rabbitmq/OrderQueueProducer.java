package com.delivery.app.order.rabbitmq;

import com.delivery.app.rabbitmq.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderQueueProducer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public OrderQueueProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrder(Object orderDTO) {
        rabbitTemplate.convertAndSend(RabbitMqConfig.ORDER_QUEUE, orderDTO);
    }
}
