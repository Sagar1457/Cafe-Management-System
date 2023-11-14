package project.ServiceImp;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.Entity.Cart;
import project.JpaRepository.CartJpa;

@Service
public class CartServiceImp {

	@Autowired
	private CartJpa  cartdao;
	
	public Cart savecart(Long id,Cart cart) {
		Cart ncart=cartdao.findById(id).get();
		if(cart.getUser()!=null)
		{
			ncart.setUser(cart.getUser());
		}
		cartdao.save(ncart);
		return ncart;
	}
	
	public List<Cart> getallcarts()
	{
		List<Cart> carts=cartdao.findAll();
		return carts;
	}
	
	/*public float totalpriceincart() {
		
	}*/
	
}
