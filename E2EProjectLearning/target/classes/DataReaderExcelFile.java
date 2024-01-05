package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class DataReaderExcelFile extends Base {

	
	public static String username;
	
	public static String password;
	
	public static String url;
	
	public static String ActualURL;
	
	
	
	 public XSSFSheet GetSheet(String sheetName)  throws IOException  {
		 
		  
			 File ExcelFilepath = new File("F:\\New_folder\\QA_Softwares\\SeleniumTraining\\Work Space\\E2EProjectLearning\\ExcelSheet\\TestData.xlsx");
			 
							
			 FileInputStream fis = new FileInputStream(ExcelFilepath);

			 XSSFWorkbook workbook = new XSSFWorkbook(fis);
				
			 XSSFSheet ExcelsheetName = workbook.getSheet(sheetName);
			 
			 	 
			 return ExcelsheetName;
		 }
	     

	
	 public void LoginData(String sheetName) throws IOException {
	     	
		 XSSFSheet sheetLogin = GetSheet(sheetName);
		 
		 
		//  url = sheetLogin.getRow(1).getCell(1).getStringCellValue();

          username = sheetLogin.getRow(2).getCell(1).getStringCellValue();
          		
          		//row.getCell(0).getStringCellValue();

          password = sheetLogin.getRow(3).getCell(1).getStringCellValue();
          
          ActualURL = sheetLogin.getRow(4).getCell(1).getStringCellValue();
          
          
           
      
	}
	
	
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
