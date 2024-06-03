package com.delivery.app.user.service;

import com.delivery.app.user.dto.RestaurantDTO;
import com.delivery.app.user.mapper.RestaurantMapper;
import com.delivery.app.user.model.Restaurant;
import com.delivery.app.user.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant register(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = RestaurantMapper.toEntity(restaurantDTO);
        return restaurantRepository.save(restaurant);
    }
}
