package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {

	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//strong[normalize-space()='Your order on My Store is complete.']")
	WebElement confirmMessage;
	
	public String ValidateConfirmMessage() {
		String ConfirmMessage=confirmMessage.getText();
		return ConfirmMessage;
	}
}
