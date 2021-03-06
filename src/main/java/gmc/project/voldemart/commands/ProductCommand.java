package gmc.project.voldemart.commands;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnore;

import gmc.project.voldemart.domain.Categories;
import gmc.project.voldemart.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductCommand {
	
	@JsonIgnore
	private Long id;
	@JsonIgnore
	private User seller;
	
	@NotBlank
	@Size(min = 10, max = 50)
	private String name;
	@NotBlank
	@Size(min = 50, max = 200)
	private String description;
	private Categories categories;
	@NotNull
	private Long price;
	@URL
	private String imageUrl;
	private Byte[] image;
	@NotBlank
	@Size(min = 50, max = 200)
	private String address;
	
	public ProductCommand(User seller) {
		this.seller = seller;
	}
	
}
