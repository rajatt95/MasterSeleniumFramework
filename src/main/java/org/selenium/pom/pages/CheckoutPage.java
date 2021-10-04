package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.enums.WaitStrategy;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.User;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public CheckoutPage load() {
		load("/checkout");
		return this;
	};

	private final By firstNameFld = By.id("billing_first_name");
	private final By lastNameFld = By.id("billing_last_name");
	private final By addressLineOneFld = By.id("billing_address_1");
	private final By billingCityFld = By.id("billing_city");
	private final By billingPostCodeFld = By.id("billing_postcode");
	private final By billingEmailFld = By.id("billing_email");
	private final By placeOrderBtn = By.xpath("//button[normalize-space()='Place order']");
	private final By successNotice = By.xpath("//p[contains(@class,'woocommerce-thankyou-order-received')]");

	private final By clickHereToLoginLink = By.xpath("//a[@class='showlogin']");
	private final By usernameFld = By.id("username");
	private final By passwordFld = By.id("password");
	private final By loginBtn = By.xpath("//button[@name='login']");
	private final By overlay = By.cssSelector(".blockUI.blockOverlay");
	private final By countryDropDown = By.id("billing_country");
	private final By stateDropDown = By.id("billing_state");
	private final By directBankTransferRadioBtn = By.id("payment_method_bacs");

	private final By alternateCountryDropDown = By.id("select2-billing_country-container");
	private final By alternateStateDropDown = By.id("select2-billing_state-container");

	private final By productName = By.cssSelector("td[class='product-name']");

	/* Builder Pattern - used for Method Chaining */
	/* Structural Page Object */
	/* 1 method will do 1 operation --> sendKeys() */
	public CheckoutPage enterFirstName(String firstName) {
		/*
		 * driver.findElement(firstNameFld).clear();
		 * driver.findElement(firstNameFld).sendKeys(firstName);
		 */
		/*
		 * WebElement element =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameFld));
		 * element.clear(); element.sendKeys(firstName);
		 */
		clearAndSendKeys(firstNameFld, firstName, WaitStrategy.PRESENCE, "First Name Field");
		return this;
	}

	public CheckoutPage selectCountry(String countryName) {
		// Select select = new
		// Select(wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropDown)));

		/*
		 * Select select = new Select(driver.findElement(countryDropDown));
		 * select.selectByVisibleText(countryName);
		 */

		// wait.until(ExpectedConditions.elementToBeClickable(alternateCountryDropDown)).click();
		click(alternateCountryDropDown, WaitStrategy.CLICKABLE, "Alternate Country DropDown");
		WebElement e = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='" + countryName + "']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
		e.click();
		System.out.println("Country selected from Dropdown: " + countryName);
		return this;
	}

	public CheckoutPage selectState(String stateName) {
		// Select select = new
		// Select(wait.until(ExpectedConditions.visibilityOfElementLocated(stateDropDown)));
		/*
		 * Select select = new Select(driver.findElement(stateDropDown));
		 * select.selectByVisibleText(stateName);
		 */
		// wait.until(ExpectedConditions.elementToBeClickable(alternateStateDropDown)).click();
		click(alternateStateDropDown, WaitStrategy.CLICKABLE, "Alternate State DropDown");
		WebElement e = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='" + stateName + "']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
		e.click();
		System.out.println("Country selected from Dropdown: " + stateName);
		return this;
	}

	public CheckoutPage enterLastName(String lastName) {

//		driver.findElement(lastNameFld).clear();
//		driver.findElement(lastNameFld).sendKeys(lastName);	
		/*
		 * WebElement element =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameFld));
		 * element.clear(); element.sendKeys(lastName);
		 */

		clearAndSendKeys(lastNameFld, lastName, WaitStrategy.PRESENCE, "Last Name Field");

		return this;
	}

	public CheckoutPage enteraddressLineOne(String addressLineOne) {
//		driver.findElement(addressLineOneFld).clear();
//		driver.findElement(addressLineOneFld).sendKeys(addressLineOne);
		/*
		 * WebElement element =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(addressLineOneFld));
		 * element.clear(); element.sendKeys(addressLineOne);
		 */
		clearAndSendKeys(addressLineOneFld, addressLineOne, WaitStrategy.PRESENCE, "Address Line One Field");

		return this;
	}

	public CheckoutPage enterCity(String city) {
//		driver.findElement(billingCityFld).clear();
//		driver.findElement(billingCityFld).sendKeys(city);
		/*
		 * WebElement element =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(billingCityFld));
		 * element.clear(); element.sendKeys(city);
		 */

		clearAndSendKeys(billingCityFld, city, WaitStrategy.PRESENCE, "Billing City Field");
		return this;
	}

	public CheckoutPage enterPostCode(String postCode) {
//		driver.findElement(billingPostCodeFld).clear();
//		driver.findElement(billingPostCodeFld).sendKeys(postCode);
		/*
		 * WebElement element =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(billingPostCodeFld))
		 * ; element.clear(); element.sendKeys(postCode);
		 */
		clearAndSendKeys(billingPostCodeFld, postCode, WaitStrategy.PRESENCE, "Billing Post Code Field");

		return this;
	}

	public CheckoutPage enterEmail(String email) {
//		driver.findElement(billingEmailFld).clear();
//		driver.findElement(billingEmailFld).sendKeys(email);
		/*
		 * WebElement element =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(billingEmailFld));
		 * element.clear(); element.sendKeys(email);
		 */
		clearAndSendKeys(billingEmailFld, email, WaitStrategy.PRESENCE, "Billing Email Field");

		return this;
	}

	public CheckoutPage placeOrder() {
		waitForOverlaysToDisappear(overlay);
		// driver.findElement(placeOrderBtn).click();
		// wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
		click(placeOrderBtn, WaitStrategy.CLICKABLE, "Place order button");
		return this;
	}

	public String getNotice() {
		// return driver.findElement(successNotice).getText();
		return wait.until(ExpectedConditions.visibilityOfElementLocated(successNotice)).getText();

	}

	public CheckoutPage clickHereToLoginLink() {
		// driver.findElement(clickHereToLoginLink).click();
		// wait.until(ExpectedConditions.elementToBeClickable(clickHereToLoginLink)).click();
		click(clickHereToLoginLink, WaitStrategy.CLICKABLE, "Click Here To Login Link");
		return this;
	}

	public CheckoutPage enterUsername(String username) {
//		driver.findElement(usernameFld).clear();
//		driver.findElement(usernameFld).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFld)).sendKeys(username);
		return this;
	}

	public CheckoutPage enterPassword(String password) {
//		driver.findElement(passwordFld).clear();
//		driver.findElement(passwordFld).sendKeys(password);
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFld)).sendKeys(password);
		return this;
	}

	public CheckoutPage clickLoginBtn() {
		// driver.findElement(loginBtn).click();
		// wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
		click(loginBtn, WaitStrategy.CLICKABLE, "Login button");
		return this;
	}

	/* Functional Page Object */
	public CheckoutPage login(String username, String password) {
		/* Builder Pattern - Method chaining */
		return enterUsername(username).enterPassword(password).clickLoginBtn();
	}

	private CheckoutPage waitForLoginBtnToDisapper() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loginBtn));
		return this;
	}

	public CheckoutPage login(User user) {
		/* Builder Pattern - Method chaining */
		return enterUsername(user.getUsername()).enterPassword(user.getPassword()).clickLoginBtn()
				.waitForLoginBtnToDisapper();
	}

	public CheckoutPage setBillingAddress(BillingAddress billingAddress) {
		return enterFirstName(billingAddress.getFirstName()).enterLastName(billingAddress.getLastName())
				.selectCountry(billingAddress.getCountry()).enteraddressLineOne(billingAddress.getAddressLineOne())
				.enterCity(billingAddress.getCity()).selectState(billingAddress.getState())
				.enterPostCode(billingAddress.getPostalCode()).enterEmail(billingAddress.getEmail());

	}

	public CheckoutPage selectDirectBankTransfer() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(directBankTransferRadioBtn));
		if (!element.isSelected()) {
			element.click();
		}
		return this;
	}

	public String getProductName() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
	}

}