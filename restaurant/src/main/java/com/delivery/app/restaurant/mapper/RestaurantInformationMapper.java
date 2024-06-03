package com.delivery.app.restaurant.mapper;

import com.delivery.app.restaurant.dto.DishDTO;
import com.delivery.app.restaurant.dto.RestaurantInformationDTO;
import com.delivery.app.restaurant.model.Dish;
import com.delivery.app.restaurant.model.RestaurantInformation;

import java.util.ArrayList;
import java.util.List;

public abstract class RestaurantInformationMapper {
    public static RestaurantInformationDTO toDTO(RestaurantInformation restaurantInformation) {
        RestaurantInformationDTO dto = new RestaurantInformationDTO();
        List<DishDTO> dishDTOs = new ArrayList<>();
        for (Dish dish : restaurantInformation.getDishes()) {
            DishDTO dishDTO = new DishDTO();
            dishDTO.setDishName(dish.getDishName());
            dishDTO.setPrice(dish.getPrice());
            dishDTO.setDishType(dish.getDishType());
            dishDTO.setShortDescription(dish.getShortDescription());
            dishDTO.setSpicy(dish.getSpicy());
            dishDTOs.add(dishDTO);
        }
        dto.setDishes(dishDTOs);
        return dto;
    }

    public static RestaurantInformation toEntity(RestaurantInformationDTO restaurantInformationDTO) {
        RestaurantInformation entity = new RestaurantInformation();
        List<Dish> dishes = new ArrayList<>();
        for (DishDTO dishDTO : restaurantInformationDTO.getDishes()) {
            Dish dish = new Dish();
            dish.setDishName(dishDTO.getDishName());
            dish.setPrice(dishDTO.getPrice());
            dish.setDishType(dishDTO.getDishType());
            dish.setShortDescription(dishDTO.getShortDescription());
            dish.setSpicy(dishDTO.getSpicy());
            dishes.add(dish);
        }
        entity.setDishes(dishes);
        return entity;
    }
}
