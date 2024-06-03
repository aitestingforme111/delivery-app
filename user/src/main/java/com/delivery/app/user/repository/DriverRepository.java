package com.delivery.app.user.repository;

import com.delivery.app.user.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    // Additional custom queries, if needed
}
