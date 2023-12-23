package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	public WebDriver driver;
	
	
	@FindBy(css = "div#content")
	private WebElement shoppingCartLabel;
	
	public String retrieveShoppingCartLabel() {
		String label = shoppingCartLabel.getText();
		return label;
	}
	
	
	@FindBy(linkText = "MacBook")
	private WebElement productName;
	
	public boolean getDisplayStatusOfProductName() {
		boolean pN = productName.isDisplayed();
		return pN;
	}
	
	
	@FindBy(linkText = "iPhone")
	private WebElement productNameIphone;
	
	public boolean getDisplayStatusOfProductNameIphone() {
		boolean pN = productNameIphone.isDisplayed();
		return pN;
	}
	
	
	@FindBy(linkText = "Checkout")
	private WebElement checkoutButton;
	
	public CheckoutPage clickOnCheckoutButton() {
		checkoutButton.click();
		return new CheckoutPage(driver);
	}	
	
	
	
	
	
	
	
	

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
