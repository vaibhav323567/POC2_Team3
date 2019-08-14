package baseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class resultpage {

	WebDriver dr;
	String bookname="", less="",more="",pri="",pr_name="";
	int i;
	Logger log=Logger.getLogger("devpinoyLogger");
	
	public resultpage(WebDriver dr)
	{
		this.dr=dr;
	}
	
	public String verifybook()
	{
		String str=dr.findElement(By.linkText("MySQL and mSQL")).getText();
		return str;
	}
	
	public String verifyprice()
	{
		String str=dr.findElement(By.xpath("//*[@class='Row']/td[2]")).getText();
		 int ind=str.indexOf("$");
			
			String price=str.substring(ind+1);
			return price;
	}
	
	
	public List<Cell> read_excel()
	{
		List<Cell> str=new ArrayList<>();
		try {
			File f = new File("D:\\Training\\book.xlsx");
			FileInputStream fis;

			fis = new FileInputStream(f);

			XSSFWorkbook wb= new	XSSFWorkbook(fis); 
			XSSFSheet sh = wb.getSheet("Sheet1");
			XSSFRow row= sh.getRow(0);

			
			for(int i=0;i<row.getLastCellNum();i++)
			{
				Cell cell1 = row.getCell(i);
				 str.add(cell1);	
				
				
			}
			bookname=String.valueOf(str.get(0));
			less=String.valueOf(str.get(1));
			more=String.valueOf(str.get(2));
			pri=String.valueOf(str.get(3));
			pr_name=String.valueOf(str.get(4));
			
			
			wb.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			
		}

		return str;
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
