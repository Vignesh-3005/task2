package org.test;

import org.testng.annotations.Test;

public class ClassE extends BaseClass{
	
	@Test
	private void searchHotel() {
		enterAppInUrl("https://www.facebook.com/");
		findElementById("email").sendKeys("aaaa");
		findElementById("pass").sendKeys("bbbb");
	
		
	}
	
	
	
	
	

}
