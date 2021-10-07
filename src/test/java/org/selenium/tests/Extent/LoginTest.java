package org.selenium.tests.Extent;

import java.io.IOException;

import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.api.actions.CartApi;
import org.selenium.api.actions.SignUpApi;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.enums.AuthorType;
import org.selenium.pom.enums.CategoryType;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@FrameworkAnnotation(author = { AuthorType.GAUTAM, AuthorType.PANKAJ}, category = { CategoryType.SANITY,CategoryType.SMOKE })
	@Test
	public void loginDuringCheckout() throws IOException, InterruptedException {

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
		checkoutPage.clickHereToLoginLink().login(user);
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