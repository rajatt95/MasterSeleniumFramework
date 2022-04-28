package org.selenium.utils;

import static org.selenium.constants.FrameworkConstants.*;

public final class IconUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private IconUtils() {
	}

	public static String getBrowserIcon() {
		String browserInLowerCase = BrowserInfoUtils.getBrowserInfo().toLowerCase();
		if (browserInLowerCase.contains(ICON_BROWSER_EDGE)) {
			return ICON_BROWSER_PREFIX + ICON_BROWSER_EDGE + ICON_BROWSER_SUFFIX;
			//return "<i class='fa-brands fa-edge'></i>";
		} else {
			return ICON_BROWSER_PREFIX + browserInLowerCase + ICON_BROWSER_SUFFIX;
		}
	}

	public static String getOSIcon() {

		String operSys = OSInfoUtils.getOSInfo().toLowerCase();
		if (operSys.contains("win")) {
			return ICON_OS_WINDOWS;
		} else if (operSys.contains("nix") || operSys.contains("nux") || operSys.contains("aix")) {
			return ICON_OS_LINUX;
		} else if (operSys.contains("mac")) {
			return ICON_OS_MAC;
		}
		return operSys;
	}
}
