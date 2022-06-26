/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author Amar
 *
 */
public class SearchResultPageTest extends BaseClass {
	public IndexPage indexPage;
	public SearchResultPage searchResultPage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) throws InterruptedException {
		launchApp(browser);

	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void teardown() throws InterruptedException {
		getDriver().quit();

	}

	@Test(dataProvider = "SearchProduct", dataProviderClass = DataProviders.class, groups = "Smoke")
	public void verifyProductAvailability(String productSrch) {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(productSrch);
		boolean result = searchResultPage.isProductAvailable();
		Assert.assertTrue(result);

	}
}
