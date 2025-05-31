package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderTest {

  @DataProvider(name="LoginData")
  public static  String [][] getDataTest() throws IOException {
	  
	//  \src\test\DDTLOGIN.xlsx
	  String path="C:\\SELENIUM\\opencartv1.0.0\\src\\test\\DDTLOGIN.xlsx";
	  exceltutilities Excel=new exceltutilities(path);
	  
	  int rowcount=Excel.getrowcount("Sheet1" );
	  
	  int colcount=Excel.getcolcount("Sheet1",1 );
	  
	  System.out.println("roe" +Excel.getrowcount("Sheet1" ));
	  System.out.println(Excel.getcolcount("Sheet1", 1 ));

	  
	  String loginadata[][]=new String [rowcount][colcount];
	  for(int i=1;i<rowcount;i++) {
		  for (int j=0;j<colcount;j++) {
			  
			  
			  loginadata[i-1][j]=Excel.getcelldata("Sheet1", i, j);
			  
		  }
	  
	  }
	return loginadata;
	
    
  }
}
