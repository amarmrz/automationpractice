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
public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailAddressField;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement passwordField;

	@FindBy(xpath = "//span[normalize-space()='Sign in']")
	WebElement SignInButton;

	@FindBy(xpath = "//input[@id='email_create']")
	WebElement emailNewAccountField;

	@FindBy(xpath = "//span[normalize-space()='Create an account']")
	WebElement emailNewAccountButton;

	public HomePage login(String userName, String password) {
		Action.type(emailAddressField, userName);
		Action.type(passwordField, password);
		Action.click(driver, SignInButton);
		return new HomePage();
	}
	
	public AddressPage login1(String userName, String password) {
		Action.type(emailAddressField, userName);
		Action.type(passwordField, password);
		Action.click(driver, SignInButton);
		return new AddressPage();
	}
	

	public AccountCreationPage creatNewAccount(String email) {
		Action.type(emailNewAccountField, email);
		Action.click(driver, emailNewAccountButton);
		return new AccountCreationPage();
	}
}
