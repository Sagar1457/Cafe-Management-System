package project.ServiceImp;


import java.util.Collection;
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
	public Cart addProductToCart(Long productId, Long cartId) {
        Products product = productdao.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));

        Cart cart = cartdao.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id: " + cartId));

        cart.getProducts().add(product);
        product.getCart().add(cart);
        cartdao.save(cart);
        productdao.save(product);
        return cart;
    }
	
	@Transactional
	public Cart deleteproductincart(Long productid,Long cartId) {
        Products product = productdao.findById(productid)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productid));

        Cart cart = cartdao.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id: " + cartId));
        int i=cart.getProducts().indexOf(product);
        cart.getProducts().remove(i);
        int j=product.getCart().indexOf(cart);
        product.getCart().remove(j);
        cartdao.saveAndFlush(cart);
        productdao.saveAndFlush(product);
        return cart;
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
	public Products Deleteproduct(Long id) {
		try {
			Products product=productdao.findById(id).get();
			productdao.delete(product);
			return product;
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
	
	@Transactional
	public Products Updateproduct(Long id, Products product) {
		try {
			Products upproduct=productdao.findById(id).get();
			if(product.getProductName()!=null) {
				upproduct.setProductName(product.getProductName());
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
	
	@Override
	public Products findByProductName(String productName) {
		try {
			Products product=productdao.findByProductName(productName);
			return product;
		}catch(Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"product not found with product="+productName);
		}
	}

	@Override
	public Collection<Products> findByCategory(String category) {
		try {
			Collection<Products> product=productdao.findByCategory(category);
			return product;
		}catch(Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"product not found with category="+category);
		}
	}
		
}
