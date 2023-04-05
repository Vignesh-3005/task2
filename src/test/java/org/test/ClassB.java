package org.test;
import org.testng.annotations.Test;

public class ClassB {

	@Test
	private void tc_1() {
		System.out.println("tc_1");
	}

	@Test(invocationCount=3)
	private void tc_2() {
		System.out.println("tc_2");
	}

	@Test
	private void tc_3() {
		System.out.println("tc_3");
	}

	@Test(enabled=false)
	private void tc_4() {
		System.out.println("tc_4");
	}

	
	
}
