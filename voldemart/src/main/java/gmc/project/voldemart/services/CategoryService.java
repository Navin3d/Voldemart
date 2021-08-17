package gmc.project.voldemart.services;

import java.util.Set;

import gmc.project.voldemart.domain.Categories;
import gmc.project.voldemart.domain.Category;

public interface CategoryService {
	Set<Category> findAllCategory();
	Category findCategory(Categories categories);
}
