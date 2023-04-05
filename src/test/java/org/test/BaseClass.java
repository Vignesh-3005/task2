package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

 public static	WebDriver driver;

	public static void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void enterAppInUrl(String url) {
		getDriver();
		driver.get(url);
	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void elementSendKeys(WebElement element, String data) {

		element.sendKeys(data);
	}

	public void elementClick(WebElement element) {

		element.click();
	}

	public void elementclear(WebElement element) {

		element.clear();
	}

	public void threadSleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public String getApplnTitle() {

		String title = driver.getTitle();
		return title;
	}

	public WebElement findElementById(String attributevalue) {

		WebElement element = null;
		try {
			element = driver.findElement(By.id(attributevalue));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;

	}

	public WebElement findElementByName(String attributevalue) {

		WebElement element = driver.findElement(By.name(attributevalue));
		return element;

	}

	public WebElement findElementByClassName(String attributename) {

		WebElement element = driver.findElement(By.className(attributename));

		return element;
	}

	public WebElement findElementByXpath(String xpathExp) {

		WebElement element = driver.findElement(By.xpath(xpathExp));
		return element;

	}

	public String elementGetAttribute(WebElement element) {

		String attribute = element.getAttribute("value");
		return attribute;

	}

	public String elementGetAttribute(WebElement element, String attributeName) {

		String attribute = element.getAttribute(attributeName);
		return attribute;

	}

	public void SelectOptionByText(WebElement element, String text) {

		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	public void selectByValue(WebElement element, String attributevalue) {

		Select select = new Select(element);
		select.selectByValue(attributevalue);
	}

	public void SelectByOptionIntex(WebElement element, int a) {

		Select select = new Select(element);
		select.selectByIndex(a);
	}

	public void selectByIndex(WebElement element, int a) {

		new Select(element).selectByIndex(a);
	}

	public void ClickOkInAlert() {

		driver.switchTo().alert().accept();

	}

	public void clickCancelInAlert() {

		driver.switchTo().alert().dismiss();
	}

	public String GetText(WebElement element) {

		String text = element.getText();
		return text;
	}

	public void closeAllWindow() {

		driver.quit();

	}

	public static void closeCurrentWindow() {

		driver.close();
	}

	public String getCurrentUrl() {

		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public void SelectDropdownByOption(WebElement element, String data) {

		Select select = new Select(element);
		select.selectByVisibleText(data);
	}

	public void SelectOptionByAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);

	}

	public void SelectOptionByIndex(WebElement element, int a) {

		new Select(element).selectByIndex(a);
	}

	public void elementsendkeysJs(WebElement element, String text) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute'value','" + text + "')", element);
	}

	public void ClickByJs(WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}

	public void switchToChildWindow(String data) {

		driver.switchTo().window(data);
	}

	public void switchToFrame(int a) {

		driver.switchTo().frame(a);
	}

	public void switchToFrames(String data) {

		driver.switchTo().frame(data);
	}

	// get the cell value as string from excel

	public String readCellData(String SheetName, int rownum, int cellnum) throws IOException {

		String res = null;

		File file = new File("D:\\java\\task\\encapsulation\\syntax tax\\Mavenframwork\\excel\\adactinhotel.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("hotel");
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellTypeEnum();
		switch (type) {
		case STRING:
			res = cell.getStringCellValue();

			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				res = dateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long check = Math.round(numericCellValue);
				if (numericCellValue == check) {

					res = String.valueOf(numericCellValue);

				}
			}

			break;

		default:
			break;
		}
		return res;

	}

	// update data in cell

	public void updateCellData(String SheetName, int rownum, int cellnum, String olddata, String newdata)
			throws IOException {

		File file = new File("D:\\java\\task\\encapsulation\\syntax tax\\Mavenframwork\\excel\\adactinhotel.xlsx");

		FileInputStream stream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet("hotel");

		Row row = sheet.getRow(rownum);

		Cell cell = row.getCell(cellnum);

		String value = cell.getStringCellValue();
		if (value.equals(olddata)) {

			cell.setCellValue(newdata);

		}

		FileOutputStream out = new FileOutputStream(file);

		workbook.write(out);
	}

	public void writecellData(String SheetName, int rownum, int cellnum, String data) throws IOException {

		File file = new File("D:\\java\\task\\encapsulation\\syntax tax\\Mavenframwork\\excel\\adactinhotel.xlsx");

		FileInputStream stream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet(SheetName);

		Row row = sheet.createRow(rownum);

		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);

	}
	
	public static void screenshot(String fileName ) {

	try {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshotAs, new File("D:\\dd\\"+fileName+".png"));
	} catch (Exception e) {
		e.printStackTrace();
	
		
	}
	
	}	

}
