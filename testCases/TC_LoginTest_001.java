package com.nopCommerceV1.testCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopCommerceV1.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);
		logger.info("URL is Opened..........");
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(5000);
		lp.setUserName(username);
		lp.setPassword(password);
		logger.info("Password provided..........");
		lp.clickLogin();
		Thread.sleep(5000);
		if(driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("Login Passed..........");
			
		}else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login failed...........");
			
			}
	}
	
	
}
