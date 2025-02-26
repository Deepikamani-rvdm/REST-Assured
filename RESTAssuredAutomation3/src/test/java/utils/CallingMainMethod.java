package utils;

import java.io.IOException;

public class CallingMainMethod {
	
	public static void main(String[] arg){
		
		
		
		String projDir = System.getProperty("user.dir");
		
		String excelPath =projDir+"/data/RestAssuredData.xls";
		String sheetName = "Sheet1";
		
		ConstructorUtils excel = new ConstructorUtils(excelPath, sheetName);
		
		excel.getRowCount();
		excel.getCellData(1,2);
		excel.getCellData(2,1);
		
	}

}
