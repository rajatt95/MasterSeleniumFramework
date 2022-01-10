package org.selenium.dataproviders;


import java.io.IOException;

import org.selenium.objects.Product;
import org.selenium.utils.JacksonUtils;
import org.testng.annotations.DataProvider;

public class JSONDataProvider {

	@DataProvider(name="getFeaturedProducts",parallel = false)
	public Product[] getFeaturedProducts() throws IOException  {
		return JacksonUtils.deSerializationJSON("products.json", Product[].class);
	}
}
