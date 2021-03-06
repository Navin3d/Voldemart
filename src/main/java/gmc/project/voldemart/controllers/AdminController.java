package gmc.project.voldemart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import gmc.project.voldemart.services.AdminService;
import gmc.project.voldemart.services.ProductService;

@Controller
public class AdminController {
	
	private final AdminService adminService;
	private final ProductService productService;
	
	public AdminController(AdminService adminService, ProductService productService) {
		super();
		this.adminService = adminService;
		this.productService = productService;
	}

	@GetMapping("/admin/users")
	public String showAllUser(Model model) {
		model.addAttribute("users", adminService.findAllUser());
		return "admin/users";
	}
	
	@GetMapping("/admin/user/{userId}/edit")
	public String editUser(@PathVariable Long userId, Model model) {
		model.addAttribute("user", adminService.findUserCommandById(userId));
		return "user/profileForm";
	}
	
	@GetMapping("/admin/user/{userId}/delete")
	public String deleteUser(@PathVariable Long userId) {
		adminService.deleteUser(userId);
		return "redirect:/admin/users";
	}
	
	@GetMapping("/admin/products")
	public String getProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "admin/products";
	}
	
	@GetMapping("/admin/product/{productId}/edit")
	public String editProduct(@PathVariable Long productId, Model model) {
		model.addAttribute("product", adminService.getProductCommand(productId));
		return "product/productForm";
	}
	
	@GetMapping("/admin/product/{productId}/delete")
	public String deleteProduct(@PathVariable Long productId) {
		adminService.deleteProduct(productId);
		return "redirect:/admin/products";
	}
	

}
