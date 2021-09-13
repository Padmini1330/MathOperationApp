package com.bridgelabz.MathOperationApp;


public class MathOperationApp 
{
	@FunctionalInterface
	interface IMathFunction
	{
		int calculate(int a,int b);
	}
	
	
	public static void main(String[] args)
	{
		IMathFunction addition= (int a,int b)-> (a+b);
		IMathFunction subtraction= (int a,int b)-> (a-b);
		IMathFunction multiplication= (int a,int b)-> (a*b);
		IMathFunction division= (int a,int b)-> (a/b);
		
		System.out.println("Addition is "+addition.calculate(5, 2));
		System.out.println("Subtraction is "+subtraction.calculate(5, 2));
		System.out.println("Multiplication is "+multiplication.calculate(5, 2));
		System.out.println("Division is "+division.calculate(5, 2));
	}
	

}
