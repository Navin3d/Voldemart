package gmc.project.voldemart.repositoies;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import gmc.project.voldemart.domain.Categories;
import gmc.project.voldemart.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	Optional<Category> findByCategories(Categories categories);
}
