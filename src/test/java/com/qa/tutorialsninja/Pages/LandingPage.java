package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	public WebDriver driver;
	
	@FindBy(linkText = "My Account")
	private WebElement MyAccountDropdown;
	
	public void clickOnMyAccount() {
		MyAccountDropdown.click();
	}
	
	@FindBy(linkText = "Login")
	private WebElement LoginOption;
	
	public LoginPage clickOnLoginOption() {
		LoginOption.click();
		return new LoginPage(driver);
	}
	
	public LoginPage navigateToLoginPage() {
		MyAccountDropdown.click();
		LoginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage() {
		MyAccountDropdown.click();
		RegisterOption.click();
		return new RegisterPage(driver);
	}
	
	@FindBy(linkText = "Register")
	private WebElement RegisterOption;
	
	public RegisterPage clickOnRegisterOption() {
		RegisterOption.click();
		return new RegisterPage(driver);
	}
	
	@FindBy(css = "div#logo")
	private WebElement websiteLogo;
	
	public boolean getDisplayStatusOfWebsiteLogo() {
		boolean logoStatus = websiteLogo.isDisplayed();
		return logoStatus;
	}
	
	@FindBy(linkText = "Shopping Cart")
	private WebElement shoppingCartButton;
	
	public ShoppingCartPage clickOnShoppingCartButton() {
		shoppingCartButton.click();
		return new ShoppingCartPage(driver);
	}
	
	@FindBy(css = "input.form-control.input-lg")
	private WebElement searchTextBox;
	
	public void enterProductName(String productName) {
		searchTextBox.sendKeys(productName);
	}
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	public SearchResultPage clickOnSearchButton() {
		searchButton.click();
		return new SearchResultPage(driver);
	}
	
	@FindBy(xpath = "//div[@id='content']/div[2]/div[1]/div/div[3]/button[1]/span")
	private WebElement macbookAddToCartButton;
	
	public void clickOnAddToCartButtonForMacbook() {
		macbookAddToCartButton.click();
	}
	
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[1]")
	private WebElement iphoneAddToCartButton;
	
	public void clickOnAddToCartButtonForIphone() {
		iphoneAddToCartButton.click();
	}
	
	public SearchResultPage navigateToSearchResultPage(String productName) {
		searchTextBox.sendKeys(productName);
		searchButton.click();
		return new SearchResultPage(driver);
	}
	
	public ShoppingCartPage addIphoneToShoppingCart() {
		iphoneAddToCartButton.click();
		shoppingCartButton.click();
		return new ShoppingCartPage(driver);
	}
	
	
	
	
	
	//Initialize all the objects
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}


