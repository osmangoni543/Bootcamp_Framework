package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement continueButton;
	
	public void clickOnContinueButton() {
		continueButton.click();
	}	
	
	@FindBy(xpath = "//input[@name = 'agree']")
	private WebElement termsAndConditionCheckBox;
	
	public void clickOnTermsAndConditionCheckBox() {
		termsAndConditionCheckBox.click();
	}
	
	public void continueToCheckOut() {
		continueButton.click();
		termsAndConditionCheckBox.click();
	}
	
	@FindBy(linkText = "contact us")
	private WebElement noPaymentOptionsAvailableMessage;
	
	public boolean getStatusOfNoPaymentOptionsAvailableMessage() {
		boolean status = noPaymentOptionsAvailableMessage.isDisplayed();
		return status;
	}

}
