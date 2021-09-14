package com.bridgelabz.MathOperationApp;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

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
		
		Function<Integer,Double> toDoubleFunction=Integer::doubleValue;
		list.forEach(n->{
			System.out.println("for each lambda double value "+ toDoubleFunction.apply(n));
			});
		
		Predicate<Integer> isEvenFunction=n->n%2==0;
		list.forEach(n->{
			System.out.println("for each value of "+n+ " check even "+isEvenFunction.test(n));
		});
		
		
		//processing the stream
		list.stream().forEach(n->{
			System.out.println("stream for each value : "+n);
		});
		
		//process the stream,applying operations on stream and store the results
		List<Double> doubleList=list.stream().map(toDoubleFunction).collect(Collectors.toList());
		System.out.println("Printing double list :"+doubleList);
		
		//printing even double values
		List<Double> doubleListEven=list.stream().filter(isEvenFunction).map(toDoubleFunction).collect(Collectors.toList());
		System.out.println("Printing double list :"+doubleListEven);
		
		//peek and show the first even number
		Integer first=list.stream()
						.filter(isEvenFunction)
						.peek(n->System.out.println("Peek even number :"+n))
						.findFirst()
						.orElse(null);
		System.out.println("First even number :"+first);
		
		//min even numbers
		Integer min=list.stream()
				.filter(isEvenFunction)
				.min((n1,n2)->n1-n2)
				.orElse(null);
		System.out.println("min even number: "+min);
		
		//max even numbers
		Integer max=list.stream()
				.filter(isEvenFunction)
				.max(Comparator.comparing(Integer::intValue))
				.orElse(null);
		System.out.println("max even number: "+max);
		
		//sum,count,avg of numbers
		Integer sum=list.stream()
				.reduce(0, Integer::sum);
		long count=list.stream().count();
		System.out.println("avg of "+ sum +" / "+ count + "= "+ sum/count);
		
		//check for all even numbers, one even number and number multiple of 6
		boolean allEven=list.stream().allMatch(isEvenFunction);
		boolean oneEven=list.stream().anyMatch(isEvenFunction);
		boolean noneMultipleOfSix=list.stream().noneMatch(i->i>0 && i%6==0);
		System.out.println("all even: "+allEven);
		System.out.println("One Even: "+oneEven);
		System.out.println("none multiple of 6: "+noneMultipleOfSix);
		
		//sort the numbers in ascending order
		List<Integer> sortedList=list.stream()
									.sorted((n1,n2)->n1.compareTo(n2))
									.collect(Collectors.toList());
		System.out.println("list sorted in ascending order: "+sortedList);
		
		//sort the numbers in descending order
				List<Integer> sortedList1=list.stream()
											.sorted((n1,n2)->n2.compareTo(n1))
											.collect(Collectors.toList());
				System.out.println("list sorted in descending order: "+sortedList1);
		
	}
}
