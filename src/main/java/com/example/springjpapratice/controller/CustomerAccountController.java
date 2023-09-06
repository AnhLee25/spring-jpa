package com.example.springjpapratice.controller;

import com.example.springjpapratice.dto.CustomerAccountDTO;
import com.example.springjpapratice.dto.resquest.CustomerAccountSearch;
import com.example.springjpapratice.exception.DuplicateDataException;
import com.example.springjpapratice.service.ICustomerAccountService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer-account")
@RequiredArgsConstructor
public class CustomerAccountController {
  private final ICustomerAccountService customerAccountService;

  @GetMapping("/get-data")
  ResponseEntity<List<CustomerAccountDTO>> getCustomerAccount(
      @RequestBody CustomerAccountSearch account) {
    return ResponseEntity.ok(customerAccountService.getCustomerAccount(account));
  }

  @DeleteMapping("/delete")
  ResponseEntity<?> getCustomerAccount(@NotNull @RequestParam Long id) {
    customerAccountService.deleteCustomerAccount(id);
    return ResponseEntity.ok(null);
  }

  @PostMapping("/create")
  ResponseEntity<?> createCustomerAccount(@NotNull @RequestBody CustomerAccountDTO account)
      throws DuplicateDataException {
    customerAccountService.createNewCustomerAccount(account);
    return ResponseEntity.ok(null);
  }

  @PutMapping("/update")
  ResponseEntity<?> updateCustomerAccount(@RequestBody CustomerAccountDTO account) {
    customerAccountService.updateCustomerAccount(account);
    return ResponseEntity.ok(null);
  }
}
