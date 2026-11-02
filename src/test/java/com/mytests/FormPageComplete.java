package com.mytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormPageComplete {
	static WebDriver driver;
	String FullNameXpath = "//input[@id='userName']";

	@BeforeClass()

	public void OpenBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");

	}

	@Test()
	public void send() {
		WebElement FullName;
		String FullNameXpath = "//input[@id='userName']";
		FullName = driver.findElement(By.xpath(FullNameXpath));
		FullName.sendKeys("Maha");
		WebElement Email;
		Email = driver.findElement(By.id("userEmail"));
		Email.sendKeys("Maha@test.com");
		WebElement CurrentAddress;
		CurrentAddress = driver.findElement(By.xpath("//div/textarea[@rows='5'][1]"));
		// ("//div[@id='currentAddress-wrapper']"))

		CurrentAddress.sendKeys("Etterbeek");
		WebElement PermanentAddress;
		PermanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
		PermanentAddress.sendKeys("belgium");
		WebElement ButtonSubmit;
		String buttonCss = "#submit";
		ButtonSubmit = driver.findElement(By.cssSelector(buttonCss));
		ButtonSubmit.click();
	}

	@Test(dependsOnMethods="send")

	public void assertFunction() {

		String nameResult = driver.findElement(By.xpath(FullNameXpath)).getAttribute("value");
		String emailResult = driver.findElement(By.id("userEmail")).getAttribute("value");
		Assert.assertEquals(nameResult, "Maha");
		Assert.assertEquals(emailResult, "Maha@test.com");
		
		Assert.assertTrue(nameResult.contains("Maha"));
		Assert.assertTrue(emailResult.contains("Maha@test.com"));
	}

	@AfterClass()

	public void closeBrowser() {
		driver.close();
	}

}