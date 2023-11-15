package project.DTO;

import java.util.List;

import lombok.Data;
import project.Entity.Products;
import project.Entity.Users;

@Data
public class CartDTO {
	
	private Long Id;
	
	private Users user;

	private List<Products> products;
}
