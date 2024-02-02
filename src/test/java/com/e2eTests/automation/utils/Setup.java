package com.e2eTests.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Setup {
	
private static WebDriver driver;
	
	/**
	 * This method is used to open browser. This method is called before the
	 * invocation of each test method in the given class. In this method we need to
	 * pass browser name which will invoke the respective driver.
	 * 
	 * @Before Methods annotated with @Before will execute before every scenario.
	 */
	@Before
	public void setWebDriver() {

		String browser = System.getProperty("browser");
		if (browser == null) {
			browser = "chrome";
		}

		switch (browser) {

		case "chrome":

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;

		case "firefox":
			
			driver = new FirefoxDriver();
			break;

		default:
			throw new IllegalArgumentException("Browser \"" + browser + "\" is not supported.");

		}
	}

	/* GETTER */
	public static WebDriver getDriver() {
		return driver;
	}
	
	
	@After
	/*
	 * Embed a screenshot in test report if is test is marked as failed
	  */
	
	
	public void embedScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				//scenario.write("current page url is " +driver.getCurrentUrl() );
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", scenario.getName());
			}catch(WebDriverException somPlateformDontSupportScreenshots) {
				System.err.println(somPlateformDontSupportScreenshots.getMessage());
			}
		}
		
		//driver.quit();
		 
		 
		 
	}
	

}
