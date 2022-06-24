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
public class OrderPage extends BaseClass {

	public OrderPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@id='product_price_1_1_0']//span[@class='price'][normalize-space()='$16.51']")
	WebElement unitPrice;

	@FindBy(xpath = "//span[@id='total_price']")
	WebElement totalPrice;

	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckout;

	public double getUnitPrice(String qty) {
		String unitPrice1 = unitPrice.getText();
		String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice / 100;
	}

	public double getTotalPrice(String qty) {
		String totalPrice1 = totalPrice.getText();
		String total = totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice = Double.parseDouble(total);
		return finalTotalPrice / 100;
	}

	public LoginPage clickOnCheckOut() {
		Action.click(driver, proceedToCheckout);
		return new LoginPage();
	}

}
