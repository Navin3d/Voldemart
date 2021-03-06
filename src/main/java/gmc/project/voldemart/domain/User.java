package gmc.project.voldemart.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "users")
@EqualsAndHashCode(exclude = {"cartProducts", "productsSold"})
@ToString(exclude = {"productsSold", "cartProducts"})
public class User {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;	
	
	@Column(name = "username")
	private String userName;	
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "reports")
	private int reports;
	
	@Column(name = "enabled")
	private boolean enabled = true;
	
	@Column(name = "modifiedAt")
	private LocalDateTime modifiedAt;
	
	@Lob
	@Column(name = "profilePic")
	private Byte[] profilePic;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phonenumber")
	private String phoneNumber;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "seller")
	@Column(name = "productsSold")
	private Set<Product> productsSold = new HashSet<>();
	
	@OneToMany
	@Column(name = "cartProducts")
	private Set<Product> cartProducts = new HashSet<>();

	public User() {
		super();
		this.modifiedAt = LocalDateTime.now();
	}

}
