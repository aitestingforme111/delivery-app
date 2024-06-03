package com.delivery.app.order.dto;

import com.delivery.app.order.model.OrderStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class OrderDTO implements Serializable {
    @NotNull(message = "Order id can not be null.")
    private String orderId;
    @NotNull(message = "User id can not be null.")
    private String userId;
    @NotNull(message = "Restaurant id can not be null.")
    private String restaurantId;
    @NotEmpty(message = "Please select your dishes.")
    private List<String> orderedItems;
    private OrderStatus orderStatus;
}
