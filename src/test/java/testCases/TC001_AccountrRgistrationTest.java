package testCases;


import org.testng.Assert;

import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.Registarionpage;

public class TC001_AccountrRgistrationTest  extends Baseclass{
	

	
	
	
	@Test
	public void AccountRegistration() throws InterruptedException {
			
		HomePage hp=new HomePage(driver);
		
		logger.info("Test started...........");
		hp.clickMyaccount();
		logger.info("click on myaccount");
		hp.clickRegister();
		
		Thread.sleep(1000);
		
		Registarionpage rp=new Registarionpage(driver);
		
		rp.addPersonalDetail("Shraddha", "wagh", randomstring()+"@gmail.com", "9987768788");
		
		rp.addPassword("shraddha123", "shraddha123");
		rp.submit();
		
		
		String msg=rp.getconfirmationmsg();
		Assert.assertEquals(msg,"Your Account Has Been Created!");
				
	}
	

}
