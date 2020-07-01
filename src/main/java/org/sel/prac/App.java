package org.sel.prac;

import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sel.Pages.LoginPage;
import org.sel.helpers.actionhelpers;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * Hello world!
 *
 */
public class App 
{

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get("https://qasit.emaplan.com/fidelity/SignIn?fidelity");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() throws InterruptedException {
    	/*driver.findElement(By.id("Username")).sendKeys("fidelitysuper");
    	driver.findElement(By.id("Password")).sendKeys("eSup3rMan");
    	driver.findElement(By.xpath("//button[.='Sign In']")).click();*/
    	
    	//WITH HELPERS
		/*actionhelpers.EnterText(driver, By.id("Username"), "fidelitysuper");
		actionhelpers.EnterText(driver, By.id("Password"), "eSup3rMan");
		actionhelpers.Click(driver, By.xpath("//button[.='Sign In']"));*/
    	
    	//WITH PAGES
    	new LoginPage(driver)
	    	.EnterUserName("fidelitysuper")
	    	.EnterPassword("eSup3rMan")
	    	.ClickSignIn();
    	Thread.sleep(3000);
        // Your test code here
    }

}