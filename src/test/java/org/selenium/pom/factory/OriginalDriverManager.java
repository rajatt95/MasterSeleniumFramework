package org.selenium.pom.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.selenium.pom.constants.DriverType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OriginalDriverManager {

	public WebDriver initializeDriver(String browser) {

		WebDriver driver;

		switch (DriverType.valueOf(browser)) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case OPERA:
			/*
			 * Now, WDM will download the Dependencies at Drivers folder present in Project
			 * Root location
			 */
			// WebDriverManager.operadriver().cachePath("Drivers").setup();
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;
		case SAFARI:
			driver = new SafariDriver();
			break;
		default:
			throw new IllegalStateException("Invalid Browser name: " + browser);
		}
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	

}
