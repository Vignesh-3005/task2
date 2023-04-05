package org.test;

import org.testng.annotations.Test;

public class GroupsProgm {
	
	@Test(groups="smoke")
	private void tc_1() {

		System.out.println("tc_1 @test");
	}

	@Test(groups="sanity")
	private void tc_2() {
		System.out.println("tc_2 @priority=-150 suite");

	}
	@Test(groups="reg")
	private void tc_5() {
		System.out.println("tc_5 @priority=10");
	}


	@Test(groups="smoke")
	private void tc_3() {
		System.out.println("tc_3 @BeforeClass");
	}
	
	@Test(groups="sanity")
	private void tc_4() {
		System.out.println("tc_4 @BeforeMethod");
	}

	@Test(groups="smoke")
	private void tc_6() {
		System.out.println("tc_6 @AfterClass");
	}

	

}
