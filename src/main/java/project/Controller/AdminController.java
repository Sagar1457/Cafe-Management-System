package project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import project.Entity.Cart;
import project.Entity.Category;
import project.Entity.Products;
import project.Entity.Users;
import project.ServiceImp.CartServiceImp;
import project.ServiceImp.CategoryServiceImp;
import project.ServiceImp.ProductServiceImp;
import project.ServiceImp.UserServiceImp;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/admin")
public class AdminController {
	
	//=======================Users=====================
	@Autowired
	private UserServiceImp userservice;
	
	@PostMapping("/newregistration")
	public Users newuser(@RequestBody Users user) {
		return userservice.newuser(user);
	}
	
	@GetMapping("/users")
	public List<Users> getallusers() {
		return userservice.getallusers();
	}
	
	@GetMapping("/user/{id}")
	public Users GetById(@PathVariable Long id) {
		return userservice.GetById(id);
	}
	
	@GetMapping("/users/{username}")
	public Users FindByusername(@PathVariable String username) {
		return userservice.finduser(username);
	}
	
	@DeleteMapping("/user/delete/{id}")
	public String deleteuser(@PathVariable Long id) {
		return userservice.deleteuser(id);
	}
	
	@PutMapping("/user/update/{id}")
	public Users updateuser(@PathVariable Long id,@RequestBody Users user) {
		return userservice.updateuser(id, user);
	}
	
	//===============================Cart===================
	@Autowired
	private CartServiceImp cartservice;
	
	@PutMapping("/cart/{id}")
	public Cart savecart(@PathVariable Long id,@RequestBody Cart cart) {
		return cartservice.savecart(id, cart);
	}
	
	@GetMapping("/carts")
	public List<Cart> getallcarts(){
		return cartservice.getallcarts();
	}
	
	//===============================products======================
	@Autowired
	private ProductServiceImp productservice;
	
	@PostMapping("/product/add")
	public Products addproduct(@RequestBody Products product){
		return productservice.addproduct(product);
	}
	
	@GetMapping("/products")
	public List<Products> getallproduct(){
		return productservice.getallproduct();
	}
	
	@PostMapping("/cart/addproducts/{productId}/{cartId}")
	public String addProductToCart(@RequestParam Long  productId,@RequestParam Long cartId) {
		return productservice.addProductToCart(productId, cartId);
	}
	
	@GetMapping("/cart/products/{cartId}")
	public List<Products> getProductsInCart(@PathVariable Long cartId){
		return productservice.getProductsInCart(cartId);
	}
		
	@DeleteMapping("/product/delete/{id}")
	public String Deleteproduct(@PathVariable Long id) {
		return productservice.Deleteproduct(id);
	}
	
	@GetMapping("/product/{id}")
	public Products findById(@PathVariable Long id) {
		return productservice.findById(id);
	}
	
	@PutMapping("/product/update/{id}")
	public Products updateproduct(@PathVariable Long id,@RequestBody Products product) {
		return productservice.Updateproduct(id,product);
	}
	
	//=======================================Category==========================
	@Autowired
	private CategoryServiceImp categoryservice;
	
	@PostMapping("/category/addproducts")
	public String addCategoryToProduct(@RequestParam Long  productId,@RequestParam Long categoryId) {
		return categoryservice.addCategoryToProduct(productId, categoryId);
	}
	
	@GetMapping("/category/products/{categoryId}")
	public List<Products> getProductsInCategory(@PathVariable Long categoryId){
		return categoryservice.getProductsInCategory(categoryId);
	}
	
	@PostMapping("/category/add")
	public Category addcategory(@RequestBody Category category) {
		return categoryservice.addcategory(category);
	}
	
	@GetMapping("/categories")
	public List<Category> getallcategory(){
		return categoryservice.getallcategory();
	}
	
	@DeleteMapping("category/delete/{id}")
	 public String Deletecategory(@PathVariable Long id) {
		return categoryservice.Deletecategory(id);
	}
	
	@PutMapping("/category/update/{id}")
	 public Category updatecategory(@PathVariable Long id,@RequestBody Category category) {
		return categoryservice.updatecategory(id, category);
		
	}
}
