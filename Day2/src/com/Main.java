package com;

public class Main {

	public static void main(String[] args) {
		IDemo obj=new FactoryMethod()::createObject;
		Student s=obj.createStudent("Saksham",78);
		System.out.println("Name="+s.getName());
		System.out.println("Marks="+s.getMarks());
	}

}
