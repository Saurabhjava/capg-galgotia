package com;

public class FactoryMethod {
	public Student createObject(String name, int marks) {
		Student s=new Student();
		s.setName(name);
		s.setMarks(marks);
		return s;
	}
}
