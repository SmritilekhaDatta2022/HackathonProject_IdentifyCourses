/*
 * Author : Group 1
 * 			Smritilekha Datta (Emp.Id : 2063369)
 * 			Praveen J (Emp.Id : 2063438)
 * 			George Franklin P (Emp.Id : 2063339)
 * 			Dona Mariya Joseph (Emp.Id : 2063490)
 * 			Anjali Kumari Mishra (Emp.Id : 2063519)
 * 
 * Date : 04th January 2022
 * 
 * Description : This class is to implement Apache POI from an Excel file.
 * 				  
 * Note : Methods can be reused. Usage of relative path has been followed.
 */

package org.coursera;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	/*****************
	 * Implementing POI from IdentifyCoursesInputData Excel file
	 *****************/
	public static String[] readExcelData(String sheetname) throws Exception {

		FileInputStream fis = new FileInputStream("src\\test\\resources\\IdentifyCoursesInputData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		String[] input = new String[sheet.getRow(0).getLastCellNum()];
		DataFormatter formatter = new DataFormatter();
		int i = 0;
		for (Row row : sheet) {
			for (Cell cell : row) {
				input[i] = formatter.formatCellValue(cell);
				i++;
			}
		}
		workbook.close();
		return input;
	}
}
