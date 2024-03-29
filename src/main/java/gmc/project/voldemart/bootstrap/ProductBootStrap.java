package gmc.project.voldemart.bootstrap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import gmc.project.voldemart.domain.Categories;
import gmc.project.voldemart.domain.Category;
import gmc.project.voldemart.domain.Product;
import gmc.project.voldemart.domain.User;
import gmc.project.voldemart.exceptions.UserNotFoundException;
import gmc.project.voldemart.repositoies.CategoryRepository;
import gmc.project.voldemart.repositoies.ProductRepository;
import gmc.project.voldemart.repositoies.UserRepository;

@Component
public class ProductBootStrap {
	
	private final ProductRepository productRepository;
	private final UserRepository userRepository;
	private final CategoryRepository categoryRepository;
	
	public ProductBootStrap(ProductRepository productRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.userRepository = userRepository;
		this.categoryRepository = categoryRepository;
	}

	private List<Product> getProducts() {

		List<Product> productsList = new ArrayList<>();

		Optional<Category> mobileOptional = categoryRepository.findByCategories(Categories.MOBILES_AND_GADGETS);
		if(!mobileOptional.isPresent()) {
			throw new RuntimeException("Expected category not found...");
		}

		Optional<Category> mensfootwearOptional = categoryRepository.findByCategories(Categories.MENS_FOOTWEAR);
		if(!mensfootwearOptional.isPresent()) {
			throw new RuntimeException("Expected category not found...");
		}

		Optional<Category> masalasOptional = categoryRepository.findByCategories(Categories.Masalas_Both_Industry_And_Home_made);
		if(!masalasOptional.isPresent()) {
			throw new RuntimeException("Expected category not found...");
		}

		Optional<Category> mensClothingOptional = categoryRepository.findByCategories(Categories.MENS_CLOTHING);
		if(!mobileOptional.isPresent()) {
			throw new RuntimeException("Expected category not found...");
		}

		Optional<Category> toysOptional = categoryRepository.findByCategories(Categories.BEAUTY_AND_TOYS);
		if(!mobileOptional.isPresent()) {
			throw new RuntimeException("Expected category not found...");
		}

		Optional<Category> householdOptional = categoryRepository.findByCategories(Categories.HOUSE_HOLD_APPLIANCES);
		if(!mobileOptional.isPresent()) {
			throw new RuntimeException("Expected category not found...");
		}

		Optional<Category> computerAccesOptional = categoryRepository.findByCategories(Categories.COMPUTER_AND_ACCESSORIES);
		if(!mobileOptional.isPresent()) {
			throw new RuntimeException("Expected category not found...");
		}

		Optional<Category> bestOfferOptional = categoryRepository.findByCategories(Categories.BEST_OFFER_WITH_MAJOR_DISCOUNTS);
		if(!mobileOptional.isPresent()) {
			throw new RuntimeException("Expected category not found...");
		}

		Optional<Category> furnituresOptional = categoryRepository.findByCategories(Categories.FURNITURE);
		if(!mobileOptional.isPresent()) {
			throw new RuntimeException("Expected category not found...");
		}

		Category mobiles = mobileOptional.get();
		Category mensFootwear = mensfootwearOptional.get();
		Category masala = masalasOptional.get();
		Category mensCloting = mensClothingOptional.get();
		Category toys = toysOptional.get();
		Category houseHold = householdOptional.get();
		Category computerAndAccessories = computerAccesOptional.get();
		Category bestOffer = bestOfferOptional.get();
		Category furnitures = furnituresOptional.get();

//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////USERS/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////
		
		User user1 = new User();
		user1.setFirstName("M S");
		user1.setLastName("Kishore");
		user1.setUserName("kishore");
		user1.setPassword("{noop}kishore");
		user1.setEmail("kishoreaadhu@gmail.com");
		user1.setPhoneNumber("+919442155990");
		
		userRepository.save(user1);

		User user2 = new User();
		user2.setFirstName("M");
		user2.setLastName("KrishnaRaghavan");
		user2.setUserName("KrishnaRaghavan");
		user2.setPassword("{noop}KrishnaRaghavan");
		user2.setPhoneNumber("+916383696701");
		
		userRepository.save(user2);

		Optional<User> user1Optional = userRepository.findById(1L);
		if(!user1Optional.isPresent()) {
			throw new UserNotFoundException("User with id 1 not found");
		}

		Optional<User> user2Optional = userRepository.findById(2L);
		if(!user2Optional.isPresent())
			throw new UserNotFoundException("User with id 2 not found");


		User kishore = user1Optional.get();

		User krish = user2Optional.get();

//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////AUTHORITIES////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////
//		Authorities authorities1 = new Authorities();
//		authorities1.setUserName("kishore");
//		authorities1.setAuthority(Roles.USER);
//		authoritiesRepository.save(authorities1);
//
//		Authorities authorities2 = new Authorities();
//		authorities2.setUserName("KrishnaRaghavan");
//		authorities2.setAuthority(Roles.USER);
//		authoritiesRepository.save(authorities2);
//		
//		Authorities authorities3 = new Authorities();
//		authorities3.setUserName("Navin");
//		authorities3.setAuthority(Roles.ADMIN);
//		authoritiesRepository.save(authorities3);

//////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////PRODUCTS///////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////

		Product product1 = new Product();
		product1.setName("Apple iPhone 12 Pro Max (512GB)");
		product1.setDescription("This is an iphone");
		product1.setPrice(2500l);
		product1.setImageUrl("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-12-pro-max-graphite-hero?wid=940&amp;hei=1112&amp;fmt=png-alpha&amp;qlt=80&amp;.v=1604021658000");
		product1.setCategory(mobiles);
		product1.setSeller(kishore);
		product1.setAddress("No 122 PRN Nagar, Kovilpathu, Karaikal Pondycherry 609605");
		productsList.add(product1);
		kishore.getProductsSold().add(product1);

		Product product2 = new Product();
		product2.setName("Apple iPhone 12 Pro Max (512GB)");
		product2.setDescription("This is an iphone");
		product2.setPrice(2500l);
		product2.setImageUrl("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-12-pro-max-graphite-hero?wid=940&amp;hei=1112&amp;fmt=png-alpha&amp;qlt=80&amp;.v=1604021658000");
		product2.setCategory(mobiles);
		product2.setSeller(kishore);
		product2.setAddress("No 122 PRN Nagar, Kovilpathu, Karaikal Pondycherry 609605");
		productsList.add(product2);
		kishore.getProductsSold().add(product2);

		Product product3 = new Product();
		product3.setName("Apple iPhone 12 Pro Max (512GB)");
		product3.setDescription("This is an iphone");
		product3.setPrice(2500l);
		product3.setImageUrl("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-12-pro-max-graphite-hero?wid=940&amp;hei=1112&amp;fmt=png-alpha&amp;qlt=80&amp;.v=1604021658000");
		product3.setCategory(mobiles);
		product3.setSeller(kishore);
		product3.setAddress("No 122 PRN Nagar, Kovilpathu, Karaikal Pondycherry 609605");
		productsList.add(product3);
		kishore.getProductsSold().add(product3);

		Product product4 = new Product();
		product4.setName("Apple iPhone 12 Pro Max (512GB)");
		product4.setDescription("This is an iphone");
		product4.setPrice(2500L);
		product4.setImageUrl("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-12-pro-max-graphite-hero?wid=940&amp;hei=1112&amp;fmt=png-alpha&amp;qlt=80&amp;.v=1604021658000");
		product4.setCategory(mobiles);
		product4.setSeller(kishore);
		product4.setAddress("No 122 PRN Nagar, Kovilpathu, Karaikal Pondycherry 609605");
		productsList.add(product4);
		kishore.getProductsSold().add(product4);

		Product product5 = new Product();
		product5.setName("Apple iPhone 12 Pro Max (512GB)");
		product5.setDescription("This is an iphone");
		product5.setPrice(2500l);
		product5.setImageUrl("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-12-pro-max-graphite-hero?wid=940&amp;hei=1112&amp;fmt=png-alpha&amp;qlt=80&amp;.v=1604021658000");
		product5.setCategory(mobiles);
		product5.setSeller(kishore);
		product5.setAddress("No 122 PRN Nagar, Kovilpathu, Karaikal Pondycherry 609605");
		productsList.add(product5);
		kishore.getProductsSold().add(product5);

		Product product6 = new Product();
		product6.setName("Apple iPhone 12 Pro Max (512GB)");
		product6.setDescription("This is an iphone");
		product6.setPrice(2500l);
		product6.setImageUrl("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-12-pro-max-graphite-hero?wid=940&amp;hei=1112&amp;fmt=png-alpha&amp;qlt=80&amp;.v=1604021658000");
		product6.setCategory(mobiles);
		product6.setSeller(kishore);
		product6.setAddress("No 122 PRN Nagar, Kovilpathu, Karaikal Pondycherry 609605");
		productsList.add(product6);
		kishore.getProductsSold().add(product6);

		Product product7 = new Product();
		product7.setName("Apple iPhone 12 Pro Max (512GB)");
		product7.setDescription("This is an iphone");
		product7.setPrice(2500l);
		product7.setImageUrl("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-12-pro-max-graphite-hero?wid=940&amp;hei=1112&amp;fmt=png-alpha&amp;qlt=80&amp;.v=1604021658000");
		product7.setCategory(mobiles);
		product7.setSeller(kishore);
		product7.setAddress("No 122 PRN Nagar, Kovilpathu, Karaikal Pondycherry 609605");
		productsList.add(product7);
		kishore.getProductsSold().add(product7);

		Product product8 = new Product();
		product8.setName("Apple iPhone 12 Pro Max (512GB)");
		product8.setDescription("This is an iphone");
		product8.setPrice(2500l);
		product8.setImageUrl("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-12-pro-max-graphite-hero?wid=940&amp;hei=1112&amp;fmt=png-alpha&amp;qlt=80&amp;.v=1604021658000");
		product8.setCategory(mobiles);
		product8.setSeller(kishore);
		product8.setAddress("No 122 PRN Nagar, Kovilpathu, Karaikal Pondycherry 609605");
		productsList.add(product8);
		kishore.getProductsSold().add(product8);

		Product product9 = new Product();
		product9.setName("Apple iPhone 12 Pro Max (512GB)");
		product9.setDescription("This is an iphone");
		product9.setPrice(2500l);
		product9.setImageUrl("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-12-pro-max-graphite-hero?wid=940&amp;hei=1112&amp;fmt=png-alpha&amp;qlt=80&amp;.v=1604021658000");
		product9.setCategory(mobiles);
		product9.setSeller(kishore);
		product9.setAddress("No 122 PRN Nagar, Kovilpathu, Karaikal Pondycherry 609605");
		productsList.add(product9);
		kishore.getProductsSold().add(product9);

		Product product10 = new Product();
		product10.setName("Apple iPhone 12 Pro Max (512GB)");
		product10.setDescription("This is an iphone");
		product10.setPrice(2500l);
		product10.setImageUrl("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-12-pro-max-graphite-hero?wid=940&amp;hei=1112&amp;fmt=png-alpha&amp;qlt=80&amp;.v=1604021658000");
		product10.setCategory(mobiles);
		product10.setSeller(kishore);
		product10.setAddress("No 122 PRN Nagar, Kovilpathu, Karaikal Pondycherry 609605");
		productsList.add(product10);
		kishore.getProductsSold().add(product10);

		Product product11 = new Product();
		product11.setName("Apple iPhone 12 Pro Max (512GB)");
		product11.setDescription("This is an iphone");
		product11.setPrice(2500l);
		product11.setImageUrl("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-12-pro-max-graphite-hero?wid=940&amp;hei=1112&amp;fmt=png-alpha&amp;qlt=80&amp;.v=1604021658000");
		product11.setCategory(mobiles);
		product11.setSeller(kishore);
		product11.setAddress("No 122 PRN Nagar, Kovilpathu, Karaikal Pondycherry 609605");
		productsList.add(product11);
		kishore.getProductsSold().add(product11);

		Product product12 = new Product();
		product12.setName("Apple iPhone 12 Pro Max (512GB)");
		product12.setDescription("This is an iphone");
		product12.setPrice(2500l);
		product12.setImageUrl("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-12-pro-max-graphite-hero?wid=940&amp;hei=1112&amp;fmt=png-alpha&amp;qlt=80&amp;.v=1604021658000");
		product12.setCategory(mobiles);
		product12.setSeller(kishore);
		product12.setAddress("No 122 PRN Nagar, Kovilpathu, Karaikal Pondycherry 609605");
		productsList.add(product12);
		kishore.getProductsSold().add(product12);

////////////////////////////////////////////////////////////////////////////////////////
///////////////////////CATEGORY MEN'S FOOTWEAR//////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////

		Product product13 = new Product();
		product13.setName("Bata Loofer");
		product13.setDescription("This is an Bata product");
		product13.setPrice(2500l);
		product13.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDhOSvAg-Dl3DU5BAAn9Q47MfD4UhtNvMMaA&usqp=CAU");
		product13.setCategory(mensFootwear);
		product13.setSeller(krish);	
		product13.setAddress("4/797 sundarabuvanam selvapuram near SP nagar kullampalayam post gobichettipalayam TAMIL NADU 638476");
		productsList.add(product13);
		krish.getProductsSold().add(product13);

		Product product14 = new Product();
		product14.setName("Bata Loofer");
		product14.setDescription("This is an aata product");
		product14.setPrice(2500l);
		product14.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDhOSvAg-Dl3DU5BAAn9Q47MfD4UhtNvMMaA&usqp=CAU");
		product14.setCategory(mensFootwear);
		product14.setSeller(krish);
		product14.setAddress("4/797 sundarabuvanam selvapuram near SP nagar kullampalayam post gobichettipalayam TAMIL NADU 638476");
		productsList.add(product14);
		krish.getProductsSold().add(product14);


		Product product15 = new Product();
		product15.setName("Bata Loofer");
		product15.setDescription("This is an iphone");
		product15.setPrice(2500l);
		product15.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDhOSvAg-Dl3DU5BAAn9Q47MfD4UhtNvMMaA&usqp=CAU");
		product15.setCategory(mensFootwear);
		product15.setSeller(krish);
		product15.setAddress("4/797 sundarabuvanam selvapuram near SP nagar kullampalayam post gobichettipalayam TAMIL NADU 638476");
		productsList.add(product15);
		krish.getProductsSold().add(product15);


		Product product16 = new Product();
		product16.setName("Bata Loofer");
		product16.setDescription("This is an iphone");
		product16.setPrice(2500l);
		product16.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDhOSvAg-Dl3DU5BAAn9Q47MfD4UhtNvMMaA&usqp=CAU");
		product16.setCategory(mensFootwear);
		product16.setSeller(krish);
		product16.setAddress("4/797 sundarabuvanam selvapuram near SP nagar kullampalayam post gobichettipalayam TAMIL NADU 638476");
		productsList.add(product16);
		krish.getProductsSold().add(product16);


		Product product17 = new Product();
		product17.setName("Bata Loofer");
		product17.setDescription("This is an iphone");
		product17.setPrice(2500l);
		product17.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDhOSvAg-Dl3DU5BAAn9Q47MfD4UhtNvMMaA&usqp=CAU");
		product17.setCategory(mensFootwear);
		product17.setSeller(krish);
		product17.setAddress("4/797 sundarabuvanam selvapuram near SP nagar kullampalayam post gobichettipalayam TAMIL NADU 638476");
		productsList.add(product17);
		krish.getProductsSold().add(product17);


		Product product18 = new Product();
		product18.setName("Bata Loofer");
		product18.setDescription("This is an iphone");
		product18.setPrice(2500l);
		product18.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDhOSvAg-Dl3DU5BAAn9Q47MfD4UhtNvMMaA&usqp=CAU");
		product18.setCategory(mensFootwear);
		product18.setSeller(krish);
		product18.setAddress("4/797 sundarabuvanam selvapuram near SP nagar kullampalayam post gobichettipalayam TAMIL NADU 638476");
		productsList.add(product18);
		krish.getProductsSold().add(product18);


		Product product19 = new Product();
		product19.setName("Bata Loofer");
		product19.setDescription("This is an iphone");
		product19.setPrice(2500l);
		product19.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDhOSvAg-Dl3DU5BAAn9Q47MfD4UhtNvMMaA&usqp=CAU");
		product19.setCategory(mensFootwear);
		product19.setSeller(krish);
		product19.setAddress("4/797 sundarabuvanam selvapuram near SP nagar kullampalayam post gobichettipalayam TAMIL NADU 638476");
		productsList.add(product19);
		krish.getProductsSold().add(product19);


		Product product20 = new Product();
		product20.setName("Bata Loofer");
		product20.setDescription("This is an iphone");
		product20.setPrice(2500l);
		product20.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDhOSvAg-Dl3DU5BAAn9Q47MfD4UhtNvMMaA&usqp=CAU");
		product20.setCategory(mensFootwear);
		product20.setSeller(krish);
		product20.setAddress("4/797 sundarabuvanam selvapuram near SP nagar kullampalayam post gobichettipalayam TAMIL NADU 638476");
		productsList.add(product20);
		krish.getProductsSold().add(product20);


		Product product21 = new Product();
		product21.setName("Bata Loofer");
		product21.setDescription("This is an iphone");
		product21.setPrice(2500l);
		product21.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDhOSvAg-Dl3DU5BAAn9Q47MfD4UhtNvMMaA&usqp=CAU");
		product21.setCategory(mensFootwear);
		product21.setSeller(krish);
		product21.setAddress("4/797 sundarabuvanam selvapuram near SP nagar kullampalayam post gobichettipalayam TAMIL NADU 638476");
		productsList.add(product21);
		krish.getProductsSold().add(product21);


		Product product22 = new Product();
		product22.setName("Bata Loofer");
		product22.setDescription("This is an iphone");
		product22.setPrice(2500l);
		product22.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDhOSvAg-Dl3DU5BAAn9Q47MfD4UhtNvMMaA&usqp=CAU");
		product22.setCategory(mensFootwear);
		product22.setSeller(krish);
		product22.setAddress("4/797 sundarabuvanam selvapuram near SP nagar kullampalayam post gobichettipalayam TAMIL NADU 638476");
		productsList.add(product22);
		krish.getProductsSold().add(product22);


		Product product23 = new Product();
		product23.setName("Bata Loofer");
		product23.setDescription("This is an iphone");
		product23.setPrice(2500l);
		product23.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDhOSvAg-Dl3DU5BAAn9Q47MfD4UhtNvMMaA&usqp=CAU");
		product23.setCategory(mensFootwear);
		product23.setSeller(krish);
		product23.setAddress("4/797 sundarabuvanam selvapuram near SP nagar kullampalayam post gobichettipalayam TAMIL NADU 638476");
		productsList.add(product23);
		krish.getProductsSold().add(product23);


		Product product24 = new Product();
		product24.setName("Bata Loofer");
		product24.setDescription("This is an iphone");
		product24.setPrice(2500l);
		product24.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDhOSvAg-Dl3DU5BAAn9Q47MfD4UhtNvMMaA&usqp=CAU");
		product24.setCategory(mensFootwear);
		product24.setSeller(krish);
		product24.setAddress("4/797 sundarabuvanam selvapuram near SP nagar kullampalayam post gobichettipalayam TAMIL NADU 638476");
		productsList.add(product24);
		krish.getProductsSold().add(product24);

		return productsList;
	}

	@Transactional
	public void execute() {
		productRepository.saveAll(getProducts());
	}

}
