package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Books {
	public void insert() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204","root","root");
		PreparedStatement ps=c.prepareStatement("insert into books values(?,?,?)");
		ps.setInt(1,6);
		ps.setString(2,"YAYATI");
		ps.setInt(3, 250);
		ps.executeUpdate();
		System.out.println("data inserted..");
		c.close();
		}
	public void delete() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204","root","root");
		PreparedStatement ps=c.prepareStatement("delete from books where id=? ");
		ps.setInt(1,2);
		ps.executeUpdate();
		System.out.println("data deleted..");
		c.close();
	}
	public void update() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204","root","root");
		PreparedStatement ps=c.prepareStatement("update books set price=? where id=?");
		ps.setInt(2,6);
		ps.setInt(1, 280);
		ps.executeUpdate();
		System.out.println("data updated..");
		c.close();
	}
	public void fetch() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204","root","root");
		PreparedStatement ps=c.prepareStatement("select *from books");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
		c.close();
	}
	
}
