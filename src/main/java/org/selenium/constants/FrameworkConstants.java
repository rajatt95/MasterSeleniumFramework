package org.selenium.constants;

import java.util.Date;

import org.selenium.utils.ConfigLoader;
import org.selenium.utils.OSInfoUtils;

public class FrameworkConstants {

	private static final String PROJECT_PATH = System.getProperty("user.dir");
	// private static final String RESOURCES_PATH = System.getProperty("user.dir") +
	// "/src/test/resources";

	/* ICONS - START */
	public static final String ICON_SMILEY_PASS = "<i class='fa fa-smile-o' style='font-size:24px'></i>";
	public static final String ICON_SMILEY_SKIP = "<i class=\"fas fa-frown-open\"></i>";
	public static final String ICON_SMILEY_FAIL = "<i class='fa fa-frown-o' style='font-size:24px'></i>";

	public static final String ICON_OS_WINDOWS = "<i class='fa fa-windows' ></i>";
	public static final String ICON_OS_MAC = "<i class='fa fa-apple' ></i>";
	public static final String ICON_OS_LINUX = "<i class='fa fa-linux' ></i>";

//	public static final String ICON_BROWSER_OPERA = "<i class=\"fa fa-opera\" aria-hidden=\"true\"></i>";
//	public static final String ICON_BROWSER_EDGE = "<i class=\"fa fa-edge\" aria-hidden=\"true\"></i>";
//	public static final String ICON_BROWSER_CHROME = "<i class=\"fa fa-chrome\" aria-hidden=\"true\"></i>";
//	public static final String ICON_BROWSER_FIREFOX = "<i class=\"fa fa-firefox\" aria-hidden=\"true\"></i>";
//	public static final String ICON_BROWSER_SAFARI = "<i class=\"fa fa-safari\" aria-hidden=\"true\"></i>";

	public static final String ICON_Navigate_Right = "<i class='fa fa-arrow-circle-right' ></i>";
	public static final String ICON_LAPTOP = "<i class='fa fa-laptop' style='font-size:18px'></i>";
	public static final String ICON_BUG = "<i class='fa fa-bug' ></i>";
	/* style="text-align:center;" */
	public static final String ICON_SOCIAL_LINKEDIN_URL = "https://www.linkedin.com/in/rajat-v-3b0685128/";
	public static final String ICON_SOCIAL_GITHUB_URL = "https://github.com/rajatt95";
	public static final String ICON_SOCIAL_LINKEDIN = "<a href='" + ICON_SOCIAL_LINKEDIN_URL
			+ "'><i class='fa fa-linkedin-square' style='font-size:24px'></i></a>";
	public static final String ICON_SOCIAL_GITHUB = "<a href='" + ICON_SOCIAL_GITHUB_URL
			+ "'><i class='fa fa-github-square' style='font-size:24px'></i></a>";

//	public static final String ICON_SOCIAL_LINKEDIN = "<i class='fa fa-linkedin-square' style='font-size:24px'></i>";
//	public static final String ICON_SOCIAL_GITHUB = "<i class='fa fa-github-square' style='font-size:24px'></i>";
//	public static final String ICON_SOCIAL_LINKEDIN_VALUE = "<a href='https://www.linkedin.com/in/rajat-v-3b0685128/'>LinkedIn</a>";
//	public static final String ICON_SOCIAL_GITHUB_VALUE = "https://github.com/rajatt95";

	public static final String ICON_CAMERA = "<i class=\"fa fa-camera\" aria-hidden=\"true\"></i>";

	public static final String ICON_BROWSER_EDGE = "edge";
	public static final String ICON_BROWSER_PREFIX = "<i class=\"fa fa-";
	public static final String ICON_BROWSER_SUFFIX = "\" aria-hidden=\"true\"></i>";
	/* ICONS - END */

	public static final String ASSERTION_FOR_RESPONSE_STATUS_CODE = "Assertion for Response Status Code";
	public static final String ASSERTION_FOR_RESPONSE_HEADER = "Assertion for Response Headers";
	public static final String ASSERTION_FOR_RESPONSE_CUSTOM_FIELD = "Assertion for Response Custom Field";

	private static final String YES = "yes";
	private static final String NO = "no";

	private static final int EXPLICIT_WAIT = 10;

	private static final String EXTENT_REPORT_FOLDER_PATH = PROJECT_PATH + "/ExtentReports/";
	private static final String EXTENT_REPORT_NAME = "AutomationReport.html";
	private static String extentReportFilePath = "";

	/** Zip file of Extent Reports */
	private static final String Zipped_ExtentReports_Folder_Name = "ExtentReports.zip";

	private static final String Project_Name = "Automation Test Suite Report - Master Selenium Framework";

	public static String getProjectPath() {
		return PROJECT_PATH;
	}

	public static String getProjectName() {
		return Project_Name;
	}

	public static String getZipped_ExtentReports_Folder_Name() {
		return Zipped_ExtentReports_Folder_Name;
	}

	public static String getYes() {
		return YES;
	}

	public static String getNo() {
		return NO;
	}

	public static String getExtentReportName() {
		return EXTENT_REPORT_NAME;
	}

	public static String getExtentReportFolderPath() {
		return EXTENT_REPORT_FOLDER_PATH;
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

			/*
			 * Report name -> Windows_10_Tue_Oct_05_02_30_46_IST_2021_AutomationReport.html
			 */
			return EXTENT_REPORT_FOLDER_PATH + OSInfoUtils.getOSInfo() + "_" + getCurrentDate() + "_"
					+ getExtentReportName();

		} else {
			return EXTENT_REPORT_FOLDER_PATH + getExtentReportName();
		}
	}

	private static String getCurrentDate() {
		Date date = new Date();
		return date.toString().replace(":", "_").replace(" ", "_");
	}

	public static void setExtentReportFilePath(String extentReportFilePath) {
		FrameworkConstants.extentReportFilePath = extentReportFilePath;
	}

	public static int getExplicitWait() {
		return EXPLICIT_WAIT;
	}

}
