package testNG;

import org.testng.annotations.Test;

import baseClasses.homepage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestNGrunner1 {
	
	WebDriver dr;
	
	@BeforeClass
	public void beforeClass() 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_v75.exe");
		dr=new ChromeDriver();
		dr.get("http://examples.codecharge.com/Store/Default.php");
	}

	@Test(priority=1)
	public void verify_title() 
	{
		homepage hp=new homepage(dr);
		
		WebDriverWait wait=new WebDriverWait(dr, 10);
		
		
		if(hp.title_of_page().equalsIgnoreCase("Online Bookstore")) {}
		else
			hp.create_log("title_of_page()", "Online Bookstore", hp.title_of_page(), "fail");
			
			
		Assert.assertEquals(hp.title_of_page(), "Online Bookstore");
		hp.create_log("title_of_page()", "Online Bookstore", hp.title_of_page(), "pass");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/table[2]/tbody/tr/td/a[2]")));
		



	}
 
	@Test(priority=2)
	public void verify_click() 
	{
		homepage hp=new homepage(dr);
		
		
		
		if(hp.click_search().equalsIgnoreCase("Clicked")) {}
		else
			hp.create_log("click_search()", "Clicked", hp.click_search(), "fail");
		Assert.assertEquals(hp.click_search(), "clicked");
		
		hp.create_log("click_search()", "Clicked", hp.click_search(), "pass");

//Assert.assertEquals(actual, expected);
	}

	

	@AfterClass
	public void afterClass() 
	{
		dr.close();
	}

}
