package com.example.springjpapratice.repository;

import com.example.springjpapratice.entity.OrderCart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<OrderCart, Long> {
}
