package gmc.project.voldemart.services;

import java.security.Principal;

import gmc.project.voldemart.commands.UpdateUserCommand;
import gmc.project.voldemart.domain.User;

public interface UserService {
	Long findUserIdByName(Principal principal);
	User findById(Long id);
	User findUserByUserName(String userName);
	UpdateUserCommand editUser(Principal authenticated);
	void updateUser(UpdateUserCommand updateUserCommand);
	void deleteProduct(Principal principal, Long productId);
	void addToCart(Principal principal, Long productId);
	void removeFromCart(Principal principal, Long productId);
}
