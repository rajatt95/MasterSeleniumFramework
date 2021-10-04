package org.selenium.api.actions;

import static io.restassured.RestAssured.given;

import org.selenium.pom.objects.User;
import org.selenium.pom.utils.FakerUtils;

public class DummyClass {

	public static void main(String[] args) {
		// System.out.println(new
		// SignUpApi().fetchRegisterNonceValueUsingGroovyGPath());
		// System.out.println(new SignUpApi().fetchRegisterNonceValueUsingJSoup());
		// API_Call();
		// System.out.println(new FakerUtils().generateRandomNumber());

//		String username = "demoUser" + new FakerUtils().generateRandomNumber();
//		String password = "demoPwd";
//		String email = username + "@gmail.com";
//		User user = new User().setUsername(username).setEmail(email).setPassword(password);
//
//		SignUpApi signUpApi = new SignUpApi();
//		System.out.println(signUpApi.register(user));
//		System.out.println(signUpApi.getCookies());

		/* When User is not logged in */
		/*
		 * CartApi cartApi = new CartApi(); cartApi.addToCart(1215, 1);
		 * System.out.println("------------------------------------");
		 * System.out.println("Cookies: " + cartApi.getCookies());
		 */

		/* When User is logged in */
		String username = "demoUser" + new FakerUtils().generateRandomNumber();
		String password = "demoPwd";
		String email = username + "@gmail.com";
		User user = new User().setUsername(username).setEmail(email).setPassword(password);

		SignUpApi signUpApi = new SignUpApi();
		signUpApi.register(user);
		System.out.println("REGISTER Cookies: " + signUpApi.getCookies());

		CartApi cartApi = new CartApi();
		cartApi.addToCart(1215, 1);
		System.out.println("------------------------------------");
		System.out.println("Add Cart Cookies: " + cartApi.getCookies());
	}

	private static void API_Call() {
		given().log().all().when().get("https://reqres.in/api/users?page=2").then().log().all();
	}

}
