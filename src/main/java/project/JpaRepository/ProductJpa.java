package project.JpaRepository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import project.Entity.Products;

public interface ProductJpa extends JpaRepository<Products, Long> {

	Set<Products> getByProduct_Id(List<Long> productId);
	
}
