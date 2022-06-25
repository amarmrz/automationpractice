/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddtoCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author Amar
 *
 */
public class AddtoCartPageTest extends BaseClass {
	public IndexPage indexPage;
	public SearchResultPage searchResultPage;
	public AddtoCartPage addtocartpage;

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApp();

	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		getDriver().quit();

	}

	@Test
	public void AddtoCartTest() throws InterruptedException {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		Thread.sleep(3000);
		addtocartpage = searchResultPage.clickOnProduct();
		Thread.sleep(3000);
		addtocartpage.enterQuantity("2");
		addtocartpage.selectSize("M");
		addtocartpage.clickOnAddToCarte();
		Thread.sleep(3000);
		boolean result = addtocartpage.validateAddtoCarte();
		Assert.assertTrue(result);

	}
}
