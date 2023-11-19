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
		if(users.size()!=0) {
		return users;}
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"users not found");
	}
	
	@Transactional
	public Users GetById(Long id) {
		try {
		Users user=userdao.findById(id).get();
		return user;
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user not found");
		}
	}
	
	@Transactional
	public Users updateuser(Long id,Users user) {
		try {
		Users upuser=userdao.findById(id).get();
		if(user.getEmail()!=null) {
			upuser.setEmail(user.getEmail());
		}
		if(user.getNumber()!=null) {
			upuser.setNumber(user.getNumber());
		}
		if(user.getFullname()!=null) {
			upuser.setFullname(user.getFullname());
		}
		if(user.getAddress()!=null) {
			upuser.setAddress(user.getAddress());
		}
		userdao.save(upuser);
		return upuser;
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user not found");
		}
	}
	
	@Transactional
	public Users deleteuser(Long id) {
		try
		{
			Users user=userdao.findById(id).get();
			userdao.delete(user);
			return user;
		}catch(Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user not found");
		}
	}

	@Override
	public Users finduser(String username) {
		try {
				Users user=userdao.findByUsername(username);
				return user;
			}catch(Exception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"username not found");
			}
		
	}
	
	@Override
	public Users login(String username, String password) 
	{	
		 Users user=userdao.findByUsernameAndPassword(username, password);
		 return user;
	}



}
