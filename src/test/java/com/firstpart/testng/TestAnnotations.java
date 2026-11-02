package com.firstpart.testng;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
public class TestAnnotations {
	@Test
	public void testCase1() {
		System.out.println("This is test Case 1");
	}
	@Test
	
	public void testCase2() {
		System.out.println("This is test Case 2");
	}
	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("This will execute before every Test Method");
	}
	
	@AfterMethod
	public void AfterMethod() {
		System.out.println("This will execute after every Test Method");
	}
	@BeforeClass
	public void BeforeClass() {
		System.out.println("This will execute before the Class");
	}
	@AfterClass
	public void AfterClass() {
		System.out.println("This will execute after the Class");
	}
	@BeforeTest
	public void BeforeTest() {
		System.out.println("This will execute before the first test");
	}
	@AfterTest
	public void AfterTest() {
		System.out.println("This will execute after the last test");
	}
	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("This will execute before the Test Suite");
	}
	@AfterSuite
	public void AfterSuite() {
		System.out.println("This will execute after the Test Suite");
	}
}
