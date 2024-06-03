package com.delivery.app.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class RestaurantDTO extends UserDTO {
    @NotBlank(message = "Restaurant name is mandatory")
    private String restaurantName;

    @NotBlank(message = "Location is required")
    private String location;
}
