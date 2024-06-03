package com.delivery.app.user.service;

import com.delivery.app.user.dto.CustomerDTO;
import com.delivery.app.user.mapper.CustomerMapper;
import com.delivery.app.user.model.Customer;
import com.delivery.app.user.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer register(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.toEntity(customerDTO);
        return customerRepository.save(customer);
    }
}
