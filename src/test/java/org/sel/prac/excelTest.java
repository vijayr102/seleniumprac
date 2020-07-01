package org.sel.prac;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import org.testng.annotations.AfterClass;

public class excelTest {

	private WebDriver driver;

	@Test(dataProvider = "dp")
	public void f(String Username, String Password) throws InterruptedException {
		driver.get("https://qasit.emaplan.com/fidelity/SignIn?fidelity");
		driver.findElement(By.id("Username")).sendKeys(Username);
		driver.findElement(By.id("Password")).sendKeys(Password);
		driver.findElement(By.xpath("//button[.='Sign In']")).click();
		Thread.sleep(3000);

	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void afterMethod() {
		if (driver != null) {
			driver.quit();
		}
	}

	@DataProvider
	public Object[][] dp() throws IOException {
		String FILE_NAME = "C:\\Users\\vkannan\\eclipse-workspace1\\selenium-java\\src\\test\\java\\org\\sel\\prac\\MyFirstExcel.xlsx";
		FileInputStream file = new FileInputStream(new File(FILE_NAME)); 

		// Create Workbook instance holding reference to .xlsx file 
		XSSFWorkbook workbook = new XSSFWorkbook(file); 

		// Get first/desired sheet from the workbook 
		XSSFSheet sheet = workbook.getSheetAt(0); 

		int rownum = sheet.getLastRowNum();

		int colnum  = sheet.getRow(0).getLastCellNum();

		Object data[][] = new Object[rownum+1][colnum];

		Iterator<Row> rowIterator = sheet.iterator(); 
		int i=0;
		while (rowIterator.hasNext()) { 
			Row row = rowIterator.next(); 
			// For each row, iterate through all the columns 
			Iterator<Cell> cellIterator = row.cellIterator(); 
			int j=0;
			while (cellIterator.hasNext()) { 
				Cell cell = cellIterator.next(); 

				data[i][j]=cell.getStringCellValue();
				j++;
				// Check the cell type and format accordingly 
			} 
			i++;
		} 
		workbook.close();
		file.close(); 
		return data;
	}

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
	}

	@AfterClass
	public void afterClass() {
	}

}
