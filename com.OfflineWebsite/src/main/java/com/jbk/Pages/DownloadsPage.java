package com.jbk.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.jbk.ObjectRepository.DownloadsPageObjectRepository;

public class DownloadsPage extends DownloadsPageObjectRepository{

		WebDriver driver=null;
		public DownloadsPage(WebDriver driver) {
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
		
		public String validateLoginPageTitle() {
			return driver.getTitle();
		}		
}
