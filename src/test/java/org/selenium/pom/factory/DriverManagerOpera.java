package org.selenium.pom.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManagerOpera implements DriverManager {

	@Override
	public WebDriver createDriver() {
		WebDriverManager.operadriver().setup();
		WebDriver driver = new OperaDriver();
		driver.manage().window().maximize();
		return driver;
	}
}
