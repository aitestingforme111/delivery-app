package com.delivery.app.restaurant.model;

import com.delivery.app.user.model.Restaurant;
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
public class RestaurantInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Restaurant restaurant;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Dish> dishes;
}
