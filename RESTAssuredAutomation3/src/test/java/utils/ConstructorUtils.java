package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConstructorUtils {
	
	static HSSFWorkbook workbook;
	static HSSFSheet sheet;
	
	//Constructor(called by new keyword) declared as a class name)
		public ConstructorUtils(String excelPath, String sheetName) {
			
			
			try {
				InputStream file = new FileInputStream(excelPath);
				workbook = new HSSFWorkbook(new POIFSFileSystem(file));   // Excel Path
				sheet = workbook.getSheet(sheetName);
				
			}catch(Exception e) {
				System.out.print(e.getMessage());
				System.out.print(e.getCause());
				e.printStackTrace();
				
			}
			
		}
		
		
		//Get the number of rows
		public static void getRowCount() {
				
			int rowCount = sheet.getPhysicalNumberOfRows();  
			System.out.println("No of Rows: "+rowCount);
			
		}
		
		
		
		
		//Get Cell Data
		public static void getCellData(int rowNo, int columnNo) {
		
			DataFormatter formatter = new DataFormatter();
			
			Object value3 = formatter.formatCellValue(sheet.getRow(rowNo).getCell(columnNo));
			System.out.println("Cell Vaue: "+value3);
		
			 
		}
		

}
