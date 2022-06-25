/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author Amar
 *
 */
public class SearchResultPageTest extends BaseClass {
	public IndexPage indexPage;
	public SearchResultPage searchResultPage;

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApp();

	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		driver.quit();

	}

	@Test
	public void verifyProductAvailability() {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		boolean result = searchResultPage.isProductAvailable();
		Assert.assertTrue(result);

	}
}
