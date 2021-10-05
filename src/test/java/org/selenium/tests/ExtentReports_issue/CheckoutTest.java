package org.selenium.tests.ExtentReports_issue;

import java.io.IOException;

import org.selenium.api.actions.CartApi;
import org.selenium.api.actions.SignUpApi;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.utils.FakerUtils;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

	@Test
	public void guestCheckoutUsingDirectBankTransfer() throws IOException {
		
		BillingAddress billingAddress = 
				JacksonUtils.deSerializationJSON("myBillingAddress.json", BillingAddress.class);
	
		CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();

		/* Do this using RestAssured library - WebService part */
		CartApi cartApi = new CartApi();
		cartApi.addToCart(1215, 1);

		/* Do this using Selenium WebDriver library - UI part */
		injectCookiesToBrowser(cartApi.getCookies());

		checkoutPage.
			load().
			setBillingAddress(billingAddress).
			selectDirectBankTransfer().
			placeOrder();

		System.out.println("checkoutPage.getNotice(): " + checkoutPage.getNotice());
		Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
	}
	
	
	@Test
	public void loginAndCheckoutUsingDirectBankTransfer() throws IOException, InterruptedException {
		
		BillingAddress billingAddress = 
				JacksonUtils.deSerializationJSON("myBillingAddress.json", BillingAddress.class);

		/* Do this using RestAssured library - WebService part */
		User user = getUser();

		SignUpApi signUpApi = new SignUpApi();
		signUpApi.register(user);
		System.out.println("REGISTER Cookies: " + signUpApi.getCookies());

		CartApi cartApi = new CartApi(signUpApi.getCookies());
		Product product = new Product(1215);
		cartApi.addToCart(product.getId(), 1);

		/* Do this using WebDriver library - UI part */
		CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();
		Thread.sleep(5000);
		
		/* We can only inject the Cookies after loading the URL into Browser */
		/*We are adding SignUpApi cookies here because we want User to be logged in during Checkout in this Test case*/
		injectCookiesToBrowser(signUpApi.getCookies());

		checkoutPage.
			load();
		Thread.sleep(5000);
		checkoutPage.setBillingAddress(billingAddress).
		selectDirectBankTransfer().
		placeOrder();

	System.out.println("checkoutPage.getNotice(): " + checkoutPage.getNotice());
	Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");

	}
	
	private User getUser() {
		String username = "demoUser" + new FakerUtils().generateRandomNumber();
		String password = "demoPwd";
		String email = username + "@gmail.com";
		User user = new User().setUsername(username).setEmail(email).setPassword(password);
		return user;
	}
	
}
