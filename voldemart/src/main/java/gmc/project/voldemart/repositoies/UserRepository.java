package gmc.project.voldemart.repositoies;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import gmc.project.voldemart.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
	Optional<User> findByUserName(String userName);
}
