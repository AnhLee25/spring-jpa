package com.example.springjpapratice.service.impl;

import com.example.springjpapratice.dto.CustomerAccountDTO;
import com.example.springjpapratice.dto.resquest.CustomerAccountSearch;
import com.example.springjpapratice.entity.CustomerAccount;
import com.example.springjpapratice.exception.DuplicateDataException;
import com.example.springjpapratice.exception.NotFoundException;
import com.example.springjpapratice.repository.ICustomerAccountRepository;
import com.example.springjpapratice.service.ICustomerAccountService;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(rollbackOn = {Exception.class})
public class CustomerAccountServiceImpl implements ICustomerAccountService {
  private final ICustomerAccountRepository customerAccountRepository;
  private final ModelMapper modelMapper = new ModelMapper();

  public void createNewCustomerAccount(CustomerAccountDTO account) throws DuplicateDataException {
    if (customerAccountRepository.existsByUsername(account.getUsername())) {
      throw new DuplicateDataException("account.username-exist");
    }

    customerAccountRepository.save(modelMapper.map(account, CustomerAccount.class));
  }

  public void deleteCustomerAccount(Long id) {
    CustomerAccount account =
        customerAccountRepository
            .findById(id)
            .orElseThrow(() -> new NotFoundException("account.not-found"));
    customerAccountRepository.delete(account);
  }

  public void updateCustomerAccount(CustomerAccountDTO customerAccount) {
    CustomerAccount account =
        customerAccountRepository
            .findById(customerAccount.getId())
            .orElseThrow(() -> new NotFoundException("account.not-found"));
    customerAccountRepository.save(modelMapper.map(account, CustomerAccount.class));
  }

  public List<CustomerAccountDTO> getCustomerAccount(CustomerAccountSearch search) {
    List<CustomerAccount> customerAccounts =
        customerAccountRepository.findAll(createSearchCriteria(search));
    return customerAccounts.stream()
        .map(account -> modelMapper.map(account, CustomerAccountDTO.class))
        .collect(Collectors.toList());
  }

  private Specification<CustomerAccount> createSearchCriteria(CustomerAccountSearch search) {
    return (root, query, cb) -> {
      List<Predicate> predicates = new ArrayList<>();
      if (search.getStatus() != null) {
        predicates.add(cb.equal(root.get("status"), search.getStatus()));
      }
      if (!search.getUsername().isEmpty()) {
        predicates.add(cb.like(root.get("username"), "%" + search.getUsername() + "%"));
      }
      if (!search.getPassword().isEmpty()) {
        predicates.add(cb.like(root.get("password"), "%" + search.getPassword() + "%"));
      }
      return cb.and(predicates.toArray(new Predicate[0]));
    };
  }
}
