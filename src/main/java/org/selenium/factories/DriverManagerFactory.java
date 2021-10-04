package org.selenium.factories;

import org.selenium.pom.driver.DriverManagerChrome;
import org.selenium.pom.driver.DriverManagerEdge;
import org.selenium.pom.driver.DriverManagerFirefox;
import org.selenium.pom.driver.DriverManagerOpera;
import org.selenium.pom.driver.DriverManagerSafari;
import org.selenium.pom.driver.DriverManager_OC;
import org.selenium.pom.enums.DriverType;

public class DriverManagerFactory {

	public static DriverManager_OC getManager(DriverType driverType) {

		switch (driverType) {
		
		case CHROME : {
			return new DriverManagerChrome();
		}
		case FIREFOX : {
			return new DriverManagerFirefox();
		}
		case EDGE : {
			return new DriverManagerEdge();
		}
		case SAFARI : {
			return new DriverManagerSafari();
		}
		case OPERA : {
			return new DriverManagerOpera();
		}
		default : throw new IllegalArgumentException("Invalid Driver: " + driverType);	
		}
		/*case CHROME -> {
			return new DriverManagerChrome();
		}
		case FIREFOX -> {
			return new DriverManagerFirefox();
		}
		case EDGE -> {
			return new DriverManagerEdge();
		}
		case SAFARI -> {
			return new DriverManagerSafari();
		}
		case OPERA -> {
			return new DriverManagerOpera();
		}
		default -> throw new IllegalArgumentException("Invalid Driver: " + driverType);	
		}*/
	}

}
