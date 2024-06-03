package com.delivery.app.user.service;

import com.delivery.app.user.dto.DriverDTO;
import com.delivery.app.user.mapper.DriverMapper;
import com.delivery.app.user.model.Driver;
import com.delivery.app.user.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver register(DriverDTO driverDTO) {
        Driver driver = DriverMapper.toEntity(driverDTO);
        return driverRepository.save(driver);
    }
}
