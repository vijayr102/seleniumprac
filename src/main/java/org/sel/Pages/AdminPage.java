package org.sel.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sel.helpers.actionhelpers;

public class AdminPage {
	WebDriver driver;
	public AdminPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public AdminPage AssertAdminMenu(WebDriver driver) {
		actionhelpers.Presence(driver,By.xpath("//*[@class='container js-usernav']"));
		return new AdminPage(driver);
	}
}
