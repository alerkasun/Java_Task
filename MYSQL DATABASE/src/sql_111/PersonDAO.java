package sql_111;

import java.sql.*;


public class PersonDAO {
	
	private Connection conn = null;
	private Statement stmt = null;
	
	public PersonDAO() throws SQLException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HW", "root", "");
			stmt = conn.createStatement();	
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Error!");
			e.printStackTrace();
			return;
		}
	}
	
	public void readPerson(String fName, String lName, int age, int idStreet) throws SQLException
	{
		String sqlStr = "INSERT INTO person (first_name,last_name,age,id_street) VALUES ('"
						+fName+"','"+ lName +"','"+ age + "','" + idStreet +"')";
		stmt.executeUpdate(sqlStr);
	}
	
	public ResultSet readPerson(int id) throws SQLException
	{
		String sqlStr = "SELECT * FROM person WHERE id="+id;
		ResultSet rs = stmt.executeQuery(sqlStr);
		
		return rs;
	}
	
	public void updatePerson( int id, String fName,String lName,int age,int idStreet) throws SQLException
	{
		String sqlStr = "UPDATE person SET first_name='" 
						+ fName + "',last_name='" + lName +
						"',age=" + age + "',id_street='" + idStreet + "' WHERE id="+id;
		
		stmt.executeUpdate(sqlStr);
		
	}
	
	public void deletePerson(int id) throws SQLException
	{
		String sqlStr = "DELETE FROM person WHERE id="+id;
		stmt.executeUpdate(sqlStr);
	}

}