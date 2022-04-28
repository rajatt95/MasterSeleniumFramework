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

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		System.out.println("----------------METHOD INTERCEPTOR--------------------------");
		System.out.println("methods: " + methods);

		List<IMethodInstance> result = new ArrayList<IMethodInstance>();

		// System.setProperty("testCategory", "BVT,Smoke");
		String testCategory = System.getProperty("testCategory");
		System.out.println("testCategory: " + testCategory);
		for (IMethodInstance method : methods) {
			Test testMethod = method.getMethod().getConstructorOrMethod()
					.getMethod().getAnnotation(Test.class);
			Set<String> groups = new HashSet<String>();
			for (String group : testMethod.groups()) {
				groups.add(group);
			}
			// if (groups.contains("SMOKE")) {
			// if (groups.contains("BVT")) {
			if (groups.contains(testCategory)) {
				result.add(method);
			}
		}
		if (testCategory == null) {
			System.out.println(
					"Either You are not running the test execution from Maven"
					+ " command line or you are not giving the property -D=testCategory");
			return methods;
		} else {
			return result;
		}

	}
}
