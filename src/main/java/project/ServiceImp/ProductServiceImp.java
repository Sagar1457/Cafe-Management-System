package project.ServiceImp;

import java.util.List;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.Entity.Cart;
import project.Entity.Products;
import project.JpaRepository.CartJpa;
import project.JpaRepository.ProductJpa;

@Service
public class ProductServiceImp {
	 
	@Autowired
	private ProductJpa productdao;
	
	@Autowired
	private CartJpa cartdao;
	
	
	public Products addproduct(Products product) {
		productdao.save(product);
		return product;
	}
	
	public String addProductToCart(Long productId, Long cartId) {
        Products product = productdao.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));

        Cart cart = cartdao.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id: " + cartId));

        cart.getProducts().add(product);
        product.getCart().add(cart);
        cartdao.save(cart);
        productdao.save(product);
        return "product added to cart";
    }
	
	 public List<Products> getProductsInCart(Long cartId) {
	        Cart cart = cartdao.findById(cartId)
	                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id: " + cartId));

	        return cart.getProducts();
	    }
	
	public List<Products> getallproduct(){
		List<Products> products=productdao.findAll();
		return products;
	}
		
}
