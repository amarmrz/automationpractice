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

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) throws InterruptedException {
		launchApp(browser);

	}
	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void teardown() throws InterruptedException {
		getDriver().quit();

	}

	@Test(dataProvider = "getProduct", dataProviderClass = DataProviders.class,groups={"Regression","Sanity"})
	public void AddtoCartTest(String prduct,String qty,String size) throws InterruptedException {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(prduct);
		Thread.sleep(3000);
		addtocartpage = searchResultPage.clickOnProduct();
		Thread.sleep(3000);
		addtocartpage.enterQuantity(qty);
		addtocartpage.selectSize(size);
		addtocartpage.clickOnAddToCarte();
		Thread.sleep(3000);
		boolean result = addtocartpage.validateAddtoCarte();
		Assert.assertTrue(result);

	}
}
