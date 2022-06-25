/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
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

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApp();

	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		driver.quit();

	}

	@Test
	public void wishListTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homepage.validateMywishList();
		Assert.assertTrue(result);

	}

	@Test
	public void OrderHistoryTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homepage.validateOrderHistory();
		Assert.assertTrue(result);

	}

}
