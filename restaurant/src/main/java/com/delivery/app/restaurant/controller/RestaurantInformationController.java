package com.delivery.app.restaurant.controller;

import com.delivery.app.restaurant.dto.RestaurantInformationDTO;
import com.delivery.app.restaurant.exceptions.RestaurantNotFoundException;
import com.delivery.app.restaurant.service.RestaurantInformationService;
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
@RequestMapping("/api/restaurant")
public class RestaurantInformationController {

    private final RestaurantInformationService restaurantInformationService;

    @Autowired
    public RestaurantInformationController(RestaurantInformationService restaurantInformationService) {
        this.restaurantInformationService = restaurantInformationService;
    }

    @PostMapping("/update")
    public ResponseEntity<Object> addRestaurantInformation(@Validated @RequestBody RestaurantInformationDTO restaurantInformationDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        try {
            restaurantInformationService.updateRestaurantInformation(restaurantInformationDTO);
            return new ResponseEntity<>("Customer registered successfully", HttpStatus.CREATED);
        } catch (RestaurantNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CREATED);
        }
    }
}
