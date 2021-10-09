package org.selenium.tests.Extent;

import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.enums.AuthorType;
import org.selenium.pom.enums.CategoryType;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest{

	@FrameworkAnnotation(author = { AuthorType.RAJAT, AuthorType.NISHANT}, 
			category = { CategoryType.BVT,CategoryType.REGRESSION })
	@Test(groups = {"BVT","REGRESSION"})
	public void navigateFromHomeToStoreUsingMainMenu() {
		
		StorePage storePage =
				new HomePage(getDriver()).
					load().
					getMyHeader().
					navigateToStoreUsingMenu();
	
		Assert.assertEquals(storePage.getTitle(), "Store");

	}
	
	
}
