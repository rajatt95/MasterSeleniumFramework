package org.selenium.tests;

import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import org.selenium.pages.HomePage;
import org.selenium.pages.StorePage;
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
