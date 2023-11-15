package project.Entity;


import java.util.List;


import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private Users user;
	
	@ManyToMany(mappedBy="cart",cascade = CascadeType.ALL)
	private List<Products> products;
	
}
