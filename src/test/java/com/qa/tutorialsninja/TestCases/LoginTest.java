package com.qa.tutorialsninja.TestCases;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tutorialsninja.Pages.AccountPage;
import com.qa.tutorialsninja.Pages.LandingPage;
import com.qa.tutorialsninja.Pages.LoginPage;
import com.qa.tutorialsninja.TestBase.TestBase;

public class LoginTest extends TestBase {
	public LoginTest() throws Exception {
		super();
	}
	public WebDriver driver;
	public LandingPage landingPage;
	public LoginPage loginPage;
	public AccountPage accountPage;

	@BeforeMethod
	public void setup() {
		driver = initializeChromeBrowserAndOpenApplication();
		landingPage = new LandingPage(driver);
		loginPage = landingPage.navigateToLoginPage();
	}

	@Test(priority=1)
	public void verifyLoginWithValidCredentials() {
		accountPage = loginPage.navigateToAccountPage(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		Assert.assertTrue(accountPage.statusOfEditYourAccountInfoButton());	
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}




