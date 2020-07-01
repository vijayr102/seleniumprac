package org.sel.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class actionhelpers {
	
	static int timeout;
	public actionhelpers() {
		timeout=25000;
    }
	public static void EnterText(WebDriver driver,By selector,String text)
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(selector));
		driver.findElement(selector).clear();
		driver.findElement(selector).sendKeys(text);
	}
	
	public static void Click(WebDriver driver,By selector)
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(selector));
		driver.findElement(selector).click();
	}
	public static void Presence(WebDriver driver, By xpath) {
		// TODO Auto-generated method stub
		
	}
	
	
}
