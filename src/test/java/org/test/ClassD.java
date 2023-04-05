package org.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ClassD extends BaseClass {
	
	@Test(dataProvider="result")
	private void login(String username,String password ) {
		enterAppInUrl("https://www.facebook.com/");
		findElementById("email").sendKeys(username);
		findElementById("pass").sendKeys(password);
	}

	@DataProvider(name="result")
	private Object[][] datapro() {
		
		Object[][] data= new Object[3][2];
		data[0][0]="ashok";
		data[0][1]="ashok@95";
		
		data[1][0]="cv";
		data[1][1]="cv@123";
		
		data[2][0]="jv";
		data[2][1]="jv@123";
		
		
		return data;
		
	}
	
	
	
	
}
