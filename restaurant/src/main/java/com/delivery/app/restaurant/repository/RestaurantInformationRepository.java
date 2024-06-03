package com.delivery.app.restaurant.repository;

import com.delivery.app.restaurant.model.RestaurantInformation;
import com.delivery.app.user.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantInformationRepository extends JpaRepository<RestaurantInformation, Long> {

}
