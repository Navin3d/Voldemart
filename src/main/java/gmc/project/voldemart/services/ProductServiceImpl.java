package gmc.project.voldemart.services;

import java.security.Principal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import gmc.project.voldemart.commands.ProductCommand;
import gmc.project.voldemart.converters.ProductCommandToProduct;
import gmc.project.voldemart.converters.ProductToProductCommand;
import gmc.project.voldemart.domain.Categories;
import gmc.project.voldemart.domain.Product;
import gmc.project.voldemart.domain.User;
import gmc.project.voldemart.exceptions.ProductNotFoundException;
import gmc.project.voldemart.repositoies.ProductRepository;
import gmc.project.voldemart.repositoies.UserRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final UserService userService;
	private final ProductRepository productRepository;
	private final UserRepository userRepository;
	private final ProductToProductCommand productToProductCommand;
	private final ProductCommandToProduct productCommandToProduct;

	public ProductServiceImpl(ProductRepository productRepository, UserService userService, ProductToProductCommand productToProductCommand, ProductCommandToProduct productCommandToProduct, UserRepository userRepository) {
		super();
		this.userService = userService;
		this.productRepository = productRepository;
		this.userRepository = userRepository;
		this.productToProductCommand = productToProductCommand;
		this.productCommandToProduct = productCommandToProduct;
	}

	@Override
	public Set<Product> getAllProducts() {
		
		Set<Product> allProduct = new HashSet<>();
		
		productRepository.findAll()
				.iterator().forEachRemaining(allProduct::add);
		
		return allProduct;
	}

	@Override
	public Set<Product> getCategoryProducts(Categories categories) {
		
		Set<Product> categoryProducts = new HashSet<>();
		
		getAllProducts().forEach(product -> {
			if(product.getCategory().getCategories().equals(categories))
				categoryProducts.add(product);
		});
		
		return categoryProducts;
		
	}

	@Override
	public Product findProductById(Long id) {
		Optional<Product> foundProductOptional = productRepository.findById(id);
		
		if(!foundProductOptional.isPresent())
			throw new ProductNotFoundException("The product with Id : " + id + " not found...");
		
		Product foundProduct = foundProductOptional.get();
		
		return foundProduct;
	}

	@Override
	public ProductCommand addProduct(Principal principal) {
		User seller = userService.findUserByUserName(principal.getName());
		ProductCommand productCommand = new ProductCommand(seller);
		return productCommand;
	}

	@Override
	public void saveProduct(ProductCommand productCommand) {
		Product detachedProduct = productCommandToProduct.convert(productCommand);
		User requestingUser = detachedProduct.getSeller();
		requestingUser.getProductsSold().add(detachedProduct);
		productRepository.save(detachedProduct);
		userRepository.save(requestingUser);
	}

	@Override
	public ProductCommand findProductCommandById(Principal principal, Long productId) {
		User foundUser = userService.findUserByUserName(principal.getName());
		Set<Product> userSoldProduct = foundUser.getProductsSold();
		Product foundProduct = new Product();
		
		for(Product prod : userSoldProduct) {
			if(prod.getId() == productId)
				foundProduct = prod;
		}
		
		return productToProductCommand.convert(foundProduct);
	}

	@Override
	public Set<Product> findCartProducts(Principal principal) {
		
		Set<Product> cartProduct = userService.findUserByUserName(principal.getName()).getCartProducts();
						
		return cartProduct;
	}

}
