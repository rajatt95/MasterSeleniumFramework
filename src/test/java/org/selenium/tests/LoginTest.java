package org.selenium.tests;

import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.api.actions.CartApi;
import org.selenium.api.actions.SignUpApi;
import org.selenium.base.BaseTest;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import org.selenium.objects.Product;
import org.selenium.objects.User;
import org.selenium.pages.CheckoutPage;
import org.selenium.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {

	@FrameworkAnnotation(author = { AuthorType.GAUTAM, AuthorType.PANKAJ}, 
			category = { CategoryType.SANITY,CategoryType.SMOKE,CategoryType.REGRESSION })
	@Test(groups = {"SANITY","SMOKE","REGRESSION"})
	public void loginDuringCheckout_ATOMIC_TEST() throws IOException, InterruptedException {

		/* Do this using RestAssured library - WebService part */
		User user = getUser();

		SignUpApi signUpApi = new SignUpApi();
		signUpApi.register(user);
		System.out.println("REGISTER Cookies: " + signUpApi.getCookies());

		CartApi cartApi = new CartApi();
		Product product = new Product(1215);
		cartApi.addToCart(product.getId(), 1);

		/* Do this using WebDriver library - UI part */
		CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();
		Thread.sleep(5000);

		/* We can only inject the Cookies after loading the URL into Browser */
		injectCookiesToBrowser(cartApi.getCookies());

		checkoutPage.load();
		Thread.sleep(5000);
		checkoutPage.
			clickHereToLoginLink().
			login(user);
		Thread.sleep(5000);
		Assert.assertTrue(checkoutPage.getProductName().contains(product.getName()));

	}

	private User getUser() {
		String username = "demoUser" + new FakerUtils().generateRandomNumber();
		String password = "demoPwd";
		String email = username + "@gmail.com";
		User user = new User().setUsername(username).setEmail(email).setPassword(password);
		return user;
	}

}
