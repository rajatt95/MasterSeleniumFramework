package org.selenium.tests.Extent;

import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.enums.AuthorType;
import org.selenium.pom.enums.CategoryType;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

	@FrameworkAnnotation(author = { AuthorType.RAJAT, AuthorType.PANKAJ}, category = { CategoryType.SANITY,CategoryType.BVT })
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
