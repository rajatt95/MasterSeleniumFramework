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

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.selenium.driver.DriverManager;

public final class ScreenshotUtils {

	private ScreenshotUtils() {
	}

	public static String getBase64Image() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
