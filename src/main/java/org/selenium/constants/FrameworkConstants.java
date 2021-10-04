package org.selenium.constants;

import org.selenium.pom.utils.ConfigLoader;

public class FrameworkConstants {

	private static final String PROJECT_PATH = System.getProperty("user.dir");
	private static final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/test/resources";

	private static final String YES = "yes";
	private static final String NO = "no";

	private static final int EXPLICIT_WAIT = 10;

	private static final String EXTENT_REPORT_FOLDER_PATH = PROJECT_PATH + "/ExtentReports/";
	private static final String EXTENT_REPORT_NAME = "index.html";
	private static String extentReportFilePath = "";

	public static String getYes() {
		return YES;
	}

	public static String getNo() {
		return NO;
	}

	public static String getExtentReportName() {
		return EXTENT_REPORT_NAME;
	}

	public static String getExtentReportFilePath() {

		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	private static String createReportPath() {
		// if
		// (PropertyUtils.get(ConfigProperties.OVERRIDE_REPORTS).equalsIgnoreCase("no"))
		// {
		if (ConfigLoader.getInstance().getOverrideReports().equalsIgnoreCase(getNo())) {
			return EXTENT_REPORT_FOLDER_PATH + System.currentTimeMillis() + "_" + getExtentReportName();
		} else {
			return EXTENT_REPORT_FOLDER_PATH + getExtentReportName();
		}
	}

	public static void setExtentReportFilePath(String extentReportFilePath) {
		FrameworkConstants.extentReportFilePath = extentReportFilePath;
	}

	public static int getExplicitWait() {
		return EXPLICIT_WAIT;
	}
}
