/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.AddtoCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummary;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

/**
 * @author Amar
 *
 */
public class EndtoEndTest extends BaseClass {
	public IndexPage indexPage;
	public SearchResultPage searchResultPage;
	public AddtoCartPage addtocartpage;
	public OrderPage orderPage;
	public LoginPage loginPage;
	public AddressPage AddressPage;
	public ShippingPage shippingPage;
	public PaymentPage paymentpage;
	public OrderSummary OrderSummary;
	public OrderConfirmationPage OrderConfirmationPage;

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApp();

	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		driver.quit();

	}

	@Test
	public void endtoEndTest() throws InterruptedException {
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
		loginPage = orderPage.clickOnCheckOut();
		AddressPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage = AddressPage.clickOnCheckOut();
		shippingPage.ClickOnCheckTerms();
		paymentpage = shippingPage.clickOnProceedToCheckOut();
		OrderSummary = paymentpage.clickOnPaymentMethod();
		OrderConfirmationPage = OrderSummary.clickOnConfirmMyOrder();
		String ActualResult = OrderConfirmationPage.ValidateConfirmMessage();
		Assert.assertEquals(ActualResult, "Your order on My Store is complete.");
	}
}
