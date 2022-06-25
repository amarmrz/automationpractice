package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {

	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//a[@title='Log in to your customer account']")
	WebElement signInBtn;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement myStoreLogo;

	@FindBy(xpath = "//input[@id='search_query_top']")
	WebElement searchProductBox;

	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement searchButton;

	/////////////////////////////////////

	public LoginPage clickOnSignIn() {
		Action.click(getDriver(), signInBtn);
		return new LoginPage();
	}

	public boolean validateLogo() {
		return Action.isDisplayed(getDriver(), myStoreLogo);

	}

	public String storeTitle() {
		String myStoreTitle = getDriver().getTitle();
		return myStoreTitle;
	}

	public SearchResultPage searchProduct(String productName) {
		Action.type(searchProductBox, productName);
		Action.click(getDriver(), searchButton);
		return new SearchResultPage();
	}
}
