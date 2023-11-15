package project.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.Entity.Products;
import project.Entity.Users;

public interface ProductJpa extends JpaRepository<Products, Long> {	
	
}
