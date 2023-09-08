package com.example.springjpapratice.repository;

import com.example.springjpapratice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository
    extends JpaRepository<Customer, Long>, PagingAndSortingRepository<Customer, Long> {
  boolean existsById(Long id);
}
