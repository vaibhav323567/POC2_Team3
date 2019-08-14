package baseClasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homepage {

	WebDriver dr;	
	Logger log=Logger.getLogger("devpinoyLogger");
	
	public homepage(WebDriver dr)
	{
		this.dr=dr;
	}
	
	public String title_of_page()
	{
		String title=dr.getTitle();
		return title;
	}
	
	public String click_search()
	{
		dr.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/a[2]")).click();
		return "clicked";
	}
	
	
	public void create_log(String meth_name, String exp_res, String act_res, String test_res)
	{
		if(test_res.equalsIgnoreCase("PASS"))
		{
			if(exp_res=="")
				log.info("Method "+ meth_name+" executed \n");
			else
				log.info("Method "+ meth_name+" executed \n"+"Expected Result: "+exp_res+"\n Actual Result: "+act_res+"\n Test Result: "+test_res);

		}
		else {
			if(exp_res=="")
				log.info("Method "+ meth_name+"\n");
			else
				log.info("Method "+ meth_name+"\n"+"Expected Result: "+exp_res+"\n Actual Result: "+act_res+"\n Test Result: "+test_res);
		}
	}

	
	
}
