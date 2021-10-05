package org.selenium.tests.ExtentReports_issue;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

	@Test
	public void searchWithPartialMatch() {

		String searchFor = "Blue";
		StorePage storePage = new StorePage(getDriver()).
				load().
				enterTextInSearchField(searchFor).
				clickSearchBtn();

		Assert.assertEquals(storePage.getTitle(), "Search results: “" + searchFor + "”");

	}

}
