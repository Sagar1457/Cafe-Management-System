package project.service;

import project.Entity.Users;

public interface Userservice {
	public Users finduser(String username);
	Users login(String username, String password);

}
