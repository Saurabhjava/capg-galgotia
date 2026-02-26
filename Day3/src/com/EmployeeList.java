package com;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeList {

	public static void main(String[] args) {
		List<Employee> li=new ArrayList<Employee>();
		
		li.add(new Employee(101, "Atul", 56000));
		li.add(new Employee(101, "Saurabh", 26000));
		li.add(new Employee(101, "Raj", 86000));
		li.add(new Employee(101, "Neha", 36000));
		li.add(new Employee(101, "Abhigyan", 96000.32));
		li.add(new Employee(101, "Rahul", 16000));
		li.add(new Employee(101, "Abhigyan", 96000.87));
		
		long startTime1=System.currentTimeMillis();
		//double totalSal1=li.parallelStream().collect(Collectors.summingDouble(e->e.getSalary()));
		List<Employee> sortedList1= li.parallelStream().sorted((e1,e2)->e1.getSalary().compareTo(e2.getSalary())).collect(Collectors.toList());
		long endTime1=System.currentTimeMillis();
		
		System.out.println("Time Taken by Par. Stream->"+(endTime1-startTime1));
		
		long startTime=System.currentTimeMillis();
		//li.stream().filter(e->e.getSalary()<50000).forEach(e->System.out.println(e));
		//Employee d=li.stream().max((e1,e2)->e1.getSalary().compareTo(e2.getSalary())).get();
		//double totalSal=li.stream().collect(Collectors.summingDouble(e->e.getSalary()));
		//double avgSal=li.stream().collect(Collectors.averagingDouble(e->e.getSalary()));
		List<Employee> sortedList= li.stream().sorted((e1,e2)->e1.getSalary().compareTo(e2.getSalary())).collect(Collectors.toList());
		long endTime=System.currentTimeMillis();
		System.out.println("Time Taken by Seq Stream->"+(endTime-startTime));
		
		
	}

}
