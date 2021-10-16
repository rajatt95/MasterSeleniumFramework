package org.selenium.tests.Extent;

import java.io.IOException;

import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.pom.enums.AuthorType;
import org.selenium.pom.enums.CategoryType;
import org.selenium.pom.objects.Product;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;

@Epic("Epic - AddtoCart")
@Feature("Feature - Product AddToCart")
public class AddToCartTest extends BaseTest {

	
	@Story("Story - User should be able to add the Product into Cart")
	@Link("https://example.org")
	@Link(name = "allure", type = "mylink")
	@Issue("12345")
	//@TmsLink -> Test Management System (Manual test cases are written)
	@TmsLink("test-1")
	@Description("addToCartFromStorePage - This description is coming from Allure Annotation")
	@FrameworkAnnotation(author = { AuthorType.GAUTAM, AuthorType.RAJAT}, category = { CategoryType.SANITY,CategoryType.REGRESSION })
	@Test(groups = {"SANITY","REGRESSION"}, description = "addToCartFromStorePage - This description is coming from TestNG annotation property")
	public void addToCartFromStorePage() throws IOException {

		Product product = new Product(1215);
		CartPage cartPage  = 
				new StorePage(getDriver()).
					load().
					//clickaddToCartBtn(product.getName()).
					getProductThumbnail().
					clickaddToCartBtn(product.getName()).
					clickViewCartLink();

		
		Assert.assertEquals(cartPage.getProductName(), product.getName()+"FAIL");
	}
	
	@FrameworkAnnotation(author = { AuthorType.GAUTAM, AuthorType.RAJAT}, category = { CategoryType.SANITY,CategoryType.REGRESSION })
	//@Test(dataProvider = "getFeaturedProducts",dataProviderClass = MyDataProvider.class)
	public void addToCartFeaturedProducts(Product product) throws IOException {
		System.out.println("------------------------------------Product: "+product);
		CartPage cartPage=new HomePage(getDriver()).
				load().
				//clickaddToCartBtn("Blue Shoes").
				//clickaddToCartBtn(product.getName()).
				getProductThumbnail().
				clickaddToCartBtn(product.getName()).
				clickViewCartLink();
		Assert.assertEquals(cartPage.getProductName(), product.getName());
	}


}
