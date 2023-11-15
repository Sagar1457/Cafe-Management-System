package project.Entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="category_name")
	private String name;
	
	@OneToMany(mappedBy="category",cascade = CascadeType.ALL)
	private List<Products> products;
	
}
