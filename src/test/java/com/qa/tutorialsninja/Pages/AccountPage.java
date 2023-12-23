package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver;
	
	
	@FindBy(xpath = "//a[text()='Edit your account information']")
	private WebElement editAccountInfoLink;
	
	public boolean statusOfEditYourAccountInfoButton() {
		boolean displayStatus = editAccountInfoLink.isDisplayed();
		return displayStatus;
	}
	
	
	@FindBy(linkText = "Qafox.com")
	private WebElement homepageButton;
	
	public LandingPage clickOnHomePageButton() {
		homepageButton.click();
		return new LandingPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
