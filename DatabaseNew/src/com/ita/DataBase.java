package com.ita;

import java.sql.*;
import java.util.Properties;



public class DataBase
{
	private Connection conn = null;
	private Statement stmt = null;
	
	public DataBase() throws SQLException
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
	
	public ResultSet exSql(String sqlStr) throws SQLException
	{	
		return stmt.executeQuery(sqlStr);
	}
	
	public void qrPersonCount() throws SQLException
	{
		ResultSet rs = exSql("SELECT COUNT(*) FROM Person");
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
		}
		
	}
	
	public void qrMidAge()
	{
		
	}
	
	public void qrSortedByLastName()
	{
		
	}
	
	public void qrLastNameRepeat()
	{
		
	}
	
	public void qrLastNameHaveB()
	{
		
	}
	
	public void qrHobo()
	{
		
	}
	
	public void qrYoungOnPravda()
	{
		
	}
	
	public void qrSortedStreetListWSPersons()
	{
		
	}
	
	public void qrStreetName6Lt()
	{
		
	}
	
	public void qrStreet3Person()
	{
		
	}
}
