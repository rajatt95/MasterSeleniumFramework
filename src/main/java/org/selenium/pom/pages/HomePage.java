package org.selenium.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.components.MyHeader;
import org.selenium.pom.components.ProductThumbnail;

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
