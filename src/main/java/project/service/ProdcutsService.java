package project.service;

import java.util.Collection;
import java.util.List;

import project.Entity.Products;

public interface ProdcutsService {
	Collection<Products> findByCategory(String category);
	Products findByProductName(String productName);
}
