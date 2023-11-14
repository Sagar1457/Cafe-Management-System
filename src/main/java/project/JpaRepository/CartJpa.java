package project.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.Entity.Cart;

public interface CartJpa extends JpaRepository<Cart, Long>{

}
