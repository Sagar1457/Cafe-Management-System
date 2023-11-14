package project.Controller;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import project.Entity.Users;
import project.ServiceImp.UserServiceImp;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImp userservice;

	//@SuppressWarnings("deprecation")
	@PostMapping("/login")
	public String validate(@RequestBody Users user) throws ServletException
	{
		//String jwtToken="";
		if(user.getUsername()==null || user.getPassword()==null)
		{
			throw new ServletException("Please fill in username and password");
		}
		String username=user.getUsername();
		String password=user.getPassword();
		user=userservice.login(username, password);
		
		if(user==null)
		{
			throw new ServletException("User not found");
		}
		/*jwtToken= Jwts.builder().setSubject(userName).claim("user",user.getUsername()).setIssuedAt(new Date()).
		signWith(SignatureAlgorithm.HS256, "secretkey").compact();
		return jwtToken;*/
		return "user login successful";
	}
}
