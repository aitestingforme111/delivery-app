package com.delivery.app.restaurant.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dishName;
    private String shortDescription;
    @Enumerated(EnumType.STRING)
    private DishType dishType;
    @Enumerated(EnumType.STRING)
    private Spicy spicy;
    private Long price;
}
