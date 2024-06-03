package com.delivery.app.restaurant.exceptions;

public class RestaurantNotFoundException extends Exception {
    public RestaurantNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
