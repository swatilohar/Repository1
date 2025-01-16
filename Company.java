

class Company{
	int companyId=11;
	String companyName="abc";
	String companyAdress="Pune";

public void displayCompanyDetails()
{
	Company c1= new Company();
	System.out.println(c1.companyId);
	System.out.println(c1.companyName);
	System.out.println(c1.companyAdress);
}

public void displayemployeeDetails()
{
	int employeeid=1;
	String employeeName="swati";
	String departmentName="abc";
	System.out.println(employeeid);
	System.out.println(employeeName);
	System.out.println(departmentName);
	
	
}
public static void main(String[] args)
{
	Company c2= new Company();
	c2.displayCompanyDetails();
	c2.displayemployeeDetails();
}
}





	