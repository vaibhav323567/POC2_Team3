package baseClasses;

public class exceldata {
	
	int lessthen,morethen;
	String cate="";
	
	public exceldata(int lessthen,int morethen,String cate)
	{
		this.cate=cate;
		this.lessthen=lessthen;
		this.morethen=morethen;
	}
	
	public String category()
	{
		return cate;
	}
	public int less_then()
	{
		return lessthen;
	}
	public int more_then()
	{
		return morethen;
	}

}
