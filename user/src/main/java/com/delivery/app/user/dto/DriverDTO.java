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
public class DriverDTO extends UserDTO {
    @NotBlank(message = "Vehicle details are mandatory")
    private String vehicleDetails;
}
