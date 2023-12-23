package com.qa.tutorialsninja.TestCases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tutorialsninja.Pages.LandingPage;
import com.qa.tutorialsninja.Pages.ProductDetailsPage;
import com.qa.tutorialsninja.Pages.SearchResultPage;
import com.qa.tutorialsninja.TestBase.TestBase;

public class SearchProductTest extends TestBase{


	public SearchProductTest() throws Exception {
		super();
	}
	public WebDriver driver;
	public LandingPage landingPage;
	public ProductDetailsPage pdPage;
	public SearchResultPage searchResultPage;

	@BeforeMethod
	public void setup() {
		driver = initializeChromeBrowserAndOpenApplication();

	}

	@Test(priority=1)
	public void verifySearchWithValidProductsAndVerifyProductDetails() {
		landingPage = new LandingPage(driver);
		searchResultPage = landingPage.navigateToSearchResultPage(dataprop.getProperty("validProduct"));
		Assert.assertTrue(searchResultPage.getDisplayStatusOfProductLabel());
		pdPage = searchResultPage.clickOnProductDetailsButton();
		Assert.assertTrue(pdPage.getProductDetails().contains(dataprop.getProperty("productDetail")));
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}





