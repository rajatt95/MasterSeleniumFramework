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

package org.selenium.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		/**
		 * I don't need to add these details with Test case
		 * 
		 * @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
		 */
		annotation.setRetryAnalyzer(RetryFailedTests.class);
		//annotation.setDataProvider("getData");
		//annotation.setDataProviderClass(DataProviderUtils.class);

	}
}
