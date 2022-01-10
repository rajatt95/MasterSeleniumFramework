package org.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManagerOpera implements DriverManager_OC {

	@Override
	public WebDriver createDriver() {
		WebDriverManager.operadriver().setup();
		WebDriver driver = new OperaDriver();
		driver.manage().window().maximize();
		return driver;
	}
}
