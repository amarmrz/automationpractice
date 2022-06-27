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
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;

/**
 * @author Amar
 *
 */
public class IndexPageTest extends BaseClass {
	public IndexPage indexPage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) throws InterruptedException {
		launchApp(browser);

	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void teardown() throws InterruptedException {
		getDriver().quit();

	}

	@Test(groups = "Smoke")
	public void verifyLogo() throws InterruptedException {
		Log.startTestCase("LoginTest");
		indexPage = new IndexPage();
		Log.info("User is Going To Validate Logo");
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
		Log.info("Logo Is Displayed");
		Log.endTestCase("LoginTest");
	}

	@Test(groups = "Smoke")
	public void getMyStoreTitle() throws InterruptedException {
		indexPage = new IndexPage();
		String Title = indexPage.storeTitle();
		Assert.assertEquals(Title, "My Store");
	}

}
