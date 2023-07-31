package com.filrouge.filrouge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filrouge.filrouge.Model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    
}
