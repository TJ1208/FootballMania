package com.fbmania.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productId")
	private long productId;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="price", nullable=false)
	private BigDecimal price;
	
	@Column(name="quantity", nullable=false)
	private long quantity;
	
	@Column(name="image", nullable=false)
	@Lob
	private String image;
	
	@ManyToMany(mappedBy="products", cascade = {CascadeType.ALL})
	@JsonIgnore
	List<Order> orders;
	
	@ManyToOne()
	@JoinColumn(nullable=false, name="categoryId")
	private Category category;
	
	@OneToMany(mappedBy="product")
	@JsonIgnore
	private List<UserCart> userCart;

}
