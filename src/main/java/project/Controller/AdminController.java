package project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import project.Entity.Cart;
import project.Entity.Category;
import project.Entity.Products;
import project.Entity.Users;
import project.ServiceImp.CartServiceImp;
import project.ServiceImp.CategoryService;
import project.ServiceImp.ProductServiceImp;
import project.ServiceImp.UserServiceImp;

@RestController
public class AdminController {
	
	@Autowired
	private UserServiceImp userservice;
	
	@Autowired
	private CartServiceImp cartservice;
	
	@Autowired
	private ProductServiceImp productservice;
	
	@Autowired
	private CategoryService categoryservice;
	
	@GetMapping("/users")
	public List<Users> getallusers() {
		return userservice.getallusers();
	}
	
	@GetMapping("/user/{id}")
	public Users GetById(@PathVariable Long id) {
		return userservice.GetById(id);
	}
	
	@GetMapping("/Users/{username}")
	public Users FindByusername(@PathVariable String username) {
		return userservice.finduser(username);
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteuser(@PathVariable Long id) {
		return userservice.deleteuser(id);
	}
	
	@PutMapping("/updateuser/{id}")
	public Users updateuser(@PathVariable Long id,@RequestBody Users user) {
		return userservice.updateuser(id, user);
	}
	
	@PostMapping("/newregistration")
	public Users newuser(@RequestBody Users user) {
		return userservice.newuser(user);
	}
	
	@PutMapping("/cart/{id}")
	public Cart savecart(@PathVariable Long id,@RequestBody Cart cart) {
		return cartservice.savecart(id, cart);
	}
	
	@GetMapping("/carts")
	public List<Cart> getallcarts(){
		return cartservice.getallcarts();
	}
	
	@PostMapping("/product")
	public Products addproduct(Products product){
		return productservice.addproduct(product);
	}
	
	@PostMapping("/products/{productId}/{cartId}")
	public String addProductToCart(@RequestParam Long  productId,@RequestParam Long cartId) {
		return productservice.addProductToCart(productId, cartId);
	}
	
	@GetMapping("/products/{cartId}")
	public List<Products> getProductsInCart(@PathVariable Long cartId){
		return productservice.getProductsInCart(cartId);
	}
	
	@PostMapping("/category/{productId}/{categoryId}")
	public String addCategoryToProduct(@RequestParam Long  productId,@RequestParam Long categoryId) {
		return categoryservice.addCategoryToProduct(productId, categoryId);
	}
	
	@GetMapping("/products/category/{categoryId}")
	public List<Products> getProductsInCategory(@PathVariable Long categoryId){
		return categoryservice.getProductsInCategory(categoryId);
	}
	
	@GetMapping("/products")
	public List<Products> getallproduct(){
		return productservice.getallproduct();
	}
	
	@PostMapping("/addcategory")
	public Category addcategory(Category category) {
		return categoryservice.addcategory(category);
	}
	
	@GetMapping("/categories")
	public List<Category> getallcategory(){
		return categoryservice.getallcategory();
	}
	
}
