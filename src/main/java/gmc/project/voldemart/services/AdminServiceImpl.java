package gmc.project.voldemart.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import gmc.project.voldemart.commands.ProductCommand;
import gmc.project.voldemart.commands.UpdateUserCommand;
import gmc.project.voldemart.converters.ProductToProductCommand;
import gmc.project.voldemart.converters.UserToUpdateUserCommand;
import gmc.project.voldemart.domain.Product;
import gmc.project.voldemart.domain.User;
import gmc.project.voldemart.repositoies.ProductRepository;
import gmc.project.voldemart.repositoies.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	private final UserService userService;
	private final ProductService productService;
	private final UserRepository userRepository;
	private final ProductRepository productRepository;
	private final UserToUpdateUserCommand userToUpdateUserCommand;
	private final ProductToProductCommand productToProductCommand;

	public AdminServiceImpl(UserRepository userRepository, UserService userService, UserToUpdateUserCommand userToUpdateUserCommand, ProductService productService, ProductToProductCommand productToProductCommand, ProductRepository productRepository) {
		super();
		this.userService = userService;
		this.productService = productService;
		this.userRepository = userRepository;
		this.productRepository = productRepository;
		this.userToUpdateUserCommand = userToUpdateUserCommand;
		this.productToProductCommand = productToProductCommand;
	}
	
	public Set<User> findAllUser() {
		
		Set<User> allUser = new HashSet<>();
		
		userRepository.findAll().iterator()
			.forEachRemaining(allUser::add);
		
		return allUser;
		
	}

	@Override
	public UpdateUserCommand findUserCommandById(Long userId) {
		User foundUser = userService.findById(userId);
		return userToUpdateUserCommand.convert(foundUser);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public ProductCommand getProductCommand(Long productId) {
		
		Product foundProduct = productService.findProductById(productId);
		
		return productToProductCommand.convert(foundProduct);
	}

	@Override
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);
	}
	

}
