package com.ita;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Person {
	public Connection conn = null;
	public Statement stmt = null;

public Person() throws SQLException
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Persona", "root", "root");
		stmt = conn.createStatement();	
	}
	catch(ClassNotFoundException e)
	{
		System.out.println("Error!");
		e.printStackTrace();
		return;
	}
}
}