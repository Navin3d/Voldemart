package gmc.project.voldemart.services;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import gmc.project.voldemart.commands.UpdateUserCommand;
import gmc.project.voldemart.converters.UpdateUserCommandToUser;
import gmc.project.voldemart.converters.UserToUpdateUserCommand;
import gmc.project.voldemart.domain.Product;
import gmc.project.voldemart.domain.User;
import gmc.project.voldemart.exceptions.ProductNotFoundException;
import gmc.project.voldemart.exceptions.UserNotFoundException;
import gmc.project.voldemart.repositoies.ProductRepository;
import gmc.project.voldemart.repositoies.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	private final ProductRepository productRepository;
	private final UserToUpdateUserCommand userToUpdateUserCommand;
	private final UpdateUserCommandToUser updateUserCommandToUser;

	public UserServiceImpl(UserRepository userRepository, UserToUpdateUserCommand userToUpdateUserCommand, UpdateUserCommandToUser updateUserCommandToUser, ProductRepository productRepository) {
		super();
		this.userRepository = userRepository;
		this.productRepository = productRepository;
		this.userToUpdateUserCommand = userToUpdateUserCommand;
		this.updateUserCommandToUser = updateUserCommandToUser;
	}
	
//	public User CreateUser
	
	@Override
	public Long findUserIdByName(Principal principal) {
		User foundUser = findUserByUserName(principal.getName());
		return foundUser.getId();
	}

	@Override
	public User findById(Long id) {
		
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) 
			throw new UserNotFoundException("User with ID : " + id + " not found");
		
		User foundUser = userOptional.get();		
		
		return foundUser;
	}

	@Override
	public User findUserByUserName(String userName) {
		
		Optional<User> foundUserOptional = userRepository.findByUserName(userName);
		
		if(!foundUserOptional.isPresent()) 
			throw new UserNotFoundException("This website has temproarily shutDown...");
		
		User foundUser = foundUserOptional.get();
				
		return foundUser;
	}

	@Override
	public UpdateUserCommand editUser(Principal authenticated) {
		
		User foundUser = findUserByUserName(authenticated.getName());
		
		UpdateUserCommand updateUserCommand = userToUpdateUserCommand.convert(foundUser);
		
		return updateUserCommand;
	}

	@Override
	public void updateUser(UpdateUserCommand updateUserCommand) {
		User detachedUser = updateUserCommandToUser.convert(updateUserCommand);
		userRepository.save(detachedUser);
	}

	@Override
	public void deleteProduct(Principal principal, Long productId) {
		
		User requestingUser = findUserByUserName(principal.getName());
		
		Set<Product> products = requestingUser.getProductsSold();
		
		Product productToDelete = new Product();
		
		for(Product prod : products) {
			if(prod.getId() == productId) {
				productToDelete = prod;
			}
		}
		
		if(productToDelete.getId() == null) 
			throw new ProductNotFoundException("The product with id " + productId + " not found...");
		
		requestingUser.getProductsSold().remove(productToDelete);
		productRepository.deleteById(productId);
		userRepository.save(requestingUser);
		
	}

	@Override
	public void addToCart(Principal principal, Long productId) {
		
		User requestingUser = findUserByUserName(principal.getName());
		
		Optional<Product> productOptional = productRepository.findById(productId);
		
		if(!productOptional.isPresent())
			throw new ProductNotFoundException("The product ");
		
		Product productToAdd = productOptional.get();
		
		requestingUser.getCartProducts().add(productToAdd);
		
		userRepository.save(requestingUser);
		
	}

	@Override
	public void removeFromCart(Principal principal, Long productId) {
		
		User requestingUser = findUserByUserName(principal.getName());
		
		Optional<Product> productOptional = productRepository.findById(productId);
		
		Product productToRemove = productOptional.get();;
		
		requestingUser.getCartProducts().remove(productToRemove);
		
		userRepository.save(requestingUser);
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User foundUser = findUserByUserName(username);
		if(foundUser == null) throw new UserNotFoundException();
		return new org.springframework.security.core.userdetails.User(foundUser.getUserName(), foundUser.getPassword(), true, true, true, true, new ArrayList<>());
	}

}
