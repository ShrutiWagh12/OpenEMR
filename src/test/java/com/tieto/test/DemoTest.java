package com.tieto.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoTest {
	
	public void readProperties() throws IOException {
		FileInputStream file = new FileInputStream("testdata/data.properties");
		Properties prop = new Properties();
		prop.load(file);
		
		String baseUrl = prop.getProperty("url");
		System.out.println(baseUrl);
	}
	
//	@Test
//	public void excel() throws IOException {
//		FileInputStream file = new FileInputStream("testdata/OpenEMRData.xlsx");
//		XSSFWorkbook book = new XSSFWorkbook(file);
//		XSSFSheet sheet = book.getSheet("validCredentialData");
//		
//		int rowCount = sheet.getPhysicalNumberOfRows();
//		System.out.println(rowCount);
//		XSSFRow rowCheck = sheet.getRow(0);
//		
//		int cellCount = rowCheck.getPhysicalNumberOfCells();
//		System.out.println(cellCount);
//		
//		DataFormatter format = new DataFormatter();
//		Object[][] dataArray  = new Object[rowCount-1][cellCount];
//		
//		for(int r=1; r<rowCount; r++) {
//			
//			XSSFRow row = sheet.getRow(r);
//			for (int c=0; c<cellCount; c++) {
//			XSSFCell cell = row.getCell(c);
//			String cellValue = format.formatCellValue(cell);
//			dataArray[r-1][c] = cellValue;
//			}
//		}
//		book.close();
//		file.close();
//	}
	
//	@DataProvider
//	public Object[][] invalidData()
//	{
//		Object[][] main  = new Object[3][4];
//		//Object[i][j]
//		//i-> number of test case
//		//j-> number of parameter
//		
//		main[0][0] = "john";
//		main[0][1] = "john123";
//		main[0][2] = "English (Indian)";
//		main[0][3] = "Invalid username or password";
//		
//		main[1][0] = "peter";
//		main[1][1] = "peter123";
//		main[1][2] = "Armenian";
//		main[1][3] = "Invalid username or password";
//		
//		main[2][0] = "paul";
//		main[2][1] = "paul123";
//		main[2][2] = "Dutch";
//		main[2][3] = "Invalid username or password";
//		
//		return main;
//	}
//	
//	@Test(dataProvider="invalidData")
//	public void fillFormTest(String username, String password, String dropdown, String invalidMessage) {
//		System.out.println(username+password+dropdown+invalidMessage);
//	}
	
	

}
