package com.example.springjpapratice.repository;

import com.example.springjpapratice.entity.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerAccountRepository
    extends JpaRepository<CustomerAccount, Long>,
        JpaSpecificationExecutor<CustomerAccount>,
        PagingAndSortingRepository<CustomerAccount, Long> {
  boolean existsByUsername(String username);
}
