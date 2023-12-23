package com.qa.tutorialsninja.TestCases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tutorialsninja.Pages.LandingPage;
import com.qa.tutorialsninja.Pages.ShoppingCartPage;
import com.qa.tutorialsninja.TestBase.TestBase;

public class ShoppingCartTest extends TestBase{

	public ShoppingCartTest() throws Exception {
		super();
	}
	public WebDriver driver;
	public LandingPage landingPage;
	public ShoppingCartPage scPage;

	@BeforeMethod
	public void setup() {
		driver = initializeChromeBrowserAndOpenApplication();

	}

	@Test(priority=1)
	public void verifyShoppingCart() {
		landingPage = new LandingPage(driver);
		scPage = landingPage.addIphoneToShoppingCart();
		Assert.assertTrue(scPage.getDisplayStatusOfProductNameIphone());
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
