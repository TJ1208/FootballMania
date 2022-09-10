package com.fbmania.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fbmania.model.Order;


public interface OrderRepo extends JpaRepository<Order, Long> {

}
