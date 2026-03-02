package com.cg.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class MyConnection {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=
					DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			Statement stat=con.createStatement();
			ResultSet rs= stat.executeQuery("select * from customers");
			while(rs.next()) {
				Date last_v_on=rs.getDate(4);
				LocalDate ld=last_v_on.toLocalDate();
				//Period p=Period.between(ld,LocalDate.now());
				long days=ChronoUnit.DAYS.between(ld, LocalDate.now());
				System.out.println(rs.getString("name")+"\t"+rs.getLong("phone")+"\t"+days);
			}
			
			//Scanner sc=new Scanner(System.in);
			//System.out.println("Enter Customer ID");
			//int cid=sc.nextInt();
//			PreparedStatement ps=con.prepareStatement("select * from customers where name=? and phone=?");
//			ps.setString(1,"Priya Singh");
//			ps.setString(2,"9876501234");
//			ResultSet rs=ps.executeQuery();
//			if(rs.next()) 
//				System.out.println(rs.getString("name")+"\t"+rs.getLong("phone")+"\t"+rs.getDate(4));
//			else
//				System.out.println("Customer Not Found");
			
//			PreparedStatement ps=con.prepareStatement("insert into customers values(?,?,?,?,?)");
//			ps.setInt(1, 18);
//			ps.setString(2, "Balraj");
//			ps.setString(3, "9999596047");
//			ps.setString(4, "2026-02-25");
//			ps.setInt(5, 1200);
//			int rows=ps.executeUpdate();
//			if(rows>0)
//				System.out.println("Customer Created...");
					
		} catch (Exception e) {
			System.out.println("Customer Not Created...");
		}
	}

}
