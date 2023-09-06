package com.example.springjpapratice.service.impl;

import com.example.springjpapratice.dto.CustomerDTO;
import com.example.springjpapratice.entity.Customer;
import com.example.springjpapratice.exception.DuplicateDataException;
import com.example.springjpapratice.exception.NotFoundException;
import com.example.springjpapratice.repository.ICustomerRepository;
import com.example.springjpapratice.service.ICustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(rollbackOn = {Exception.class, DuplicateDataException.class, NotFoundException.class})
public class CustomerServiceImpl implements ICustomerService {
    private final ICustomerRepository customerRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Page<CustomerDTO> getAllCustomer(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Customer> customerPage = customerRepository.findAll(pageable);
        List<CustomerDTO> customerRespons = customerPage
                .stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
        return new PageImpl<>(customerRespons, pageable, customerPage.getTotalElements());
    }

    @Override
    public void createCustomer(CustomerDTO customerDTO) throws DuplicateDataException {
        if (customerRepository.existsById(customerDTO.getId())) {
            throw new DuplicateDataException("customer.exist");
        }
        customerRepository.save(modelMapper.map(customerDTO, Customer.class));
    }

}
