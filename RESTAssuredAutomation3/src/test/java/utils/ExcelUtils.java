package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	//Step 1 : Add maven dependency for excel reading and writing
	//Step 2 : Create a folder and add excel file and create data in the file
	//Step 3 : Create a class and create functions to get row count
	//Step 4 : Create a function to get data from excel
	//Step 5 : Create a constructor to get excelPath and sheetName
	//Step 6 : Create a new class and call the excel functions
	
	
	
	
	
	public static void main(String[] args) {
		try {
			getRowCount();
			getCellData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	
	//Get the number of rows
	public static void getRowCount() throws IOException {
		
		try {
			
			//Finding Path of the excel file
			//System.getProperty("user.dir");
			String projDir = System.getProperty("user.dir");
			System.out.println(projDir);
					
		String excelPath = projDir+"/data/RestAssuredData.xlsx";
		System.out.println(excelPath);		
		XSSFWorkbook workbook = new XSSFWorkbook(excelPath);   // Excel Path
		XSSFSheet sheet = workbook.getSheet("Sheet1");         // getting sheet from excel path
		
		int rowCount = sheet.getPhysicalNumberOfRows();   // taking row count using sheet.getPhysicalNumberOfRows and storing it in integer
		System.out.println("No of Rows: "+rowCount);
		
		
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
			
		}
	}
	
	
	//Get Cell Data
	public static void getCellData() throws IOException {
		
		String projDir = System.getProperty("user.dir");
		
				
	String excelPath = projDir+"/data/RestAssuredData.xlsx";
		
	XSSFWorkbook workbook = new XSSFWorkbook(excelPath);   // Excel Path
	XSSFSheet sheet = workbook.getSheet("Sheet1"); 
	
//	sheet.getRow(1).getCell(0).getStringCellValue();
	
	String value = sheet.getRow(1).getCell(0).getStringCellValue();
	System.out.println("Cell Value: "+ value);
	
	double value2 = sheet.getRow(1).getCell(2).getNumericCellValue();
	System.out.println("Subject Id: "+ value2);
	
	DataFormatter formatter = new DataFormatter();
	
	Object value3 = formatter.formatCellValue(sheet.getRow(1).getCell(2));
	System.out.println("Cell Vaue: "+value3);
		 
	}
	
	
		
		

}
