package com.delivery.app.user.mapper;

import com.delivery.app.user.dto.CustomerDTO;
import com.delivery.app.user.model.Customer;

public abstract class CustomerMapper {

    public static CustomerDTO toDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setUsername(customer.getUsername());
        customerDTO.setRole(customer.getRole());
        customerDTO.setLatitude(customer.getLatitude());
        customerDTO.setLongitude(customer.getLongitude());
        customerDTO.setAddress(customer.getAddress());
        return customerDTO;
    }

    public static Customer toEntity(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setUsername(dto.getUsername());
        customer.setPassword(dto.getPassword());
        customer.setRole(dto.getRole());
        customer.setLatitude(dto.getLatitude());
        customer.setLongitude(dto.getLongitude());
        customer.setAddress(dto.getAddress());
        return customer;
    }
}
