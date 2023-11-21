package project.ServiceImp;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.Entity.Cart;
import project.Exceptions.EntityNotFoundException;
import project.JpaRepository.CartJpa;

@Service
public class CartServiceImp {

	@Autowired
	private CartJpa  cartdao;
	

	
	@Transactional
	public List<Cart> getallcarts()
	{
		List<Cart> carts=cartdao.findAll();
		return carts;
	}
	
	@Transactional
	public Cart getUsercartById(Long Id) {
		try {
		Cart cart=cartdao.findById(Id).get();
		return cart;
		}catch(Exception e) {
			throw new EntityNotFoundException("cart not found with id"+Id);
		}
	}
	
}