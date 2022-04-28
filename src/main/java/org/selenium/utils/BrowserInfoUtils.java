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

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.selenium.driver.DriverManager;

public final class BrowserInfoUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private BrowserInfoUtils() {
	}

	public static String getBrowserInfo() {
		Capabilities capabilities = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
		return capabilities.getBrowserName().toUpperCase();

	}

	public static String getBrowserVersionInfo() {
		Capabilities capabilities = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
		return capabilities.getVersion();

	}

}
