package com.bridgelabz.MathOperationApp;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;

public class NumberPlayList 
{

	public static void main(String[] args) 
	{
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int index=1;index<=5;index++)
		{
			list.add(index);
		}
		
		//traversing using foreach
		for(int index:list)
		{
			System.out.println("Foreach: Number is "+index);
		}
		
		//traversing using iterator
		Iterator<Integer> itr=list.iterator(); 
		while(itr.hasNext())
		{
			int value=itr.next();
			System.out.println("Iterator: Number is "+ value);
		}
		
		//traversing with consumer interface implementation
		class MyConsumer implements Consumer<Integer>
		{	@Override
			public void accept(Integer index) 
			{
				System.out.println("consumer implementation value is "+index);
			}
		}
		MyConsumer object=new MyConsumer();
		list.forEach(object);
		
		//traversing with anonymous consumer interfacee implementation
		list.forEach(new Consumer<Integer>() 
		{
			public void accept(Integer t) 
			{
				System.out.println("For each anonymous class value "+t);
			}
		});
		
		//explicit lambda function
		Consumer<Integer> mylist=n->{
			System.out.println("For each lambda implementation value "+n);
		};
		list.forEach(mylist);
		
		//implicit lambda function
		list.forEach(n->{
			System.out.println("for each lambda implementation value "+ n);
			});
		
		Function<Integer,Double> doubleFunction=Integer::doubleValue;
		list.forEach(n->{
			System.out.println("for each lambda double value "+ doubleFunction.apply(n));
			});
	}
}
