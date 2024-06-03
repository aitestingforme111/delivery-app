package com.delivery.app.restaurant.processing;

import com.delivery.app.order.dto.OrderDTO;
import com.delivery.app.order.model.OrderStatus;
import com.delivery.app.restaurant.rabbitmq.RestaurantProducer;
import com.delivery.app.restaurant.rabbitmq.RestaurantStatusProducer;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ProcessOrder {

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);
    private final RestaurantProducer orderProducer;
    private final RestaurantStatusProducer statusProducer;

    public ProcessOrder(RestaurantProducer orderProducer, RestaurantStatusProducer statusProducer) {
        this.orderProducer = orderProducer;
        this.statusProducer = statusProducer;
    }

    public CompletableFuture<OrderDTO> processOrder(OrderDTO orderDTO) {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate processing time
            try {
                Thread.sleep(1000);
                orderDTO.setOrderStatus(OrderStatus.CONFIRMED);
                statusProducer.sendOrder(orderDTO);
                Thread.sleep(3000); // 5 seconds
                orderDTO.setOrderStatus(OrderStatus.PREPARING);
                statusProducer.sendOrder(orderDTO);
                Thread.sleep(3000); // 5 seconds
                orderDTO.setOrderStatus(OrderStatus.READY_TO_DELIVER);
                statusProducer.sendOrder(orderDTO);
                orderProducer.sendOrder(orderDTO);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return orderDTO;
        }, executorService);
    }
}
