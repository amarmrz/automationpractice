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
public class AccountCreationPage extends BaseClass {

	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//h1[@class='page-heading']")
	WebElement formTitle;

	public boolean validateAccountCreatePage() {
		return Action.isDisplayed(getDriver(), formTitle);

	}

}
