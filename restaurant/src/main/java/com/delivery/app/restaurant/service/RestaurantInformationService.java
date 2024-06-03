package com.delivery.app.restaurant.service;

import com.delivery.app.restaurant.dto.RestaurantInformationDTO;
import com.delivery.app.restaurant.exceptions.RestaurantNotFoundException;
import com.delivery.app.restaurant.mapper.RestaurantInformationMapper;
import com.delivery.app.restaurant.model.RestaurantInformation;
import com.delivery.app.restaurant.repository.RestaurantInformationRepository;
import com.delivery.app.user.model.Restaurant;
import com.delivery.app.user.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RestaurantInformationService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantInformationRepository restaurantInformationRepository;

    @Autowired
    public RestaurantInformationService(
            RestaurantRepository restaurantRepository,
            RestaurantInformationRepository restaurantInformationRepository) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantInformationRepository = restaurantInformationRepository;
    }

    @Transactional
    public RestaurantInformationDTO updateRestaurantInformation(RestaurantInformationDTO restaurantInformationDTO) throws RestaurantNotFoundException {
        Restaurant restaurant = restaurantRepository.findById(restaurantInformationDTO.getId()).orElse(null);
        if (Objects.isNull(restaurant)) {
            throw new RestaurantNotFoundException("Restaurant does not exists.");
        }

        RestaurantInformation restaurantInformation = RestaurantInformationMapper.toEntity(restaurantInformationDTO);
        restaurantInformation.setRestaurant(restaurant);

        restaurantInformationRepository.save(restaurantInformation);
        return restaurantInformationDTO;
    }
}
