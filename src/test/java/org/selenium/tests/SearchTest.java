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

package org.selenium.tests;

import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import org.selenium.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

	@FrameworkAnnotation(author = { AuthorType.RAJAT, AuthorType.PANKAJ }, category = { CategoryType.SANITY,
			CategoryType.BVT,CategoryType.REGRESSION })
	@Test(groups = { "SANITY", "BVT", "REGRESSION" })
	public void searchWithPartialMatch() {

		String searchFor = "Blue";
		StorePage storePage = 
				new StorePage(getDriver()).
					load().
					enterTextInSearchField(searchFor).
					clickSearchBtn();

		Assert.assertEquals(storePage.getTitle(), "Search results: “" + searchFor + "”");

	}

}
