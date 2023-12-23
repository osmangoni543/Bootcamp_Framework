package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
	public WebDriver driver;
	
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//a[text()='HP LP3065']")
	private WebElement productLabel;
	
	public boolean getDisplayStatusOfProductLabel() {
		boolean displayStatus = productLabel.isDisplayed();
		return displayStatus;
	}
	
	@FindBy(xpath = "//a[text()='HP LP3065']")
	private WebElement productDetailsButton;
	
	public ProductDetailsPage clickOnProductDetailsButton() {
		productDetailsButton.click();
		return new ProductDetailsPage(driver);
	}
	
	
	

}
