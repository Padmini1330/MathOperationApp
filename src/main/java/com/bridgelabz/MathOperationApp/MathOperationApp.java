package com.bridgelabz.MathOperationApp;


public class MathOperationApp 
{
	@FunctionalInterface
	interface IMathFunction
	{
		int calculate(int a,int b);
		static void printResult(int a,int b,String function,IMathFunction object)
		{
			System.out.println("Result of "+ function+ " is "+ object.calculate(a, b));
		}
	}
	
	
	public static void main(String[] args)
	{
		IMathFunction addition= (int a,int b)-> (a+b);
		IMathFunction subtraction= (int a,int b)-> (a-b);
		IMathFunction multiplication= (int a,int b)-> (a*b);
		IMathFunction division= (int a,int b)-> (a/b);
		
		IMathFunction.printResult(5,2,"Addition",addition);
		IMathFunction.printResult(5,2,"Subtraction",subtraction);
		IMathFunction.printResult(5,2,"Multiplication",multiplication);
		IMathFunction.printResult(5,2,"Division",division);
	}
	

}
