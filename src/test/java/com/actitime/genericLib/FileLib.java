package com.actitime.genericLib;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @author hp
 *
 */
public class FileLib {
	
	public String readExcelData(String path, String sheetName, int rowNo, int cellNo) throws Throwable {
		
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		Workbook wb = WorkbookFactory.create(fis);
		String excelValue = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).toString();
		return excelValue;
				
	}
	
	public void	writeExcelData(String path, String sheetName, int rowNo, int cellNo, String data) throws Throwable {
		
		FileInputStream fis = new FileInputStream(path);
		Workbook wbf = WorkbookFactory.create(fis);
		wbf.getSheet(sheetName).getRow(rowNo).createCell(cellNo).setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(path);
		wbf.write(fos);
		
	}
	
	public int getRowCount(String path, String sheetName) throws Throwable {
		
		FileInputStream fis = new FileInputStream(path);
		Workbook wbf = WorkbookFactory.create(fis);
		int rowCount = wbf.getSheet(sheetName).getLastRowNum();
		return rowCount;
		
		

		
	}
	
	public String readProprertyData(String proPath, String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream(proPath);
		Properties prop = new Properties();
		prop.load(fis);
		String propValue = prop.getProperty(key, "Incorrect key");
		return propValue;
	}
	

}
