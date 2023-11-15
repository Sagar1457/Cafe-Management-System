package project.ServiceImp;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import project.Entity.Cart;
import project.Entity.Products;
import project.Entity.Users;
import project.JpaRepository.CartJpa;
import project.JpaRepository.ProductJpa;
import project.service.ProdcutsService;

@Service
public class ProductServiceImp implements ProdcutsService {
	 
	@Autowired
	private ProductJpa productdao;
	
	@Autowired
	private CartJpa cartdao;
	
	@Transactional
	public Products addproduct(Products product) {
		productdao.save(product);
		return product;
	}
	
	@Transactional
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
	
	@Transactional
	 public List<Products> getProductsInCart(Long cartId) {
	        Cart cart = cartdao.findById(cartId)
	                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id: " + cartId));

	        return cart.getProducts();
	    }
	
	@Transactional
	public List<Products> getallproduct(){
		List<Products> products=productdao.findAll();
		return products;
	}

	@Transactional
	public String Deleteproduct(Long id) {
		try {
			Products product=productdao.findById(id).get();
			productdao.delete(product);
			return "Product Deleted";
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"product not found with id="+id);
		}
	}
	
	@Transactional
	public Products findById(Long id) {
		try {
		Products product=productdao.findById(id).get();
		return product;
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"product not found with id="+id);
		}
	}

	public Products Updateproduct(Long id, Products product) {
		try {
			Products upproduct=productdao.findById(id).get();
			if(product.getProduct_name()!=null) {
				upproduct.setProduct_name(product.getProduct_name());
			}
			if(product.getProduct_price()!=0) {
				upproduct.setProduct_price(product.getProduct_price());
			}
			productdao.save(upproduct);
			return upproduct;
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"product not found with id="+id);
		}
	}
		
}
