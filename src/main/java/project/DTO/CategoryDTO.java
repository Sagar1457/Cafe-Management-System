package project.DTO;

import java.util.List;

import lombok.Data;
import project.Entity.Products;

@Data
public class CategoryDTO {

	private Long id;
	
	private String name;
	
	private List<Products> products;
}
