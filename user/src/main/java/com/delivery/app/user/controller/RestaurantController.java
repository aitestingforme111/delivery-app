package com.delivery.app.user.controller;

import com.delivery.app.user.dto.CustomerDTO;
import com.delivery.app.user.dto.RestaurantDTO;
import com.delivery.app.user.service.CustomerService;
import com.delivery.app.user.service.RestaurantService;
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
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerRestaurant(@Validated @RequestBody RestaurantDTO restaurantDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        restaurantService.register(restaurantDTO);
        return new ResponseEntity<>("Restaurant registered successfully", HttpStatus.CREATED);
    }
}