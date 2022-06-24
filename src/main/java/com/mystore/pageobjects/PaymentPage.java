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
public class PaymentPage extends BaseClass {

	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	WebElement payByBankWireBtn;

	@FindBy(xpath = "//a[@title='Pay by check.']")
	WebElement payByCheckBtn;
	
	public OrderSummary clickOnPaymentMethod() {
		Action.click(driver, payByBankWireBtn);
		return new OrderSummary();
	}
}
