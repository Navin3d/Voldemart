package gmc.project.voldemart.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import gmc.project.voldemart.domain.Categories;
import gmc.project.voldemart.domain.Category;
import gmc.project.voldemart.repositoies.CategoryRepository;

@Component
public class CategoryBootstrap {
	
	private final CategoryRepository categoryRepository;

    public CategoryBootstrap(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    private List<Category> getCategory() {
        List<Category> categoryList = new ArrayList<>();

        Category mobiles = new Category();
        mobiles.setCategories(Categories.MOBILES_AND_GADGETS);
        mobiles.setDescription("Cameras Too Available");
        mobiles.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAntAj5LNymswse1qBSYqWFBiqF8Q4DvCe9A&usqp=CAU");
        categoryList.add(mobiles);

		Category mensFootwear = new Category();
		mensFootwear.setCategories(Categories.MENS_FOOTWEAR);
		mensFootwear.setDescription("With N no of Designs");
		mensFootwear.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpSpdXvxpLZsV5x0vhn6tsekjsDfpfjVKlUQ&usqp=CAU");
		categoryList.add(mensFootwear);

		Category masala = new Category();
		masala.setCategories(Categories.Masalas_Both_Industry_And_Home_made);
		masala.setDescription("Stocks With Nice Quality");
		masala.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS79hMsbTqkzeVT1RiYeNO7dXrx_ffBtQOk1w&usqp=CAU");
		categoryList.add(masala);

		Category mensCloting = new Category();
		mensCloting.setCategories(Categories.MENS_CLOTHING);
		mensCloting.setDescription("High Quality with low price");
		mensCloting.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpSpdXvxpLZsV5x0vhn6tsekjsDfpfjVKlUQ&usqp=CAU");
		categoryList.add(mensCloting);

		Category toys = new Category();
		toys.setCategories(Categories.BEAUTY_AND_TOYS);
		toys.setDescription("Exicting Toys For Kids");
		toys.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHDmoOdOyGLKXo8zbbhAcz-70mn1JwKMTchA&usqp=CAU");
		categoryList.add(toys);

		Category houseHold = new Category();
		houseHold.setCategories(Categories.HOUSE_HOLD_APPLIANCES);
		houseHold.setDescription("With Various Brands");
        houseHold.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUMa3xsD-qtNVJi6Ml9fKCrTiCWi3lHWATHg&usqp=CAU");
		categoryList.add(houseHold);

		Category computerAndAccessories = new Category();
		computerAndAccessories.setCategories(Categories.COMPUTER_AND_ACCESSORIES);
		computerAndAccessories.setDescription("50+ Accessories");
		computerAndAccessories.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuWivaQ3qbYdXMaxwd8xcSccY9R-s6HyHTAw&usqp=CAU");
		categoryList.add(computerAndAccessories);

		Category bestOffer = new Category();
		bestOffer.setCategories(Categories.BEST_OFFER_WITH_MAJOR_DISCOUNTS);
		bestOffer.setDescription("Faster Booking");
		bestOffer.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvUv97qiNMT4oB1OP9jRn0uryjOUwVwdX73w&usqp=CAU");
		categoryList.add(bestOffer);

		Category furnitures = new Category();
		furnitures.setCategories(Categories.FURNITURE);
		furnitures.setDescription("More Stock Available");
		furnitures.setImageUrl("https://thespuzz.s3.ap-south-1.amazonaws.com/thespuzz/uploads/2021/03/04153909/5-Furniture-setup-rules-to-make-your-space-look-bigger.jpg");
		categoryList.add(furnitures);

		return categoryList;
    }

	public void execute() {
		categoryRepository.saveAll(getCategory());
	}

}
