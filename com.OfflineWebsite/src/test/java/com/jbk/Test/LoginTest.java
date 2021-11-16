package com.jbk.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestBases.TestBase;
import com.jbk.Pages.DashboardPage;
import com.jbk.Pages.LoginPage;
import com.jbk.Pages.RegistrationPage;
import com.utility.DataProvidersUtils;

public class LoginTest  extends TestBase{
	WebDriver driver;
	LoginPage lp;
	RegistrationPage rp;
	DashboardPage dp;
	String sheetName="registration";
	@BeforeMethod
	public void setUp() {
		driver =initialization();
		lp = new LoginPage(driver);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void checkCrediantialsPassword() {
		Assert.assertTrue(lp.checkCrediantialsPassword());
	}
	@Test
	public void verifyTitle() {
		String title=lp.validateLoginPageTitle();
		Assert.assertEquals(title, "JavaByKiran | Log in");
	}
	@Test
	public void verifyImage() {
		boolean i=lp.validateImage();
		Assert.assertTrue(i);
	}
	
	@Test
	public void checkValidCredentials() {
		dp = lp.verifyValidLogin();
	}
	@DataProvider
	public Object[][] getRegistrationPageData() {
		Object data[][]=DataProvidersUtils.getTestData(sheetName);
		return data;
	}
	@Test(dataProvider="getRegistrationPageData")
	public void registrationPage(String Name,String	Mobile,String Email,String password) {
		//lp.clickOnRegistrationLink();
		lp.clickOnRegistrationLink().registrationForm(Name, Mobile, Email, password);
	}
}