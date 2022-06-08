package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {

	public IndexPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Log in to your customer account']")
	WebElement signInBtn;

	@FindBy(xpath = "//img[@alt='My Store']")
	WebElement myStoreLogo;

	@FindBy(xpath = "//input[@id='search_query_top']")
	WebElement searchProductBox;

	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement searchButton;

	/////////////////////////////////////

	public LoginPage clickOnSignIn() {
		Action.click(driver, signInBtn);
		return new LoginPage();
	}

	public boolean validateLogo() {
		return Action.isDisplayed(driver, myStoreLogo);

	}

	public String name() {
		String myStoreTitle = driver.getTitle();
		return myStoreTitle;
	}

}
