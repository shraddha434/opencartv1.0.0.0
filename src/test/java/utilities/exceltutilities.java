package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exceltutilities {
	
	
	public static FileInputStream fi ;
	public static FileOutputStream fo ;
	public static XSSFWorkbook WB;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static String path;
	
	public exceltutilities(String path) {
		this.path=path;
	}
	
	public int getrowcount(String xlsheet) throws IOException {
		
		try {
			fi=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WB=new XSSFWorkbook(fi);
		sheet=WB.getSheet(xlsheet);
		int rowcount=sheet.getLastRowNum();
		WB.close();
		fi.close();
		//return rowcount;
		 return rowcount + 1;
		
		}
	
	public int getcolcount(String xlsheet,int rowno ) throws IOException {
		
		fi=new FileInputStream(path);
		WB=new XSSFWorkbook(fi);
		sheet=WB.getSheet(xlsheet);
		int cellcount =sheet.getRow(rowno).getLastCellNum();
		WB.close();
		fi.close();
		return cellcount;
		
		}
	
	public String getcelldata(String xlsheet,int rowno,int col) throws IOException
	{
		fi=new FileInputStream(path);
		WB=new XSSFWorkbook(fi);
		sheet=WB.getSheet(xlsheet);
		row =sheet.getRow(rowno);
		cell=row.getCell(col);
		
		String data ;
		try {
	 data=cell.toString();
	 
		}
		catch(Exception e) {
			
			data="";
			
			
		}
		
		WB.close();
		fi.close();
	return data;
		
	}
	
	public static void setcelldata(String xlsheet,int rowno,int col ,String data ) throws IOException {
		
		
		fi=new FileInputStream(path);
		WB=new XSSFWorkbook(fi);
		sheet=WB.getSheet(xlsheet);
		row =sheet.getRow(rowno);
		cell=row.createCell(col);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		WB.write(fo);
		
		WB.close();
		fi.close();
		fo.close();
		
	}
	
	
	

}
