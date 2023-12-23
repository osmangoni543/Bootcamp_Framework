package com.qa.tutorialsninja.TestCases;




import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.tutorialsninja.Pages.LandingPage;
import com.qa.tutorialsninja.Pages.ShoppingCartPage;
import com.qa.tutorialsninja.TestBase.TestBase;

public class HomePageTest extends TestBase{
	public HomePageTest() throws Exception {
		super();
	}
	public WebDriver driver;
	public LandingPage landingPage;
	public ShoppingCartPage shoppingCartPage;

	@BeforeMethod
	public void setup() {
		driver = initializeChromeBrowserAndOpenApplication();
		landingPage = new LandingPage(driver);
		Assert.assertTrue(landingPage.getDisplayStatusOfWebsiteLogo());
	}

	@Test(priority=1)
	public void verifyHomePage() {
		shoppingCartPage = landingPage.clickOnShoppingCartButton();
		Assert.assertTrue(shoppingCartPage.retrieveShoppingCartLabel().contains(dataprop.getProperty("shoppingCartLabel")));	

	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}




