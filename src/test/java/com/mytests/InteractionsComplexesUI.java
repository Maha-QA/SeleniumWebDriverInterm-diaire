package com.mytests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractionsComplexesUI {
	static WebDriver driver;

	@BeforeClass()
	public void OpenBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/tool-tips");
	}

	@Test()
	public void hoverFuction() {
		// Localiser le boutton
		WebElement button;
		button = driver.findElement(By.id("toolTipButton"));
		Actions actions = new Actions(driver);
		actions.moveToElement(button).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement hover = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tooltip-inner")));

		String hoverXpath = "tooltip-inner";
		hover = driver.findElement(By.className(hoverXpath));
		System.out.println(hover.getText());
		String actualTitle = hover.getText();
		String expedtedTitle = "You hovered over the Button";
		Assert.assertEquals(actualTitle, expedtedTitle);

	}

	@AfterClass()
	public void CloseBroxser() {
		driver.close();
	}
}
