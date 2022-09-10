package com.fbmania.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fbmania.model.Order;
import com.fbmania.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@GetMapping()
	public List<Order> getAllOrder() {
		return service.getAllOrders();
	}
	
	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable Long id) 
			throws Exception {
		return service.getOrderById(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addOrder(@RequestBody Order order) {
		return service.addOrder(order);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateOrder(@RequestBody Order order) {
		return service.updateOrder(order);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
		return service.deleteOrder(id);
	}
}
