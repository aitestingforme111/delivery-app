package com.delivery.app.restaurant.rabbitmq;

import com.delivery.app.order.dto.OrderDTO;
import com.delivery.app.rabbitmq.config.RabbitMqConfig;
import com.delivery.app.restaurant.processing.ProcessOrder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
@Service
public class OrderStatusConsumer {

    private final ProcessOrder orderProcessor;

    @Autowired
    public OrderStatusConsumer(ProcessOrder orderProcessor) {
        this.orderProcessor = orderProcessor;
    }

    @RabbitListener(queues = RabbitMqConfig.ORDER_QUEUE)
    public void receiveMessage(OrderDTO orderDTO) {
        System.out.println("Order no: " + orderDTO.getOrderId() + " status in restaurant: " + orderDTO.getOrderStatus());

        CompletableFuture<OrderDTO> processedOrderFuture = orderProcessor.processOrder(orderDTO);
        processedOrderFuture.thenAccept(processedOrderDTO -> {
            // Further processing or logging
            System.out.println("Order is ready for delivery, sent to order service: " + processedOrderDTO);
        });
    }
}
