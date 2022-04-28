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

package org.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.components.MyHeader;
import org.selenium.components.ProductThumbnail;

public class HomePage extends BasePage {

	private MyHeader myHeader;
	private ProductThumbnail productThumbnail;

	public HomePage(WebDriver driver) {
		super(driver);
		myHeader = new MyHeader(driver);
		productThumbnail = new ProductThumbnail(driver);
	}

	public MyHeader getMyHeader() {
		return myHeader;
	}

	public ProductThumbnail getProductThumbnail() {
		return productThumbnail;
	}

	public HomePage load() {
		load("");
		wait.until(ExpectedConditions.titleContains("AskOmDch"));
		return this;
	}

}
