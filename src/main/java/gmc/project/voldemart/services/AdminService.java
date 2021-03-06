package gmc.project.voldemart.services;

import java.util.Set;

import gmc.project.voldemart.commands.ProductCommand;
import gmc.project.voldemart.commands.UpdateUserCommand;
import gmc.project.voldemart.domain.User;

public interface AdminService {
	Set<User> findAllUser();
	UpdateUserCommand findUserCommandById(Long userId);
	void deleteUser(Long userId);
	ProductCommand getProductCommand(Long productId);
	void deleteProduct(Long productId);
}
