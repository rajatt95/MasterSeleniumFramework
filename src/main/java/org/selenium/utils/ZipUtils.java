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

import org.zeroturnaround.zip.ZipUtil;

import java.io.File;

import static org.selenium.constants.FrameworkConstants.*;


public class ZipUtils {

	/* make Zip file of Extent Reports in Project Root folder */
	public static void zip() {

		/*
		 * FrameworkConstants.getExtentReportFolderPath():
		 * D:\Work_In_Local_Machine\OneDrive -
		 * Nagarro\Eclipse_Java_Developers_06_2021_Copy\LearningWS\Final_Code\
		 * OC_MasterSeleniumFramework/ExtentReports/
		 * FrameworkConstants.getZipped_ExtentReports_Folder_Name(): ExtentReports.zip
		 */

//		ZipUtil.pack(new File(FrameworkConstants.getExtentReportFolderPath()),
//				new File(FrameworkConstants.getZipped_ExtentReports_Folder_Name()));


		ZipUtil.pack(new File(EXTENT_REPORT_FOLDER_PATH),
				new File(Zipped_ExtentReports_Folder_Name));

		System.out.println("Zipped ExtentReports folder successfuly");
	}

//	public static void main(String[] args) {
//		System.out.println(
//				"FrameworkConstants.getExtentReportFolderPath(): " + FrameworkConstants.getExtentReportFolderPath());
//		System.out.println("FrameworkConstants.getZipped_ExtentReports_Folder_Name(): "
//				+ FrameworkConstants.getZipped_ExtentReports_Folder_Name());
//		String reportsLocation = FrameworkConstants.getProjectPath() + "/ExtentReports";
//		ZipUtil.pack(new File(reportsLocation), new File("ExtentReports.zip"));
//
//	}

}
