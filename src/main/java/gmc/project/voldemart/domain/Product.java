package gmc.project.voldemart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;	
	
	@ManyToOne
//	@Column(name = "seller") 
	private User seller;
	
	@Lob
	@Column(name = "description")
	private String description;	
	
	@OneToOne
//	@Column(name = "category")
	private Category category;
	
	@Column(name = "price")
	private Long price;	
	
	@Lob
	@Column(name = "imageUrl")
	private String imageUrl;	
	
	@Lob
	@Column(name = "address")
	private String address;	
	
	@Lob
	@Column(name = "image")
	private Byte[] image;
	
}
