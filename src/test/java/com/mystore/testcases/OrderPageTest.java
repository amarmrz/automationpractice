package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddtoCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	public IndexPage indexPage;
	public SearchResultPage searchResultPage;
	public AddtoCartPage addtocartpage;
	public OrderPage orderPage;

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApp();

	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		driver.quit();

	}

	@Test
	public void verifyTotlaPrice() throws InterruptedException {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		Thread.sleep(3000);
		addtocartpage = searchResultPage.clickOnProduct();
		Thread.sleep(3000);
		addtocartpage.enterQuantity("2");
		addtocartpage.selectSize("M");
		addtocartpage.clickOnAddToCarte();
		Thread.sleep(3000);
		orderPage = addtocartpage.clickOnCheckOut();
		double unitPrice = orderPage.getUnitPrice();
		double totalPrice = orderPage.getTotalPrice();
		double totalExpectedPrice = (unitPrice * 2) + 2;
		Assert.assertEquals(totalExpectedPrice, totalPrice);

	}
}
