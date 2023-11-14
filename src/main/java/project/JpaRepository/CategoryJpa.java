package project.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.Entity.Category;

public interface CategoryJpa extends JpaRepository<Category, Long>{

}
