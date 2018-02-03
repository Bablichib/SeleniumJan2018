package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		
		File src = new File(System.getProperty("user.dir")+ "/TestData/login.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("ERROR:Unable to load Excel File " + e.getMessage());
			}
		
		
		}
	public String getStringData(int sheetIndex,int row, int col) {
		String data =wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
		return data;
		
		
	}
	
	public String getStringData(String sheetName, int row, int colum) {

		String data = wb.getSheet(sheetName).getRow(row).getCell(colum).getStringCellValue();

		return data;
	}

	
	public int getNumericData(int sheetName,int row, int col) {
		int data =(int)wb.getSheetAt(sheetName).getRow(row).getCell(col).getNumericCellValue();
		return data;


}
	
	public double getNumericData1(String sheetName,int row, int col) {
		double data =wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
		return data;
}}