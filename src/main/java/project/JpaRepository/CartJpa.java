package project.JpaRepository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import project.Entity.Cart;
import project.Entity.Products;
import project.Entity.Users;
import project.Entity.Products;

public interface CartJpa extends JpaRepository<Cart, Long>{
	List<Cart> findByUser(Users user);


}
