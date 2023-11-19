package project.ServiceImp;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.Entity.Cart;
import project.Entity.Products;
import project.Entity.Users;
import project.Exceptions.EntityNotFoundException;
import project.JpaRepository.CartJpa;
import project.JpaRepository.UserJpa;

@Service
public class CartServiceImp {

	@Autowired
	private CartJpa  cartdao;
	
	@Transactional
	public Cart savecart(Long id,Cart cart) {
		Cart ncart=cartdao.findById(id).get();
		if(cart.getUser()!=null)
		{
			ncart.setUser(cart.getUser());
		}
		cartdao.save(ncart);
		return ncart;
	}
	
	@Transactional
	public List<Cart> getallcarts()
	{
		List<Cart> carts=cartdao.findAll();
		return carts;
	}
	
	@Transactional
	public Cart getCartById(Long Id) {
		try {
		Cart cart=cartdao.findById(Id).get();
		return cart;
		}catch(Exception e) {
			throw new EntityNotFoundException("cart not found with id"+Id);
		}	
	}
}