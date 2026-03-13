package com.cg.bean;

import java.util.List;
import java.util.Set;

public class HelloWorld {
	private String name;
	private Set<String> language;
	
//	public HelloWorld() {
//		// TODO Auto-generated constructor stub
//	}
//	public HelloWorld(String name) {
//		this.name=name;
//	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getLanguage() {
		return language;
	}
	public void setLanguage(Set<String> language) {
		this.language = language;
	}
	
	public String sayHello() {
		return "Hello "+name.toUpperCase()+" !";
	}
}
