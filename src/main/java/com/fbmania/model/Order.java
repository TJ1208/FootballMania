package com.fbmania.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

enum Status {
	IN_TRANSIT, SHIPPED, DELAYED, DELIVERED 
}

@Entity
@Table(name="orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderId")
	private long orderId;
	
	@Column(name="", nullable=false)
	private Status status;
	
	@Column(name="total", nullable=false)
	private BigDecimal total;
	
	@Column(name="shippingAddress", nullable=false)
	private String shippingAddress;
	
	@Column(name="billingAddress", nullable=false)
	private String billingAddress;
	
	@ManyToOne()
	@JoinColumn(nullable=false, name="userId", referencedColumnName="userId")
	private User user;
	
	@ManyToMany()
	@JoinTable(name="order_product",
	joinColumns= @JoinColumn(name="productId", nullable=false),
	inverseJoinColumns= @JoinColumn(name="orderId", nullable=false))
	@Column(nullable=false)
	private List<Product> products;
	

}
