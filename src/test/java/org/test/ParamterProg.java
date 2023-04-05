package org.test;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamterProg extends BaseClass {
	
	@Parameters({"ash","cv"})
	@Test
	private void login(@Optional("admin") String username,@Optional("pass") String password) {
		enterAppInUrl("https://www.facebook.com/");
		findElementById("email").sendKeys(username);
		findElementById("pass").sendKeys(password);
		
		
	}
	
	
	
	
}
