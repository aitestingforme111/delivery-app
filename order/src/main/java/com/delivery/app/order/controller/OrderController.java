package com.delivery.app.order.controller;

import com.delivery.app.order.dto.OrderDTO;
import com.delivery.app.order.model.OrderStatus;
import com.delivery.app.order.rabbitmq.OrderQueueProducer;
import com.delivery.app.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderQueueProducer orderProducer;

    @Autowired
    public OrderController(OrderService orderService, OrderQueueProducer orderProducer) {
        this.orderService = orderService;
        this.orderProducer = orderProducer;
    }

    @PostMapping("/place")
    public ResponseEntity<Object> placeOrder(@Validated @RequestBody OrderDTO orderDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        orderDTO.setOrderStatus(OrderStatus.PLACED);
        orderService.placeOrder(orderDTO);
        orderProducer.sendOrder(orderDTO);
        return ResponseEntity.ok("Order placed successfully");
    }
}
