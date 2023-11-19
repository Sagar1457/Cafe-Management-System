package project.Entity;


import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Products {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long product_id;
	
	@NotNull
	@Column(name="product_name",unique=true)
	private String productName;
	
	@NotNull
	@Column(name="product_price")
	private float product_price;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="products_cart",
	joinColumns=@JoinColumn(name="product_id"),
	inverseJoinColumns=@JoinColumn(name="cart_id"))
	private List<Cart> cart;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="category_id")
	private Category category;
		
}
