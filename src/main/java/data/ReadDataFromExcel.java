package data;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.HashMap;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class ReadDataFromExcel 
{
	@DataProvider(name="AmazonLogins")
	public static Object[][] readExcelData() throws IOException
	{
		FileInputStream fi = new FileInputStream("./TestDataFiles/Testdata.xlsx");
		try (XSSFWorkbook book = new XSSFWorkbook(fi)) {
			XSSFSheet sheet = book.getSheetAt(0);
			int totalRows = sheet.getLastRowNum();
			Object[][] data = new Object[totalRows][1];
			HashMap<String, String> hm = null;	
			for(int i=1; i<=totalRows; i++)
			{
				hm = new HashMap<String, String>();
				String email = sheet.getRow(i).getCell(0).toString();
				String pwd = sheet.getRow(i).getCell(1).toString();
				hm.put("EmailId", email);
				hm.put("Password", pwd);
				data[i-1][0] = hm;
			}	
			return data;
		}
	}
}
