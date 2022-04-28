/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Selenium Java Test Framework & Best Practices - Masterclass (https://www.udemy.com/course/selenium-java-test-framework/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 */

/***************************************************/

package org.selenium.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

	public Long generateRandomNumber() {
		Faker faker = new Faker();
		// return faker.number().randomNumber();
		return faker.number().randomNumber(10, true);
	}
}
