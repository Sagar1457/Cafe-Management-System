package project.DTO;

import lombok.Data;
import project.Entity.Cart;

@Data
public class UsersDTO 
{
	private Long user_id;
	
	private String Fullname;
	
	private String username; 

	private String password;
	
	private Long number;
	
	private String email;
	
	private String address;
	
	private String role="customer";
	
	private String Status="In-Active";
	
	private Cart cart;
}
