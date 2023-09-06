package com.example.springjpapratice.service;

import com.example.springjpapratice.dto.CustomerDTO;
import com.example.springjpapratice.exception.DuplicateDataException;
import org.springframework.data.domain.Page;

public interface ICustomerService {
    Page<CustomerDTO> getAllCustomer(Integer pageNumber, Integer pageSize);
    void createCustomer(CustomerDTO customerDTO) throws DuplicateDataException;
}
