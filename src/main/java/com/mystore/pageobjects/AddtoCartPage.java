package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddtoCartPage extends BaseClass {

	public AddtoCartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(id="quantity_wanted")
	WebElement quantity;

	@FindBy(name="group_1")
	WebElement size;

	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addToCarteBtn;

	@FindBy(xpath = "// h2[normalize-space()='Product successfully added to your shopping cart']")
	WebElement addToCarteMessage;

	@FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
	WebElement proceedToCheckOutBtn;

	public void enterQuantity(String qty) {
		Action.type(quantity, qty);

	}

	public void selectSize(String size1) {
		Action.selectByVisibleText(size1, size);

	}

	public void clickOnAddToCarte() {
		Action.click(getDriver(), addToCarteBtn);
	}

	public boolean validateAddtoCarte() {
		return Action.isDisplayed(getDriver(), addToCarteMessage);
	}

	public OrderPage clickOnCheckOut() {
		Action.JSClick(getDriver(), proceedToCheckOutBtn);
		return new OrderPage();
	}
}
