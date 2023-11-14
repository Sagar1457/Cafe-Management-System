package project.ServiceImp;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.Entity.Category;
import project.Entity.Products;
import project.JpaRepository.CategoryJpa;
import project.JpaRepository.ProductJpa;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryJpa categorydao;
	
	@Autowired
	private ProductJpa productdao;
	
	public List<Category> getallcategory(){
		List<Category> categories=categorydao.findAll();
		return categories;
	}
	
	public Category addcategory(Category category) {
		categorydao.save(category);
		return category;
		
	}
	
	public String addCategoryToProduct(Long productId, Long categoryId) {
        Products product = productdao.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));

        Category category = categorydao.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id: " + categoryId));

        category.getProducts().add(product);
        product.setCategory(category);
        categorydao.save(category);
        productdao.save(product);
        return "product added to category";
    }
	
	 public List<Products> getProductsInCategory(Long categoryId) {
	        Category category = categorydao.findById(categoryId)
	                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id: " + categoryId));

	        return category.getProducts();
	    }
}
