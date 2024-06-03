package com.delivery.app.user.rabbitmq;

import com.delivery.app.order.dto.OrderDTO;
import com.delivery.app.order.model.OrderStatus;
import com.delivery.app.rabbitmq.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class StatusConsumer {

    private final UserOrderProducer orderProducer;

    public StatusConsumer(UserOrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @RabbitListener(queues = RabbitMqConfig.STATUS_QUEUE)
    public void receiveMessage(OrderDTO orderDTO) {
        System.out.println("Order no: " + orderDTO.getOrderId() + " status in user: " + orderDTO.getOrderStatus());

        if (orderDTO.getOrderStatus() == OrderStatus.DISPATCHED) {
            orderDTO.setOrderStatus(OrderStatus.ACCEPTED);
            orderProducer.sendOrder(orderDTO);
        }
    }
}
