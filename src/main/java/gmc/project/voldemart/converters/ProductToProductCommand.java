package gmc.project.voldemart.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import gmc.project.voldemart.commands.ProductCommand;
import gmc.project.voldemart.domain.Product;

@Component
public class ProductToProductCommand implements Converter<Product, ProductCommand> {

	@Override
	@Nullable
	public ProductCommand convert(Product source) {
		
		ProductCommand productCommand = new ProductCommand();
		productCommand.setId(source.getId());
		productCommand.setSeller(source.getSeller());
		productCommand.setName(source.getName());
		productCommand.setDescription(source.getDescription());
		productCommand.setPrice(source.getPrice());
		productCommand.setImage(source.getImage());
		productCommand.setImageUrl(source.getImageUrl());
		productCommand.setAddress(source.getAddress());
		productCommand.setCategories(source.getCategory().getCategories());
		
		return productCommand;
		
	}

}
