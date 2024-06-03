package com.delivery.app.user.rabbitmq;

import com.delivery.app.order.dto.OrderDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonStatusProducer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public CommonStatusProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrder(OrderDTO orderDTO) {
        rabbitTemplate.convertAndSend(UserRabbitMqConfig.STATUS_QUEUE, orderDTO);
    }
}
