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

/**
 * @author Amar
 *
 */
public class IndexPageTest extends BaseClass {
	public IndexPage indexPage;

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApp();

	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		getDriver().quit();

	}

	@Test
	public void verifyLogo() throws InterruptedException {
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
	}

	@Test
	public void getMyStoreTitle() throws InterruptedException {
		indexPage = new IndexPage();
		String Title = indexPage.storeTitle();
		Assert.assertEquals(Title, "My Store");
	}

}
