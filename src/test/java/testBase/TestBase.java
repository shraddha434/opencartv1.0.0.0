package testBase;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

	
public WebDriver driver;


	
	
	public TestBase(WebDriver driver){
		
		
		
		this.driver=driver;
		PageFactory.initElements(driver,this );
		
		
	}
	
	

}
