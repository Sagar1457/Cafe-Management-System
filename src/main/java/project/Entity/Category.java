package project.Entity;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	
	@OneToMany(mappedBy="category")
	private List<Products> products;
	
}
