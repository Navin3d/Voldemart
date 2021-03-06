package gmc.project.voldemart.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import gmc.project.voldemart.domain.Categories;
import gmc.project.voldemart.domain.Category;
import gmc.project.voldemart.exceptions.CategoryNotFoundException;
import gmc.project.voldemart.repositoies.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private final CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Set<Category> findAllCategory() {
		
		Set<Category> allCategory = new HashSet<>();
		
		categoryRepository.findAll()
				.iterator().forEachRemaining(allCategory::add);
				
		return allCategory;
	}

	@Override
	public Category findCategory(Categories categories) {
		
		Optional<Category> foundCategoryOptional = categoryRepository.findByCategories(categories);
		
		if(!foundCategoryOptional.isPresent())
			throw new CategoryNotFoundException("The category with name " + categories + " not found...");
		
		Category foundCategory = foundCategoryOptional.get();
		
		return foundCategory;
		
	}

}
