package testCases;

import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.Login;
import utilities.DataProviderTest;

public class TC003_DDTLogin extends Baseclass


{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviderTest.class)
	public void loginmethod (String mail,String pswd) throws InterruptedException{
		
		
HomePage hp=new HomePage(driver);
		
		logger.info("Test started...........");
		hp.clickMyaccount();
		logger.info("click on myaccount");
		hp.clicklogin();
		
	Login lg=new Login(driver);
	System.out.println("Username value: " + mail);
	System.out.println("PSWD value: " + pswd);

	
	lg.addlogin(mail,pswd);
	
	hp.clickMyaccount();
	Thread.sleep(1000);
	hp.clicklogout();
	

}}
