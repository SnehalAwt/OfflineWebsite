package com.jbk.Test;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBases.TestBase;
import com.jbk.Pages.DashboardPage;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class DashboardPageTest extends TestBase{
	DashboardPage dp=null;
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver=initialization();
		dp = loadLoginPage().verifyValidLogin();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void checkTitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "JavaByKiran | Dashboard");
	}
	@Test	public void checkCurrentURL() {
		String title = driver.getCurrentUrl();
		System.out.println(title);
		String exp = "file:///C:/Users/User/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html";
		Assert.assertEquals(title, exp);
	}

	@Test
	public void checkLabel() {
		String label = driver.findElement(By.xpath("//b[text()='Java By Kiran']")).getText();
		System.out.println(label);
		String exp = "Java By Kiran";
		Assert.assertEquals(label, exp);
	}

	@Test
	public void checkLabel1() {
		String label = driver.findElement(By.xpath("//h1")).getText();
		System.out.println(label);
		String exp = "Dashboard Courses Offered";
		Assert.assertEquals(label, exp);
	}

	@Test
	public void checkLink() {
		String label = driver.findElement(By.linkText("Home")).getText();
		System.out.println(label);
		String exp = "Home";
		Assert.assertEquals(label, exp);
	}

	@Test
	public void checkCourseList() throws Exception {
		List<WebElement> courses = driver.findElements(By.xpath("//h3"));
		ArrayList<String> actualCoursesList = new ArrayList<String>();
		for (WebElement course : courses) {
			String courseName = course.getText();
			actualCoursesList.add(courseName);
		}
		FileInputStream fis=new FileInputStream("b.xls");
		Workbook w=Workbook.getWorkbook(fis);
		Sheet s=w.getSheet(0);
		int rows=s.getRows();
		int column=s.getColumns();
		System.out.println("rows>> "+rows);
		System.out.println("column>> "+column);
		ArrayList<String> expCoursesList = new ArrayList<String>();
		
		for(int i=0;i<rows;i++){
			for(int j=0;j<column;j++){
		Cell c=s.getCell(j, i);//col,rows
		String val=c.getContents();
		expCoursesList.add(val);
		}
			}
		System.out.println(actualCoursesList);
		
		System.out.println(expCoursesList);
		Assert.assertEquals(actualCoursesList, expCoursesList);
	}

	@Test
	public void checkCourseDetails() throws Exception {
		List<WebElement> courses = driver.findElements(By.xpath("//h3//following-sibling::p"));
		ArrayList<String> actualCoursesList = new ArrayList<String>();
		for (WebElement course : courses) {
			String courseName = course.getText();
			actualCoursesList.add(courseName);
		}
		FileInputStream fis=new FileInputStream("a.xls");
		Workbook w=Workbook.getWorkbook(fis);
		Sheet s=w.getSheet(0);
		int rows=s.getRows();
		int column=s.getColumns();
		System.out.println("rows>> "+rows);
		System.out.println("column>> "+column);
		ArrayList<String> expCoursesList = new ArrayList<String>();
		
		for(int i=0;i<rows;i++){
			for(int j=0;j<column;j++){
		Cell c=s.getCell(j, i);//col,rows
		String val=c.getContents();
		expCoursesList.add(val);
		}
			}
	
		System.out.println(actualCoursesList);
		System.out.println(expCoursesList);
		Assert.assertEquals(actualCoursesList, expCoursesList);
	}

	@Test
	public void checkCourseLink() {
		List<WebElement> courses = driver.findElements(By.xpath("//a[text()='More info ']"));
		ArrayList<String> actualCoursesList = new ArrayList<String>();
		for (WebElement course : courses) {
			String courseName = course.getText();
			actualCoursesList.add(courseName);
		}
		System.out.println(actualCoursesList);
		ArrayList<String> expCoursesList = new ArrayList<String>();
		for (int i = 1; i <= 4; i++) {
			expCoursesList.add("More info");
			
		}

		System.out.println(expCoursesList.size());
		
		Assert.assertEquals(actualCoursesList, expCoursesList);
	}
	
	@Test
	public void checkFooterLink() throws Exception {
		driver.findElement(By.xpath("//a[text()='JavaByKiran']")).click();
		Thread.sleep(5000);
		String url = driver.getTitle();
		System.out.println(url);
		String expUrl = "JavaByKiran | Dashboard";	
	Assert.assertEquals(url, expUrl);
	}
	@Test
	public void checkSideBarMenuLinks() throws Exception {
		List<WebElement> menus = driver.findElements(By.xpath("//ul[@class='sidebar-menu']//child::li//span"));
		ArrayList<String> actualmenusList = new ArrayList<String>();
		for (WebElement menu : menus) {
			String courseName = menu.getText();
			actualmenusList.add(courseName);
		}
		System.out.println(actualmenusList);
		FileInputStream fis=new FileInputStream("c.xls");
		Workbook w=Workbook.getWorkbook(fis);
		Sheet s=w.getSheet(0);
		int rows=s.getRows();
		int column=s.getColumns();
		System.out.println("rows>> "+rows);
		System.out.println("column>> "+column);
		ArrayList<String> expMenusList = new ArrayList<String>();
		
		for(int i=0;i<rows;i++){
			for(int j=0;j<column;j++){
		Cell c=s.getCell(j, i);//col,rows
		String val=c.getContents();
		expMenusList.add(val);
		}
			}
	
		   System.out.println(expMenusList);
		  Assert.assertEquals(actualmenusList, expMenusList); 
	}
	
	
	  @Test public void checkUsersLinkMenu() {
	  driver.findElement(By.xpath("//span[text()='Users']")).click(); String url =
	  driver.getTitle(); String expUrl = "JavaByKiran | User";
	  Assert.assertEquals(url, expUrl); }
	 
	@Test
	public void checkOperatorsLinkMenu() {
		driver.findElement(By.xpath("//span[text()='Operators']")).click();
		String url = driver.getTitle();
		String expUrl = "JavaByKiran | Operators";
		Assert.assertEquals(url, expUrl);
	}
	@Test
	public void checkUsefulLinksMenu() {
		driver.findElement(By.xpath("//span[text()='     Useful Links']")).click();
		String url = driver.getTitle();
		String expUrl = "JavaByKiran | Useful Links";
		Assert.assertEquals(url, expUrl);
	}
	@Test
	public void checkDownloadsLinkMenu() {
		driver.findElement(By.xpath("//span[text()='Downloads']")).click();
		String url = driver.getTitle();
		String expUrl = "JavaByKiran | Downloads";
		Assert.assertEquals(url, expUrl);
	}
	@Test
	public void checkLogoutLink() {
		driver.findElement(By.xpath("//a[text()='LOGOUT']")).click();
		String url = driver.getTitle();
		String expUrl = "JavaByKiran | Log in";
		Assert.assertEquals(url, expUrl);
	}

}
