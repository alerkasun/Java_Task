package com.ita;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class console {
	
	private PersonDAO pD = null;
	private Scanner sc = null;
	
	public console() throws SQLException
	{
		pD = new PersonDAO();
		Scanner sc = new Scanner(System.in);
	}
	
	public void readP() throws SQLException
	{
		System.out.println("Enter id of person:");
		int id = Integer.valueOf(sc.nextLine());
		
		ResultSet rs = pD.readPerson(id);
		
		while(rs.next())
		{
			System.out.print(rs.getString("id")+" ");
			System.out.print(rs.getString("first_name")+" ");
			System.out.print(rs.getString("last_name")+" ");
			System.out.print(rs.getString("id_street"));
		}
	}
	
	public void writeP() throws SQLException
	{
		String fName = "";
		String lName = "";
		int age = 0;
		int idStreet = 0;
		System.out.println("Enter firs name:");
		fName = sc.nextLine();
		System.out.println("Enter last name:");
		lName = sc.nextLine();
		System.out.println("Enter age:");
		age = Integer.valueOf(sc.nextLine());
		System.out.println("Enter id street:");
		Integer.valueOf(sc.nextLine());
		
		pD.writePerson(fName, lName, age, idStreet);
	}
	
	public void updateP() throws SQLException
	{
		String fName = "";
		String lName = "";
		int age = 0;
		int idStreet = 0;
		int id = 0;
		System.out.println("Enter id of person to update");
		id =Integer.valueOf(sc.nextLine());
		System.out.println("Enter first name:");
		fName = sc.nextLine();
		System.out.println("Enter last name:");
		lName = sc.nextLine();
		System.out.println("Enter age:");
		age = Integer.valueOf(sc.nextLine());
		System.out.println("Enter id street:");
		Integer.valueOf(sc.nextLine());
		
		pD.updatePerson(id, fName, lName, age, idStreet);
	}
	
	public void deleteP() throws SQLException
	{
		System.out.println("Enter id of person to delete:");
		int id = Integer.valueOf(sc.nextLine());
		
		pD.deletePerson(id);
	}
}
