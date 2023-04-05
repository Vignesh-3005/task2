package org.test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClassA {

	@Test
	private void tc_1() {

		System.out.println("tc_1 @test");
	}

	@Test(priority=-150)
	private void tc_2() {
		System.out.println("tc_2 @priority=-150 suite");

	}
	@Test(priority=10)
	private void tc_5() {
		System.out.println("tc_5 @priority=10");
	}


	@Test
	private void tc_3() {
		System.out.println("tc_3 @BeforeClass");
	}
	
	@Test
	private void tc_4() {
		System.out.println("tc_4 @BeforeMethod");
	}

	@Test
	private void tc_6() {
		System.out.println("tc_6 @AfterClass");
	}

	@Test
	private void tc_7() {
		System.out.println("tc_7 @AfterMethod");
	}

	@Test
	private void tc_8() {
		System.out.println("tc_8 @@BeforeTest");
	}

	@Test
	private void tc_9() {
		System.out.println("tc_9 @@AfterTest");
	}

	
	
	
	
	
	
	
	
	
	
	

}
