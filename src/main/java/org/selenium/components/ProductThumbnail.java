package org.selenium.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pages.BasePage;
import org.selenium.pages.CartPage;

public class ProductThumbnail extends BasePage {

	public ProductThumbnail(WebDriver driver) {
		super(driver);
	}

	private final By viewCartLink = By.xpath("//a[@title='View cart']");

	private By getAddToCartBtnElement(String productName) {

		return By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
	}

	/*
	 * private By getAddToCartBtnElement(String productName){ return
	 * By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']"); }
	 */
	@Step
	/* Handle Dynamic Elements */
	public ProductThumbnail clickaddToCartBtn(String productName) {
		By addToCartBtn = getAddToCartBtnElement(productName);
		// driver.findElement(addToCartBtn).click();
		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
		return this;
	}

	@Step
	public CartPage clickViewCartLink() {
		// driver.findElement(viewCartLink).click();
		wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
		return new CartPage(driver);
	}

}
