package project.Util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import project.DTO.*;
import project.Entity.*;

@Component
public class Converter 
{
	public  Users convertToStudentEntity(UsersDTO userDTO)
	{
		Users user=new Users();
		if(userDTO!=null)
		{
			BeanUtils.copyProperties(userDTO, user);
		}
	     return user;
	}

	public UsersDTO convertToStudentDTO(Users user)
	{
		UsersDTO userDTO=new UsersDTO();
		if(user!=null)
		{
			BeanUtils.copyProperties(user, userDTO);
		}
		return userDTO;
	}

	public  Products convertToTeacherEntity(ProductsDTO productDTO)
	{
		Products product=new Products();
		if(productDTO!=null)
		{
			BeanUtils.copyProperties(productDTO, product);
		}
	     return product;
	}

	public ProductsDTO convertToTeacherDTO(Products product)
	{
		ProductsDTO productDTO=new ProductsDTO();
		if(product!=null)
		{
			BeanUtils.copyProperties(product, productDTO);
		}
		return productDTO;
	}

	public  Category convertToTeacherEntity(CategoryDTO categoryDTO)
	{
		Category category=new Category();
		if(categoryDTO!=null)
		{
			BeanUtils.copyProperties(categoryDTO, category);
		}
	     return category;
	}

	public CategoryDTO convertToTeacherDTO(Category category)
	{
		CategoryDTO categoryDTO=new CategoryDTO();
		if(category!=null)
		{
			BeanUtils.copyProperties(category, categoryDTO);
		}
		return categoryDTO;
	}

	public  Cart convertToTeacherEntity(CartDTO cartDTO)
	{
		Cart cart=new Cart();
		if(cartDTO!=null)
		{
			BeanUtils.copyProperties(cartDTO, cart);
		}
	     return cart;
	}

	public CartDTO convertToTeacherDTO(Cart cart)
	{
		CartDTO cartDTO=new CartDTO();
		if(cart!=null)
		{
			BeanUtils.copyProperties(cart, cartDTO);
		}
		return cartDTO;
	}
	
}
