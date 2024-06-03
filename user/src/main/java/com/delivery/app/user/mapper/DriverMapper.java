package com.delivery.app.user.mapper;

import com.delivery.app.user.dto.DriverDTO;
import com.delivery.app.user.model.Driver;

public abstract class DriverMapper {

    public static DriverDTO toDTO(Driver driver) {
        DriverDTO driverDTO = new DriverDTO();
        driverDTO.setId(driver.getId());
        driverDTO.setUsername(driver.getUsername());
        driverDTO.setRole(driver.getRole());
        driverDTO.setLatitude(driver.getLatitude());
        driverDTO.setLongitude(driver.getLongitude());
        driverDTO.setVehicleDetails(driver.getVehicleDetails());
        return driverDTO;
    }

    public static Driver toEntity(DriverDTO driverDTO) {
        Driver driver = new Driver();
        driver.setId(driverDTO.getId());
        driver.setUsername(driverDTO.getUsername());
        driver.setPassword(driverDTO.getPassword());
        driver.setRole(driverDTO.getRole());
        driver.setLatitude(driverDTO.getLatitude());
        driver.setLongitude(driverDTO.getLongitude());
        driver.setVehicleDetails(driverDTO.getVehicleDetails());
        return driver;
    }
}
