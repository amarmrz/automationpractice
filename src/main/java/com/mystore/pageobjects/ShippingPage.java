package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {

	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='cgv']")
	WebElement checkTermsBtn;

	@FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;

	public void ClickOnCheckTerms() {
		Action.click(driver, checkTermsBtn);
	}

	public PaymentPage clickOnProceedToCheckOut() {
		Action.click(driver, proceedToCheckOutBtn);
		return new PaymentPage();
	}
}
