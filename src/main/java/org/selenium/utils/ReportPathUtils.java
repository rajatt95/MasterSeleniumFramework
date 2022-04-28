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

package org.selenium.utils;

import static org.selenium.constants.FrameworkConstants.*;

//final -> We do not want any class to extend this class
public final class ReportPathUtils {

	// private -> We do not want anyone to create the object of this class
	// Private constructor to avoid external instantiation
	private ReportPathUtils() {
	}

	public static String createExtentReportPath() {
		if (ConfigLoader.getInstance().getOverrideReports().equalsIgnoreCase(NO)) {
			/**
			 * Report name ->
			 *
			 * Windows_10_Tue_Oct_05_02_30_46_IST_2021_AutomationReport.html
			 * Mac_OS_X_Tue_Feb_22_17_09_05_IST_2022_AutomationReport.html
			 */
			return EXTENT_REPORT_FOLDER_PATH + OSInfoUtils.getOSInfo() + "_" + DateUtils.getCurrentDate() + "_"
					+ EXTENT_REPORT_NAME;

		} else {
			return EXTENT_REPORT_FOLDER_PATH + EXTENT_REPORT_NAME;
		}
	}
}
