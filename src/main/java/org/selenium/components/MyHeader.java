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

package org.selenium.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.enums.WaitStrategy;
import org.selenium.pages.BasePage;
import org.selenium.pages.StorePage;

public class MyHeader extends BasePage {

	public MyHeader(WebDriver driver) {
		super(driver);
	}

	private final By storeMenuLink = By.xpath("//li[@id='menu-item-1227']//a");

	/* Fluent Interface */
	public StorePage navigateToStoreUsingMenu() {
		// driver.findElement(storeMenuLink).click();
		//wait.until(ExpectedConditions.elementToBeClickable(storeMenuLink)).click();
		click(storeMenuLink, WaitStrategy.CLICKABLE, "Store Menu Link");
		return new StorePage(driver);
	}

}
