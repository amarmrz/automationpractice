package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass {
	public IndexPage indexPage;
	public LoginPage loginPage;
	public AccountCreationPage accountcreationPage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) throws InterruptedException {
		launchApp(browser);

	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void teardown() throws InterruptedException {
		getDriver().quit();

	}

	@Test(dataProvider = "email", dataProviderClass = DataProviders.class, groups = "Sanity")
	public void verifyAccountCreationPageTest(String email) {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		accountcreationPage = loginPage.creatNewAccount(email);
		boolean result = accountcreationPage.validateAccountCreatePage();
		Assert.assertTrue(result);

	}

}
