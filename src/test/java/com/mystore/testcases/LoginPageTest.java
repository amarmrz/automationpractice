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
import com.mystore.utility.Log;

/**
 * @author Amar
 *
 */
public class LoginPageTest extends BaseClass {
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

	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = { "Sanity", "Smoke" })
	public void validateLogin(String userName, String password) throws InterruptedException {
		Log.startTestCase("LoginTest");
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		Thread.sleep(3000);
		Log.info("User is Going To enter Credentials");
		// homepage = loginPage.login(prop.getProperty("username"),
		// prop.getProperty("password"));
		homepage = loginPage.login(userName, password);
		Thread.sleep(3000);
		String actualUrl = homepage.validateHomePage();
		String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualUrl, expectedUrl);
		Log.endTestCase("LoginTest");
	}
}
