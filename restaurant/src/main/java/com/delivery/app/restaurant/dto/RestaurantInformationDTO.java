package com.delivery.app.restaurant.dto;

import com.delivery.app.user.dto.RestaurantDTO;
import jakarta.validation.constraints.NotBlank;
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
public class RestaurantInformationDTO {
    @NotNull(message = "Please provide restaurant id.")
    private Long id;
    private List<DishDTO> dishes;
}
