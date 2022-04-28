/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Selenium Java Test Framework & Best Practices - Masterclass (https://www.udemy.com/course/selenium-java-test-framework/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 * Tutor: Amuthan Sakthivel (https://www.testingminibytes.com/)
 */

/***************************************************/

package org.selenium.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.constants.FrameworkConstants;
import org.selenium.driver.DriverManager;
import org.selenium.enums.WaitStrategy;

public final class ExplicitWaitFactory {

	private ExplicitWaitFactory() {
	}

	public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {

		WebElement element = null;
		if (waitStrategy == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
					.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if (waitStrategy == WaitStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} 
		else if (waitStrategy == WaitStrategy.VISIBLE) {
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} 
		else if (waitStrategy == WaitStrategy.NONE) {
			System.out.println("Not Waiting for anything");
			element = DriverManager.getDriver().findElement(by);
		}
		return element;

		// wait.until(d -> d.findElement(link_logout).isEnabled());// Java 8 way

	}
}
