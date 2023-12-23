package com.qa.tutorialsninja.TestBase;


import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.qa.tutorialsninja.Utilities.Util;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class TestBase {

	public WebDriver driver;
	public ChromeOptions options;
	public Properties prop;
	public FileInputStream ip;
	public Properties dataprop;

	public TestBase() throws Exception {
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\tutorialsninja\\config\\config.properties");
		prop.load(ip);

		dataprop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\qa\\tutorialsninja\\TestData\\testData.properties");
		dataprop.load(ip);
	}

	public WebDriver initializeChromeBrowserAndOpenApplication() {

		options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		options.addArguments("--incognito");
		options.addArguments("--start-maximized");
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation","disable-infobars"));
		this.driver = new ChromeDriver(options);

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGE_LOAD_TIME));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Util.SCRIPT_TIME));
		driver.get(prop.getProperty("url"));
		return driver;
	}

}
