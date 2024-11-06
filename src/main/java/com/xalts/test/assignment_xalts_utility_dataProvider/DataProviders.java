package com.xalts.test.assignment_xalts_utility_dataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class DataProviders {
	
		@DataProvider(name = "signUpData")
	    public Object[][] getSignUpData() throws IOException {
	        return getExcelData("Test/resources/TestData.xlsx", "SignUp");
	    }

	    @DataProvider(name = "signInData")
	    public Object[][] getSignInData() throws IOException {
	        return getExcelData("Test/resources/TestData.xlsx", "SignIn");
	    }

	    @DataProvider(name = "signOutData")
	    public Object[][] getSignOutData() throws IOException {
	        return getExcelData("Test/resources/TestData.xlsx", "SignOut");
	    }
	    
	    private Object[][] getExcelData(String filePath, String sheetName) throws IOException {
	        FileInputStream fis = new FileInputStream(filePath);
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        int rowCount = sheet.getPhysicalNumberOfRows();
	        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
	        
	        Object[][] data = new Object[rowCount - 1][colCount];
	        DataFormatter formatter = new DataFormatter();

	        for (int i = 1; i < rowCount; i++) {
	            Row row = sheet.getRow(i);
	            for (int j = 0; j < colCount; j++) {
	                data[i - 1][j] = formatter.formatCellValue(row.getCell(j));
	            }
	        }

	        workbook.close();
	        fis.close();
	        return data;
	    }
	}