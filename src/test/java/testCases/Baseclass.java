package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass {
	
	
public 	WebDriver driver;

public Logger logger;
public Properties p;

	
	@BeforeClass
	@Parameters({"browser","os"})
	public void  setup(String br,String os) throws IOException {
		
		//Loading properties file 
		
		

		FileReader file=new FileReader("./src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		
		
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities DC=new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows")) {
				
					DC.setPlatform(Platform.WIN11);
					
			}else if (os.equalsIgnoreCase("linux")) 
			{
				
				DC.setPlatform(Platform.LINUX);
				
				
			}
			else {
				System.out.println("no matching os");
			}
			
			
			
		
		
		switch(br.toLowerCase()) {
		case "chrome": DC.setBrowserName("chrome");break ;
		case "edge":  DC.setBrowserName("edge");break ;

		
		}
		driver=new RemoteWebDriver(new URL("http://192.168.1.39:4444"),DC);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) 
			
		{
		switch(br.toLowerCase()) {
		case "chrome": driver=new ChromeDriver();break ;
		case "edge": driver=new EdgeDriver();break ;

		
		}
		}
		

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.get(p.getProperty("app"));
		driver.manage().window().maximize();
		
		
	}
	
@AfterClass
	
	public void teardown() {
		driver.quit();
	}
	
	@SuppressWarnings("deprecation")
	public String randomstring() {
		String randomestring=RandomStringUtils.randomAlphabetic(6);
	
		
		return randomestring;
		
		
	}
	
	public String screenshot(String tname ) {
		
		 String timestamp = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());

	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String targetPath = System.getProperty("user.dir") + "\\screenshot\\" + tname + "_" + timestamp + ".png";
	        File targetFile = new File(targetPath);

	        try {
	            Files.createDirectories(targetFile.getParentFile().toPath()); // make sure folder exists
	            Files.copy(src.toPath(), targetFile.toPath());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return targetPath;
		
		
		
	}


}
