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
		Capabilities capabilities = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
		return capabilities.getBrowserName().toUpperCase();

	}

	public static String getBrowserVersionInfo() {
		Capabilities capabilities = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
		return capabilities.getVersion();

	}

}
