package org.selenium.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

	public Long generateRandomNumber() {
		Faker faker = new Faker();
		// return faker.number().randomNumber();
		return faker.number().randomNumber(10, true);
	}
}
