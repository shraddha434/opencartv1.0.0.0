package testCases;

import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.Login;


public class TC002_LoginTest extends Baseclass {
	
	@Test
	public void loginmethod () throws InterruptedException{
		
		
HomePage hp=new HomePage(driver);
		
		logger.info("Test started...........");
		hp.clickMyaccount();
		logger.info("click on myaccount");
		hp.clicklogin();
	Login lg=new Login(driver);
	
	lg.addlogin(p.getProperty("mailid"), p.getProperty("password"));
	
	
	}

}
