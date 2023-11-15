package project.DTO;

import java.util.List;

import lombok.Data;
import project.Entity.Cart;
import project.Entity.Category;

@Data
public class ProductsDTO {
	
	private Long product_id;
	
	private String product_name;
	
	private float product_price;
	
	private List<Cart> cart;

	private Category category;
}
