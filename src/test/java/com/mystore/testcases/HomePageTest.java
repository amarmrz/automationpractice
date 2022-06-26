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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * @author Amar
 *
 */
public class HomePageTest extends BaseClass {

	public IndexPage indexPage;
	public LoginPage loginPage;
	public HomePage homepage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) throws InterruptedException {
		launchApp(browser);

	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void teardown() throws InterruptedException {
		getDriver().quit();

	}

	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = "Smoke")

	public void wishListTest(String userName, String password) {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homepage = loginPage.login(userName, password);
		boolean result = homepage.validateMywishList();
		Assert.assertTrue(result);

	}

	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void OrderHistoryTest(String userName, String password) {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homepage = loginPage.login(userName, password);
		boolean result = homepage.validateOrderHistory();
		Assert.assertTrue(result);

	}

}
