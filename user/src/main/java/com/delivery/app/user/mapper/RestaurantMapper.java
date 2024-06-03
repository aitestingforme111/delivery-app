package com.delivery.app.user.mapper;

import com.delivery.app.user.dto.RestaurantDTO;
import com.delivery.app.user.model.Restaurant;

public abstract class RestaurantMapper {

    public static RestaurantDTO toDTO(Restaurant restaurant) {
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(restaurant.getId());
        restaurantDTO.setUsername(restaurant.getUsername());
        restaurantDTO.setRole(restaurant.getRole());
        restaurantDTO.setLatitude(restaurant.getLatitude());
        restaurantDTO.setLongitude(restaurant.getLongitude());
        restaurantDTO.setRestaurantName(restaurant.getRestaurantName());
        restaurantDTO.setLocation(restaurant.getLocation());
        return restaurantDTO;
    }

    public static Restaurant toEntity(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(restaurantDTO.getId());
        restaurant.setUsername(restaurantDTO.getUsername());
        restaurant.setPassword(restaurantDTO.getPassword());
        restaurant.setRole(restaurantDTO.getRole());
        restaurant.setLatitude(restaurantDTO.getLatitude());
        restaurant.setLongitude(restaurantDTO.getLongitude());
        restaurant.setRestaurantName(restaurantDTO.getRestaurantName());
        restaurant.setLocation(restaurantDTO.getLocation());
        return restaurant;
    }
}
