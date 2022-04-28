package org.selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverManagerOpera implements DriverManager_OC {

	@Override
	public WebDriver createDriver() {
		WebDriverManager.operadriver().setup();
		WebDriver driver = new OperaDriver();
		driver.manage().window().maximize();
		return driver;
	}
}
