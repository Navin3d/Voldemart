package gmc.project.voldemart.controllers;

import org.springframework.boot.actuate.trace.http.HttpTrace.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import gmc.project.voldemart.domain.Categories;
import gmc.project.voldemart.services.CategoryService;
import gmc.project.voldemart.services.ProductService;
import gmc.project.voldemart.services.UserService;

@Controller
public class CategoryController {
	
	private final UserService userService;
	private final ProductService productService;
	private final CategoryService categoryService;
		
	public CategoryController(CategoryService categoryService, ProductService productService, UserService userService) {
		super();
		this.userService = userService;
		this.productService = productService;
		this.categoryService = categoryService;
	}

	@GetMapping({"", "/"})
	public String showCategory(Principal principal, Model model) {
		model.addAttribute("categories", categoryService.findAllCategory());
//		model.addAttribute("user", userService.findUserByUserName(principal.getName()));
		return "index";
	}
	
	@GetMapping("category/{categories}")
	public String showCategoryProducts(@PathVariable Categories categories, Model model) {
		model.addAttribute("products", productService.getCategoryProducts(categories));
		return "product/productList";
	}
	
}
