package testNG;

import org.testng.annotations.Test;

import baseClasses.resultpage;
import baseClasses.searchpage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestNGrunner2 {
	
	WebDriver dr;
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_v75.exe");
		dr=new ChromeDriver();
		dr.get("http://examples.codecharge.com/Store/Search.php");
	}
	
	
	@Test(priority=1) public void reading_values() 
	{
		searchpage sp=new searchpage(dr);
		 String exp =sp.read_excel().get(4).toString();
		 if("MySQL and mSQL".contentEquals(exp)) {}
		 else
			 sp.create_log("read_excel()", exp, "MySQL and mSQL", "fail");
		 
		Assert.assertEquals("MySQL and mSQL", exp);
		sp.create_log("read_excel()", exp, "MySQL and mSQL", "pass");
		 
	
	}

  
  
  @DataProvider(name="productname")
  public Object[] verify_book_name()
  {
	  resultpage rp = new resultpage(dr);
	  return new Object[] {rp.verifybook()};
  }
  
  

  @Test(dataProvider="productname",priority=2)
  public void verify_book_name(String name)
  {	

	  resultpage rp=new resultpage(dr);
	  String exp =rp.read_excel().get(4).toString();
//	  if((exp==name)){}
//	  else
//		  rp.create_log("read_excel()", exp, name, "fail");
	  Assert.assertEquals(exp, name);
	  rp.create_log("verifybook()", exp, name, "pass");
  }
  
  
  @DataProvider(name="productprice")
  public Object[] book_price()
  {
	  resultpage rp = new resultpage(dr);
	  return new Object[] {rp.verifyprice()};
  }

  
  @Test(dataProvider="productprice",priority=3)
  public void verify_book_price(String price)
  {
	  resultpage rp=new resultpage(dr);
	  String exp =rp.read_excel().get(3).toString();
//	  if((exp==price)){}
//	  else
//		  rp.create_log("read_excel()", exp, price, "fail");
	  Assert.assertEquals(exp, price);
	  rp.create_log("verifyprice()", exp, price, "pass");
  }
  
  
 

  @AfterClass
  public void afterClass() {
	  dr.close();
	  
  }

}
