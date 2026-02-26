package com;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main1 {

	public static void main(String[] args) throws FileNotFoundException {
		//System.out.println("Hello World");
		PrintStream ps=new PrintStream(System.out);
		ps.println("Hello");
		ps.println("Hi");
	}

}
