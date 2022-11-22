package vTiger.Practice;

public class GenericUtilityPractice {

	public static void main(String[] args) { // calling/caller function
		
		int value=GenericUtilityPractice.add(10,20);
		System.out.println(value);

	}
	
	public static int add(int a, int b) //called function
	{
		int c =a+b;
		
		return c;
	}
	
	

}
