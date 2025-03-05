package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Student {
	
	public static void insert()throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/204db","root","root");
		PreparedStatement ps=c.prepareStatement("insert into students(name,age,city)values(?,?,?)");
		ps.setString(1, "Akanksha");
		ps.setInt(2, 20);
		ps.setString(3, "Pune");
		System.out.println("Data inserted");
		ps.executeUpdate();
		c.close();
	}
	public static void delete()throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/204db","root","root");
		PreparedStatement ps=c.prepareStatement("delete from students where name=?");
		ps.setString(1, "Akanksha");
		ps.executeUpdate();
		System.out.println("deleted ");
		c.close();
	}
	public static void update()throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/204db","root","root");
		PreparedStatement ps=c.prepareStatement("update students set age=? where name=?");
		
		ps.setInt(1, 21);
		ps.setString(2, "Akanksha");
		System.out.println("Data updated ");
		ps.executeUpdate();
		c.close();
	}
	public static void fetch()throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/204db","root","root");
		PreparedStatement ps=c.prepareStatement("select *from students");
		
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3));
		}
		c.close();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		insert();
//		update();
//		fetch();
		delete();
		
	}

}
