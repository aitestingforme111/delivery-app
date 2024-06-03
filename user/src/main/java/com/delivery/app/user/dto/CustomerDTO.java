package com.delivery.app.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class CustomerDTO extends UserDTO {
    @NotBlank(message = "Address is mandatory")
    private String address;
}