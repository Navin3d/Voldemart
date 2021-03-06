package gmc.project.voldemart.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import gmc.project.voldemart.commands.CreateUserCommand;
import gmc.project.voldemart.commands.UpdateUserCommand;
import gmc.project.voldemart.services.ProductService;
import gmc.project.voldemart.services.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
	
	public static String profileForm = "user/profileForm";
	public static String profile = "user/profile";
	
	private final UserService userService;
	private final ProductService productService;
	
	public UserController(UserService userService, ProductService productService) {
		super();
		this.userService = userService;
		this.productService = productService;
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

	@GetMapping("/user/profile")
	public String getUserProfile(Principal authenticated, Model model) {
		
		model.addAttribute("user", userService.findUserByUserName(authenticated.getName()));
		
		return profile;
	}
	
	@GetMapping("/user/profile/edit")
	public String editUser(Principal authenticated, Model model) {
		model.addAttribute("user", userService.editUser(authenticated));
		return profileForm;
	}
	
	@GetMapping("/user/products")
	public String showProductSold(Principal principal, Model model) {
		model.addAttribute("products", userService.findUserByUserName(principal.getName()).getProductsSold());
		return "user/productSold";
	}
	
	@GetMapping("/user/product/add")
	public String addProduct(Principal principal, Model model) {
		model.addAttribute("product", productService.addProduct(principal));
		return "product/productForm";
	}
	
	@GetMapping("/user/product/{productId}/edit")
	public String editProduct(Principal principal, @PathVariable String productId, Model model) {
		model.addAttribute("product", productService.findProductCommandById(principal, Long.valueOf(productId)));
		return "product/productForm";
	}
	
	@GetMapping("/user/product/{productId}/delete")
	public String deleteProduct(Principal principal, @PathVariable Long productId) {
		userService.deleteProduct(principal, Long.valueOf(productId));
		return "redirect:/user/products";
	}
	
	@GetMapping("/user/cart")
	public String cart(Principal principal, Model model) {
		model.addAttribute("products", productService.findCartProducts(principal));
		return "user/cart";
	}
	
	@GetMapping("/user/cart/product/{productId}/add")
	public String addToCart(Principal principal, @PathVariable Long productId) {
		userService.addToCart(principal, productId);
		return "redirect:/user/cart";
	}
	
	@GetMapping("/user/cart/product/{productId}/remove")
	public String removeFromCart(Principal principal, @PathVariable Long productId) {
		userService.removeFromCart(principal, productId);
		return "redirect:/user/cart";
	}
	
	@PostMapping("/updateuser/")
	public String updateUser(@Valid @ModelAttribute("user") UpdateUserCommand updateUserCommand, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(error -> log.debug(error.toString()));
			return profileForm;
		}
		
		userService.updateUser(updateUserCommand);
		
		return "redirect:/";
	}

}
