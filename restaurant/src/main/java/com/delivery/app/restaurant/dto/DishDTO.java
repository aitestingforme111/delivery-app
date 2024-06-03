package com.delivery.app.restaurant.dto;

import com.delivery.app.restaurant.model.DishType;
import com.delivery.app.restaurant.model.Spicy;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class DishDTO {
    @NotNull(message = "ID can not be empty.")
    private Long id;
    @NotNull(message = "Dish name can not be null.")
    private String dishName;
    @NotNull(message = "Provide short description.")
    private String shortDescription;
    private DishType dishType;
    private Spicy spicy;
    private List<String> ingredients;
    @NotEmpty(message = "Price can not be empty.")
    private Long price;
}
