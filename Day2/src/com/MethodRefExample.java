package com;

import java.util.ArrayList;
import java.util.List;

public class MethodRefExample {

	public static void main(String[] args) {
		List<String> li=new ArrayList<String>();
		li.add("Apple");
		li.add("Book");
		li.add("Mango");
		li.add("Banana");
		li.add("Cat");
		
		//li.forEach(new Sum()::display);
		li.forEach(System.out::println);
	}
}
