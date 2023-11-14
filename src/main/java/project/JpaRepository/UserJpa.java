package project.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import project.Entity.Users;

@Repository
public interface UserJpa extends JpaRepository<Users, Long>{


	 Users findByUsername(String username);
	 
	 //Users findrole(String role);
	 
	 Users findByUsernameAndPassword(String username, String password);
}
