package org.selenium.utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.selenium.driver.DriverManager;

public final class BrowserInfoUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private BrowserInfoUtils() {
	}

	public static String getBrowserInfo() {
		Capabilities cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
		return cap.getBrowserName().toUpperCase();

	}

	public static String getBrowserVersionInfo() {
		Capabilities cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
		return cap.getVersion();

	}

}
