package com.jbk.Test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.TestBases.TestBase;
import com.jbk.Pages.UsersPage;

public class UsersPageTest extends TestBase {
	WebDriver driver;
	UsersPage up;

	@BeforeClass
	public void setUp() {
		driver = initialization();
		up = loadLoginPage().verifyValidLogin().nevigateUserPage(driver);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	

	@Test
	public void checkTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "JavaByKiran | User");
	}

	@Test
	public void checkCurrentURL() {
		String title = driver.getCurrentUrl();
		System.out.println(title);
		String exp = "file:///C:/Users/User/Downloads/Offline%20Website/Offline%20Website/pages/examples/users.html";
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
		String exp = "Users";
		Assert.assertEquals(label, exp);
	}

	@Test
	public void addUserButton() {
		driver.findElement(By.xpath("//button[text()='Add User']")).click();
		String url = driver.getTitle();
		System.out.println(url);
		String expUrl = "JavaByKiran | Add User";
		Assert.assertEquals(url, expUrl);
		driver.navigate().back();
		String url1 = driver.getTitle();
		System.out.println("Back to User Page with title...." + url1);
	}

	@Test
	public void checkHeading1() {
		String label = driver.findElement(By.xpath("//h3")).getText();
		System.out.println(label);
		String exp = "User List";
		Assert.assertEquals(label, exp);
	}

	@Test
	public void checkColumnNames() throws Exception {
		ArrayList<String> actualmenusList = new ArrayList<String>();
		List<WebElement> menus = driver.findElements(By.xpath("//tr//th"));
		for (WebElement menu : menus) {
			String courseName = menu.getText();
			actualmenusList.add(courseName);
		}
		Assert.assertEquals(actualmenusList, up.checkColumnNames());
	}

	@Test
	public void checkColumn() throws Exception {
		ArrayList<String> actualmenusList = new ArrayList<String>();
		List<WebElement> menus = driver.findElements(By.xpath("//tr/td[3]"));
		for (WebElement menu : menus) {
			String courseName = menu.getText();
			actualmenusList.add(courseName);
		}
		Assert.assertEquals(actualmenusList, up.checkColumn());		
	}

	@Test
	public void checkFooterLink() {
		driver.findElement(By.xpath("//a[text()='JavaByKiran']")).click();
		String url = driver.getTitle();
		System.out.println(url);
		String expUrl = "JavaByKiran | User";
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
