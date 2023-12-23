package com.qa.tutorialsninja.TestCases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tutorialsninja.Pages.LandingPage;
import com.qa.tutorialsninja.Pages.RegisterPage;
import com.qa.tutorialsninja.Pages.RegistrationSuccessPage;
import com.qa.tutorialsninja.TestBase.TestBase;
import com.qa.tutorialsninja.Utilities.Util;

public class RegisterTest extends TestBase{


	public RegisterTest() throws Exception {
		super();
	}
	public WebDriver driver;
	public LandingPage landingPage;
	public RegisterPage registerPage;
	RegistrationSuccessPage rsPage;

	@BeforeMethod
	public void setup() {
		driver = initializeChromeBrowserAndOpenApplication();
		landingPage = new LandingPage(driver);
		registerPage = landingPage.navigateToRegisterPage();
	}

	@Test(priority=1)
	public void verifyRegisterWithValidCredentials() {
		rsPage = registerPage.navigateToRegistrationSuccessPage(dataprop.getProperty("firstName"),
				                                                dataprop.getProperty("lastName"), 
				                                                Util.generateEmailWithDateTimeStamp(), 
				                                                dataprop.getProperty("telephone"), 
				                                                prop.getProperty("validPassword"));
		Assert.assertTrue(rsPage.retrieveRestrationSuccessMessage().contains(dataprop.getProperty("registrationSuccessMessage")));



	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}

