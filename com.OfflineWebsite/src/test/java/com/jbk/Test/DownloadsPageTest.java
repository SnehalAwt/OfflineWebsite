package com.jbk.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBases.TestBase;
import com.jbk.Pages.DownloadsPage;

public class DownloadsPageTest extends TestBase{
	WebDriver driver;
	DownloadsPage dlp=null;
	@BeforeMethod
	public void setUp() {
		driver = initialization();
		dlp = loadLoginPage().verifyValidLogin().nevigateDownloadsPage(driver);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void verifyTitle() {
		String title=dlp.validateLoginPageTitle();
		Assert.assertEquals(title, "JavaByKiran | Downloads");
	}

}
