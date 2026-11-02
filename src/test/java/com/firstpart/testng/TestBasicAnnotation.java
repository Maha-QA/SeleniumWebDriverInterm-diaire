package com.firstpart.testng;

import org.testng.annotations.Test;

public class TestBasicAnnotation {
	@Test
	public void testWithAnnotation()
	//TestNG considère cette méthode comme un test exécutable
	//elle sera exécutée automatiquement
	//elle apparaît dans les résultats de test
	//elle est prise en compte dans les rapports
	{
		System.out.println("This test is annotated");
	}
	
	public void testWithoutAnnotation()
	{
		System.out.println("This test is not annotated");
	}

}