/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Poste-19
 *
 */
public class AddressPage extends BaseClass {

	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;

	public ShippingPage clickOnCheckOut() {
		Action.click(getDriver(), proceedToCheckOutBtn);
		return new ShippingPage();
	}
	
}
