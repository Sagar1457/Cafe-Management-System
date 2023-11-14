package project.ServiceImp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import project.Entity.Cart;
import project.Entity.Users;
import project.JpaRepository.UserJpa;
import project.service.Userservice;

@Service
public class UserServiceImp implements Userservice {
	
	@Autowired
	private UserJpa userdao;
	
	@Transactional
	public Users newuser(Users user) {
		Cart cart=new Cart();
		user.setCart(cart);
		userdao.save(user);
		cart.setUser(user);
		return user;
	}
	
	@Transactional
	public List<Users> getallusers(){
		List<Users> users=userdao.findAll();
		return users;
	}
	
	@Transactional
	public Users GetById(Long id) {
		Users user=userdao.findById(id).get();
		return user;
	}
	
	@Transactional
	public Users updateuser(Long id,Users user) {
		userdao.findById(id).get();
		if(user.getNumber()!=null) {
			user.setEmail(user.getEmail());
		}
		if(user.getNumber()!=null) {
			user.setNumber(user.getNumber());
		}
		userdao.save(user);
		return user;
	}
	
	@Transactional
	public String deleteuser(Long id) {
		try
		{
			Users user=userdao.findById(id).get();
			userdao.delete(user);
			return "users removed";
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Users finduser(String username) {
		try {
				Users user=userdao.findByUsername(username);
				return user;
			}catch(Exception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
		
	}
	
	@Override
	public Users login(String username, String password) 
	{
		 Users user=userdao.findByUsernameAndPassword(username, password);
		 return user;
	}



}
