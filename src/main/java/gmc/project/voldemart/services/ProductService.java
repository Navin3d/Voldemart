package gmc.project.voldemart.services;

import java.security.Principal;
import java.util.Set;

import gmc.project.voldemart.commands.ProductCommand;
import gmc.project.voldemart.domain.Categories;
import gmc.project.voldemart.domain.Product;

public interface ProductService {
	Set<Product> getAllProducts();
	Set<Product> getCategoryProducts(Categories categories);
	Product findProductById(Long id);
	ProductCommand addProduct(Principal principal);
	void saveProduct(ProductCommand productCommand);
	ProductCommand findProductCommandById(Principal principal, Long productId);
	Set<Product> findCartProducts(Principal principal);
}
