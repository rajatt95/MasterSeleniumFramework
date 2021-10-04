package org.selenium;

import java.io.IOException;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.ConfigLoader;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestCase extends BaseTest {

	// public void guestCheckoutUsingDirectBankTransfer() -> Method Signature
	@Test
	public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {

		String searchFor = "Blue";
		BillingAddress billingAddress = 
				JacksonUtils.deSerializationJSON("myBillingAddress.json", BillingAddress.class);
		Product product = new Product(1215);

		StorePage storePage =
				new HomePage(getDriver()).
					load().
					getMyHeader().
					navigateToStoreUsingMenu();
		
		storePage.isLoaded();
		storePage.
			enterTextInSearchField(searchFor).
			clickSearchBtn();

		Assert.assertEquals(storePage.getTitle(), "Search results: “" + searchFor + "”");
		
		storePage.
			getProductThumbnail().
			clickaddToCartBtn(product.getName());
		
		CartPage cartPage = 
				storePage.
					getProductThumbnail().
					clickViewCartLink();
		cartPage.isLoaded();
		
		Assert.assertEquals(cartPage.getProductName(), product.getName());

		CheckoutPage checkoutPage = 
				cartPage.
					checkout().
						setBillingAddress(billingAddress).
						selectDirectBankTransfer().
						placeOrder();

		System.out.println("checkoutPage.getNotice(): " + checkoutPage.getNotice());
		Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");

	}

	// public void loginAndCheckoutUsingDirectBankTransfer() -> Method Signature
	@Test
	public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {
		
		String searchFor = "Blue";
		BillingAddress billingAddress = 
				JacksonUtils.deSerializationJSON("myBillingAddress.json", BillingAddress.class);
		Product product = new Product(1215);

		//User user = new User("dummyUser", "HidummyUser");
		User user = new User(ConfigLoader.getInstance().getUsername(),ConfigLoader.getInstance().getPassword());

		
		
		StorePage storePage =
				new HomePage(getDriver()).
					load().
					getMyHeader().
					navigateToStoreUsingMenu();
		
		storePage.isLoaded();
		storePage.
			enterTextInSearchField(searchFor).
			clickSearchBtn();

		Assert.assertEquals(storePage.getTitle(), "Search results: “" + searchFor + "”");

		storePage.
		getProductThumbnail().
		clickaddToCartBtn(product.getName());
	
		CartPage cartPage = 
			storePage.
				getProductThumbnail().
				clickViewCartLink();
		cartPage.isLoaded();
		Assert.assertEquals(cartPage.getProductName(), product.getName());
		
		CheckoutPage checkoutPage = 
				cartPage.
					checkout().
						clickHereToLoginLink().
						login(user).
						setBillingAddress(billingAddress).
						selectDirectBankTransfer().
						placeOrder();
		
		System.out.println("checkoutPage.getNotice(): " + checkoutPage.getNotice());
		Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
	}

}
