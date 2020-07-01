package org.sel.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sel.helpers.actionhelpers;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LoginPage EnterUserName(String text)
	{
		actionhelpers.EnterText(driver, By.id("Username"), text);
		return new LoginPage(driver);
	}
	
	public LoginPage EnterPassword(String text)
	{
		actionhelpers.EnterText(driver, By.id("Password"), text);
		return new LoginPage(driver);
	}
	
	public AdminPage ClickSignIn()
	{
		actionhelpers.Click(driver, By.xpath("//button[.='Sign In']"));
		return new AdminPage(driver);
	}
	
}
