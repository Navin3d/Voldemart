package gmc.project.voldemart.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import gmc.project.voldemart.commands.ProductCommand;
import gmc.project.voldemart.services.ProductService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/products")
	public String showAllProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "/product/productList";
	}
	
	@GetMapping("/product/{productId}/show")
	public String showProduct(@PathVariable Long productId, Model model) {
		model.addAttribute("product", productService.findProductById(Long.valueOf(productId)));
		return "product/productCard";
	}
	
	@PostMapping("/product/")
	public String saveOrUpdate(@Valid @ModelAttribute("product") ProductCommand productCommand, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(err -> log.debug(err.toString()));
			return "product/productForm";
		}
		productService.saveProduct(productCommand);
		return "redirect:/user/products";
	}

}
