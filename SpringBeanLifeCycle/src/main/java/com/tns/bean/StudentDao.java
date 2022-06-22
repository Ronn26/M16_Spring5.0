package com.tns.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao
{
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://127.0.0.1:3306//user=root";
	private String user="root";
	private String password="Roshan@123";
	public void selectAllRows() throws ClassNotFoundException, SQLException
	{
		//load the driver
		Class.forName(driver);
		
		//get connection
		Connection con=DriverManager.getConnection(url, user, password);
		
		//execute a query
		Statement s=con.createStatement();
		ResultSet r=s.executeQuery("SELECT * FROM m16.book;");
		while(r.next())
		{
			int id=r.getInt(1);
			String title=r.getString(2);
			String author=r.getString(3);
			int price=r.getInt(4);
			System.out.println("Author ID: "+id+" title "+title+" Author name is: "+author+" price: "+price);
		}
	}
}
