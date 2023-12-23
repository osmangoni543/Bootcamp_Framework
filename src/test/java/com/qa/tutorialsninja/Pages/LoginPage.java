package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	public WebDriver driver;
	
	@FindBy(id = "input-email")
	private WebElement emailTextbox;
	
	@FindBy(id = "input-password")
	private WebElement passwordTextbox;
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement loginButton;
	
	public void enterEmail(String emailText) {
		emailTextbox.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText) {
		passwordTextbox.sendKeys(passwordText);
	}
	
	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	}
	
	public AccountPage navigateToAccountPage(String emailText, String passwordText) {
		emailTextbox.sendKeys(emailText);
		passwordTextbox.sendKeys(passwordText);
		loginButton.click();
		return new AccountPage(driver);
		
	}
	
	
	
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
