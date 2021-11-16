package com.jbk.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBases.TestBase;
import com.jbk.Pages.UsefulLinksPage;

public class UsefulLinksPageTest extends TestBase{
	WebDriver driver;

	 UsefulLinksPage ulp=null;
	@BeforeMethod
	public void setUp() {
		driver=initialization();
		ulp = loadLoginPage().verifyValidLogin().nevigateUsefulLinksPage(driver);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void goBtn1Click() {
	Assert.assertTrue(ulp.goBtn1Click());
	}
	@Test
	public void goBtn2Click() {
	Assert.assertTrue(ulp.goBtn2Click());
	}
	@Test
	public void goBtn3Click() {
	Assert.assertTrue(ulp.goBtn3Click());
	}
	@Test
	public void goBtn4Click() {
	Assert.assertTrue(ulp.goBtn4Click());
	}
	@Test
	public void goBtn5Click() {
	Assert.assertTrue(ulp.goBtn5Click());
	}
	@Test
	public void goBtn6Click() {
	Assert.assertTrue(ulp.goBtn5Click());
	}
}
