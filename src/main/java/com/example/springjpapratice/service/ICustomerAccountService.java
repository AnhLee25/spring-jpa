package com.example.springjpapratice.service;

import com.example.springjpapratice.dto.CustomerAccountDTO;
import com.example.springjpapratice.dto.resquest.CustomerAccountSearch;
import com.example.springjpapratice.entity.CustomerAccount;
import com.example.springjpapratice.exception.DuplicateDataException;

import java.util.List;

public interface ICustomerAccountService {
  List<CustomerAccountDTO> getCustomerAccount(CustomerAccountSearch search);

  void updateCustomerAccount(CustomerAccountDTO customerAccount);

  void deleteCustomerAccount(Long id);

  void createNewCustomerAccount(CustomerAccountDTO account) throws DuplicateDataException;
}
