package com.firstpart.testng;

import org.testng.annotations.Test;

public class TestNgPriorities {
 @Test(priority = 5)
 public void aTest() {
	 
	System.out.println("This is test a.");
 }
 
 @Test(priority = 2)
 public void bTest() {
	 
	System.out.println("This is test b.");
}
 @Test(priority = 3)
 public void cTest() {
	 
	System.out.println("This is test c.");
 }
 
 @Test(priority = 4)
 public void dTest() {
	 
	System.out.println("This is test d.");
}
 @Test(priority = 1)
 public void eTest() {
	 
	System.out.println("This is test e.");}
 }