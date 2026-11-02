package com.testng.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TitleVerificationTest {
	static WebDriver driver;

	@BeforeSuite()
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

@Test()
public void verifyTitle()
{
	driver.navigate().to("https://demoqa.com");
	System.out.println("Le titre est : " +driver.getTitle());
	String expectedTitle = "demosite";
	String actualTitle = driver.getTitle();
	Assert.assertEquals(actualTitle, expectedTitle);
	Assert.assertTrue(actualTitle.contains("demosite"), "Le titre de la page est inorrecte");
}
/*@Test
	public void verifyTitle2()
	{
	String titreAttendu = driver.getTitle();
	String titreExpected = "demosite";
	Assert.assertEquals(titreAttendu, titreExpected);
	Assert.assertTrue(titreAttendu.contains("Tools"), "Le titre de la page est inorrecte");
	}
	*/

	@AfterSuite()
	public void closeBrowser()
	{
		driver.close();
	}
@Test()
public void verifyTitleWithSoftAssert() {
	driver.navigate().to("https://demoqa.com");
	String titreAttendu = driver.getTitle();
	String titreExpected = "demosite";
	SoftAssert softAssert = new SoftAssert();
	softAssert.assertEquals(titreAttendu, titreExpected, "Le titre de la page est incorrect");
	softAssert.assertTrue(titreAttendu.contains("demosite"),"Le titre ne contient pas demosite");
	softAssert.assertAll();
	
}

}
	
	

