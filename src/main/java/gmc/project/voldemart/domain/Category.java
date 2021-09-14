package gmc.project.voldemart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="category")
public class Category {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "categories")
	private Categories categories;
	
	@Column(name = "description")
	private String description;
	
	@Lob
	@Column(name = "imageUrl")
	private String imageUrl;
	
	@Lob
	@Column(name = "image")
	private Byte[] image;

}
