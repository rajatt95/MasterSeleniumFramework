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

package org.selenium.dataproviders;


import org.selenium.objects.Product;
import org.selenium.utils.JacksonUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class JSONDataProvider {

	@DataProvider(name="getFeaturedProducts",parallel = false)
	public Product[] getFeaturedProducts() throws IOException  {
		return JacksonUtils.deSerializationJSON("products.json", Product[].class);
	}
}
