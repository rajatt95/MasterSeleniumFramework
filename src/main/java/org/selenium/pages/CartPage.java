package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.base.BasePage;
import org.selenium.enums.WaitStrategy;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public Boolean isLoaded() {
		return wait.until(ExpectedConditions.textToBe(cartHeading, "Cart"));
	}

	// private final By productName = By.xpath("//a[normalize-space()='Blue
	// Shoes']");
	@FindBy(css = "td[class='product-name'] a")
	private WebElement productName;
	private final By checkoutBtn = By.xpath("//a[normalize-space()='Proceed to checkout']");
	private final By cartHeading = By.cssSelector(".has-text-align-center");

	public String getProductName() {
		// return driver.findElement(productName).getText();
		// return
		// wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
		return wait.until(ExpectedConditions.visibilityOf(productName)).getText();

	}

	public CheckoutPage checkout() {
		// driver.findElement(checkoutBtn).click();
		// wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
		click(checkoutBtn, WaitStrategy.CLICKABLE, "Checkout");
		return new CheckoutPage(driver);
	}
}