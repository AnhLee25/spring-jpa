package com.example.springjpapratice.repository;

import com.example.springjpapratice.entity.OrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderItemRepository extends PagingAndSortingRepository<OrderItem, Long> {
    @Override
    Page<OrderItem> findAll(Pageable pageable);
}
