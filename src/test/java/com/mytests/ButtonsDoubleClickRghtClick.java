package com.mytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonsDoubleClickRghtClick {
	static WebDriver driver;

	@BeforeClass()

	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demoqa.com/buttons");
	}

	@Test()
	public void DoubleClickFuction() {
		WebElement doubleClick;
		doubleClick = driver.findElement(By.id("doubleClickBtn"));
		Actions actions = new Actions(driver);
		actions.doubleClick(doubleClick).build().perform();

		WebElement resultDoubleClick;
		resultDoubleClick = driver.findElement(By.id("doubleClickMessage"));

		String actualText = "You have done a double click";
		String expectedText = resultDoubleClick.getText();
		Assert.assertEquals(actualText, expectedText);

		WebElement rightClick;
		rightClick = driver.findElement(By.id("rightClickBtn"));
		actions.contextClick(rightClick).build().perform();
		
		WebElement resultRightClick;
		resultRightClick=driver.findElement(By.id("rightClickMessage"));
		String actualTextC = "You have done a right click";
		String expectedTextC = resultRightClick.getText();
		Assert.assertEquals(actualTextC, expectedTextC);
	}
}
