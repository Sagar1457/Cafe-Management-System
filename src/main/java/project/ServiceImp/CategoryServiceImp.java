package project.ServiceImp;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import project.Entity.Cart;
import project.Entity.Category;
import project.Entity.Products;
import project.Entity.Users;
import project.JpaRepository.CategoryJpa;
import project.JpaRepository.ProductJpa;

@Service
public class CategoryServiceImp {
	
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
	
	@Transactional
	public Category addCategoryToProduct(Long productId, Long categoryId) {
        Products product = productdao.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));

        Category category = categorydao.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + categoryId));

        category.getProducts().add(product);
        product.setCategory(category);
        categorydao.save(category);
        productdao.save(product);
        return category;
    }
	
	@Transactional
	public Category deleteproductincategory(Long productid,Long categoryId) {
        Category category = categorydao.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + categoryId));
        
        Products product = productdao.findById(productid)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productid));
        int i=category.getProducts().indexOf(product);
        category.getProducts().remove(i);
        categorydao.saveAndFlush(category);
        productdao.save(product);
        return category;
	}
	
	 public List<Products> getProductsInCategory(Long categoryId) {
	        Category category = categorydao.findById(categoryId)
	                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + categoryId));

	        return category.getProducts();
	    }
	 
	 public Category updatecategory(Long id,Category category) {
		 try {
			 Category upcategory=categorydao.findById(id).get();
			 if(category.getName()!=null) {
				 upcategory.setName(category.getName());
			 }
			 if(category.getProducts()!=null) {
				 upcategory.setProducts(category.getProducts());
			 }
			 categorydao.save(upcategory);
			 return upcategory;
		 }catch(Exception e) {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND,"category not found with id="+id);
		 }
	 }
	 
	 public Category Deletecategory(Long id) {
	 try
		{
			Category category=categorydao.findById(id).get();
			categorydao.delete(category);
			return category;
		}catch(Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"category not found with id= "+id);
		}
	 }
	 
	 public Category FindById(Long id) {
		 try {
			 Category category=categorydao.findById(id).get();
			 return category;
		 }catch(Exception e) {
				
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"category not found with id= "+id);
			}
	 }
}
