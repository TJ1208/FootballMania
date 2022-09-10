package com.fbmania.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fbmania.model.Order;
import com.fbmania.repo.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepo repo;
	
	public List<Order> getAllOrders() {
		return repo.findAll();
	}

	public Order getOrderById(Long id) throws Exception {
		return repo.findById(id).orElseThrow(() -> new Exception("Order not found with id: " + id));
	}

	public ResponseEntity<String> addOrder(Order order) {
		repo.save(order);
		return ResponseEntity.status(HttpStatus.OK).body("Order added successfully.");
	}

	public ResponseEntity<String> updateOrder(Order order) {
		if(repo.findById(order.getOrderId()).isPresent()) {
			repo.save(order);
			return ResponseEntity.status(HttpStatus.OK)
				.body("Order updated successfully.");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("An error occurred while updating Order.");
	}
	
	public ResponseEntity<String> deleteOrder(Long id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK)
				.body("Order deleted successfully.");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("An error occurred while trying to remove Order.");
	}

}
