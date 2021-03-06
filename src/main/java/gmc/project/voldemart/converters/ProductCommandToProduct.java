package gmc.project.voldemart.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import gmc.project.voldemart.commands.ProductCommand;
import gmc.project.voldemart.domain.Category;
import gmc.project.voldemart.domain.Product;
import gmc.project.voldemart.services.CategoryService;

@Component
public class ProductCommandToProduct implements Converter<ProductCommand, Product>{
	
	private final CategoryService categoryService;

	public ProductCommandToProduct(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	@Override
	@Nullable
	public Product convert(ProductCommand source) {
		
		if(source == null)
			return null;
		
		Product product = new Product();
		product.setId(source.getId());
		product.setSeller(source.getSeller());
		product.setName(source.getName());
		product.setDescription(source.getDescription());
		product.setImage(source.getImage());
		product.setImageUrl(source.getImageUrl());
		
		Category productCategory = categoryService.findCategory(source.getCategories());
		product.setCategory(productCategory);
		product.setPrice(source.getPrice());
		product.setAddress(source.getAddress());
		
		return product;
	}

}
