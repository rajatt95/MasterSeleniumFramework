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

import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.constants.FrameworkConstants;
import org.selenium.driver.DriverManager;
import org.selenium.enums.WaitStrategy;
import org.selenium.factories.ExplicitWaitFactory;
import org.selenium.reports.ExtentLogger;
import org.selenium.reports.ExtentManager;
import org.selenium.utils.ConfigLoader;
import org.selenium.utils.ScreenshotUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.selenium.constants.FrameworkConstants.ICON_Navigate_Right;
import static org.selenium.constants.FrameworkConstants.WAIT;

public class BasePage {

	/* Class level -> Not Thread safe */
	/*
	 * No need to use ThreadLocal, because when we are creating the Object of Page,
	 * those objects are local to test methods.
	 */
	protected WebDriver driver;
	protected WebDriverWait wait;

	/*
	 * Many waits can also be used in case you want to different time wait for
	 * different web elements
	 */
//	protected WebDriverWait waitLong;
//	protected WebDriverWait waitShort;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, FrameworkConstants.getExplicitWait());
//		waitLong = new WebDriverWait(driver, 25);
//		waitShort = new WebDriverWait(driver, 5);

	}

	public void load(String endPoint) {
		// driver.get("https://askomdch.com/" + endPoint);
		driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
		ExtentLogger.info(ICON_Navigate_Right + "  Navigating to : <b>" + ConfigLoader.getInstance().getBaseUrl()
				+ endPoint + "</b>");
	}

	public void waitForOverlaysToDisappear(By overlay) {
		List<WebElement> overlays = driver.findElements(overlay);
		System.out.println("OVERLAY SIZE" + overlays.size());
		if (overlays.size() > 0) {
			wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
			System.out.println("OVERLAY INVISIBLE NOW");
		} else {
			System.out.println("OVERLAY NOT FOUND");
		}
	}

	protected void click(By by, WaitStrategy waitStrategy, String elementName) {
		// DriverManager.getDriver().findElement(by).click();
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).click();
		ExtentLogger.pass("<b>" + elementName + "</b> is clicked", true);
		// log(PASS,elementName+" is clicked");
	}

	protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).sendKeys(value);
		ExtentLogger.pass("<b>" + value + "</b> is entered successfully in <b>" + elementName + "</b>", true);
		// log(PASS,value +" is entered successfully in "+elementName);
	}

	protected void clear(By by, WaitStrategy waitStrategy, String elementName) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).clear();
		ExtentLogger.info("Clearing the field  <b>" + elementName + "</b>");
		// log(PASS,value +" is entered successfully in "+elementName);
	}

	protected void clearAndSendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.clear();
		element.sendKeys(value);
		ExtentLogger.pass("<b>" + value + "</b> is entered successfully in <b>" + elementName + "</b>", true);
		// log(PASS,value +" is entered successfully in "+elementName);
	}

	/*
	 * protected String getElementName(By by) { return
	 * DriverManager.getDriver().findElement(by).getText(); }
	 */
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	/*
	 * public WebElement getElement(By element) { return
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(element)); }
	 */

	protected void captureScreenshot() {
		ExtentManager.getExtentTest().info("Capturing Screenshot",
				MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
	}

	protected void waitForSomeTime() {
		Uninterruptibles.sleepUninterruptibly(WAIT, TimeUnit.SECONDS);
	}

	protected void waitForGivenTime(long time) {
		Uninterruptibles.sleepUninterruptibly(time, TimeUnit.SECONDS);
	}

}
