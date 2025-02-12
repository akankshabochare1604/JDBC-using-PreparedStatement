package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Employee {
	public void insertData() throws Exception {
		//register and load driver 
		Class.forName("com.mysql.cj.jdbc.Driver");
		//connection
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204","root","root");
		//create prepared statement
		PreparedStatement ps=c.prepareStatement("insert into employees values(?,?,?)");
		ps.setInt(1, 5);
		ps.setString(2, "Pravin");
		ps.setString(3,"Latur");
		ps.executeUpdate();
		System.out.println("Data inserted ..");
		c.close();
	}

	public void deleteData() throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204","root","root");
		PreparedStatement ps=c.prepareStatement("delete from employees where id=?");
		ps.setInt(1, 5);
		ps.executeUpdate();
		System.out.println("ddata deleted..");
		c.close();
		
	}
	public void update() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204","root","root");
		PreparedStatement ps=c.prepareStatement("update employees set name=? where id=?");
		ps.setInt(2, 4);
		ps.setString(1, "AKASH");
		ps.executeUpdate();
		c.close();
	}
	public void fetch() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204","root","root");
		PreparedStatement ps=c.prepareStatement("select * from employees");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3));
		}
	}

}
