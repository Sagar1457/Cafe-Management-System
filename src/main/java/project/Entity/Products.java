package project.Entity;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Products {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long product_id;
	
	private String product_name;
	
	private float product_price;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="products_cart",
	joinColumns=@JoinColumn(name="product_id"),
	inverseJoinColumns=@JoinColumn(name="cart_id"))
	private List<Cart> cart;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
		
}
