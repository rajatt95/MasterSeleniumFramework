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

package org.selenium.driver;

import org.selenium.enums.DriverType;

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
