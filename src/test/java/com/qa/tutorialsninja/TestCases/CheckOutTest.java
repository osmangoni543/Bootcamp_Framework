package com.qa.tutorialsninja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tutorialsninja.Pages.AccountPage;
import com.qa.tutorialsninja.Pages.CheckoutPage;
import com.qa.tutorialsninja.Pages.LandingPage;
import com.qa.tutorialsninja.Pages.LoginPage;
import com.qa.tutorialsninja.Pages.ShoppingCartPage;
import com.qa.tutorialsninja.TestBase.TestBase;

public class CheckOutTest extends TestBase{
	

	public CheckOutTest() throws Exception {
		super();
	}
	public WebDriver driver;
	public LandingPage landingPage;
	public LoginPage loginPage;
	public ShoppingCartPage scPage;
	public CheckoutPage checkoutPage;
	public AccountPage accountPage;

	@BeforeMethod
	public void setup() {
		driver = initializeChromeBrowserAndOpenApplication();
		landingPage = new LandingPage(driver);
		loginPage = landingPage.navigateToLoginPage();
	}

	@Test(priority=1)
	public void verifyCheckout() {
		accountPage = loginPage.navigateToAccountPage(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		Assert.assertTrue(accountPage.statusOfEditYourAccountInfoButton());
		landingPage = accountPage.clickOnHomePageButton();
		landingPage.clickOnAddToCartButtonForMacbook();
		scPage = landingPage.clickOnShoppingCartButton();
		Assert.assertTrue(scPage.getDisplayStatusOfProductName());
		checkoutPage = scPage.clickOnCheckoutButton();
		checkoutPage.continueToCheckOut();
		Assert.assertFalse(checkoutPage.getStatusOfNoPaymentOptionsAvailableMessage()); //Can't continue because of no payment options to select from.
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}



}
