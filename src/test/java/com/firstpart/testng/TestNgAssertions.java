package com.firstpart.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgAssertions {
	static WebDriver driver;
	public static SoftAssert softAssert;
	

	@BeforeSuite
	public void SetUp() {
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	softAssert= new SoftAssert();
	}
	
	@Test (priority = 1)
	public void openBrowser () {

		    driver.navigate().to("https://demoqa.com");

		    String expectedTitle = "demosite";
		    String actualTitle = driver.getTitle();

		    SoftAssert softAssert = new SoftAssert();

		    softAssert.assertEquals(actualTitle, expectedTitle,
		            "Le titre est incorrect");

		    System.out.println(driver.getTitle());

		    softAssert.assertAll();
		}
	@Test
	public void testHardAssertFuctions() {
		
		    driver.navigate().to("https://www.browserstack.com");

		    String actualTitle = driver.getTitle();

		    String expectedTitle =
		        "Most Reliable App & Cross Browser Testing Platform | BrowserStack";

		    Assert.assertEquals(actualTitle, expectedTitle,
		            "Le titre de la page est incorrect");

		    boolean verifyTitle = actualTitle.equalsIgnoreCase(expectedTitle);

		    Assert.assertTrue(verifyTitle, "Message Incorrect");

		}
		
	}


