package vTiger.Practice;

import org.testng.annotations.Test;

public class TestNGPractice{
	@Test(invocationCount = 3, priority = 2)
	public void CreateCustomer()
	{
		System.out.println("customer created");
	}
	
	@Test()
	public void modifyCustomer()
	{
		System.out.println("customer modified");
	}
	
	@Test()
	public void deleteCustomer()
	{
		System.out.println("customer deleted");
	}

}
