package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	public WebDriver driver;

	@FindBy(id = "input-firstname")
	private WebElement firstNameTextBox;
	
	public void enterFirstName(String firstNameText) {
		firstNameTextBox.sendKeys(firstNameText);
	}
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameTextBox;
	
	public void enterLastName(String lastNameText) {
		lastNameTextBox.sendKeys(lastNameText);
	}
	
	@FindBy(id = "input-email")
	private WebElement emailTextBox;
	
	public void enterEmail(String emailAddress) {
		emailTextBox.sendKeys(emailAddress);
	}
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneTextBox;
	
	public void enterTelephone(String telephoneNumber) {
		telephoneTextBox.sendKeys(telephoneNumber);
	}
	
	@FindBy(id = "input-password")
	private WebElement passwordTextBox;
	
	public void enterPassword(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordTextBox;
	
	public void enterPasswordAgain(String passwordText) {
		confirmPasswordTextBox.sendKeys(passwordText);
	}
	
	@FindBy(css = "input[name = agree]")
	private WebElement privacyPolicyCheckBox;
	
	public void checkPrivacyPolicy() {
		privacyPolicyCheckBox.click();
	}
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement registerButton;
	
	public RegistrationSuccessPage clickOnRegisterButton() {
		registerButton.click();
		return new RegistrationSuccessPage(driver);
	}
	
	public RegistrationSuccessPage navigateToRegistrationSuccessPage(String firstNameText,
			String lastNameText, String emailAddress, String telephoneNumber, String passwordText) {
		firstNameTextBox.sendKeys(firstNameText);
		lastNameTextBox.sendKeys(lastNameText);
		emailTextBox.sendKeys(emailAddress);
		telephoneTextBox.sendKeys(telephoneNumber);
		passwordTextBox.sendKeys(passwordText);
		confirmPasswordTextBox.sendKeys(passwordText);
		privacyPolicyCheckBox.click();
		registerButton.click();
		return new RegistrationSuccessPage(driver);	
	}

	
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
