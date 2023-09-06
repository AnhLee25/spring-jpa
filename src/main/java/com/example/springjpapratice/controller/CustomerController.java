package com.example.springjpapratice.controller;

import com.example.springjpapratice.dto.CustomerDTO;
import com.example.springjpapratice.exception.DuplicateDataException;
import com.example.springjpapratice.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
  private final ICustomerService customerService;

  @GetMapping("/get-data")
  ResponseEntity<Page<CustomerDTO>> getCustomers(
      @RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
    return ResponseEntity.ok(customerService.getAllCustomer(pageNumber, pageSize));
  }

  @PostMapping("/create")
  ResponseEntity<?> createCustomer(@RequestBody CustomerDTO customerDTO)
      throws DuplicateDataException {
    customerService.createCustomer(customerDTO);
    return ResponseEntity.ok(null);
  }

  @DeleteMapping("/delete")
  ResponseEntity<?> deleteCustomer(@RequestParam Long customerId) {

    return ResponseEntity.ok(null);
  }

  @PutMapping("/update")
  ResponseEntity<?> updateCustomer(@RequestBody CustomerDTO customerDTO) {

    return ResponseEntity.ok(null);
  }
}
