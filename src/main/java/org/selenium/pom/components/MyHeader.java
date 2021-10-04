package org.selenium.pom.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.enums.WaitStrategy;
import org.selenium.pom.pages.StorePage;

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
