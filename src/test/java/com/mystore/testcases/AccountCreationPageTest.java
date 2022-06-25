package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass {
	public IndexPage indexPage;
	public LoginPage loginPage;
	public AccountCreationPage accountcreationPage;

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApp();

	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		driver.quit();

	}

	@Test
	public void verifyAccountCreationPageTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		accountcreationPage = loginPage.creatNewAccount("aliali@gmail.com");
		boolean result = accountcreationPage.validateAccountCreatePage();
		Assert.assertTrue(result);

	}

}
