package project.JpaRepository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.Entity.Products;
import project.Entity.Users;

public interface ProductJpa extends JpaRepository<Products, Long> {	
	Products findByProductName(String productName);
	
	Collection<Products> findByCategory(String category);
}
