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
public class OrderSummary extends BaseClass{

	public OrderSummary() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='I confirm my order']")
	WebElement confirmMyOrderBtn;
	
	public OrderConfirmationPage clickOnConfirmMyOrder() {
		Action.click(driver, confirmMyOrderBtn);
		return new OrderConfirmationPage();
	}
	
}
