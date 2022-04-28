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
