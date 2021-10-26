package org.selenium.utils;

import static org.selenium.constants.FrameworkConstants.ICON_BROWSER_EDGE;
import static org.selenium.constants.FrameworkConstants.ICON_BROWSER_PREFIX;
import static org.selenium.constants.FrameworkConstants.ICON_BROWSER_SUFFIX;
import static org.selenium.constants.FrameworkConstants.ICON_OS_WINDOWS;
import static org.selenium.constants.FrameworkConstants.ICON_OS_MAC;
import static org.selenium.constants.FrameworkConstants.ICON_OS_LINUX;

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
