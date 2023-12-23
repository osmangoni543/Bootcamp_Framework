package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationSuccessPage {
	
	public WebDriver driver;
	
	
	//String actualSuccessMessage = driver.findElement(By.cssSelector("div#content")).getText();
	
	@FindBy(css = "div#content")
	private WebElement registrationSuccessMessage;
	
	public String retrieveRestrationSuccessMessage() {
		String successMessage = registrationSuccessMessage.getText();
		return successMessage;
	}

	
	public RegistrationSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
