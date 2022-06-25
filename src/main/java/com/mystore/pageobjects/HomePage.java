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
 * @author Amar
 *
 */
public class HomePage extends BaseClass {

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//span[normalize-space()='My wishlists']")
	WebElement wishList;

	@FindBy(xpath = "//span[normalize-space()='Order history and details']")
	WebElement orderHistory;

	public boolean validateMywishList() {
		return Action.isDisplayed(getDriver(), wishList);

	}

	public boolean validateOrderHistory() {
		return Action.isDisplayed(getDriver(), orderHistory);

	}

	public String validateHomePage() {
		String urlHomePage = getDriver().getCurrentUrl();
		return urlHomePage;

	}

}
