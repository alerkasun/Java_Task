import java.sql.*;
import java.util.ArrayList;

public class PersonDAO_H2 implements PersonDAOInterface {
	
	private Connection conn = null;
	private Statement stmt = null;
	
	@Override
	public void connect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test","sa", "");
			stmt = conn.createStatement();	
		}
		catch(Exception e)
		{
			System.out.println("Error!");
			e.printStackTrace();
			return;
		}
	}
	
	@Override
	public void disConnect()
	{
		try 
		{
			stmt.close();
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	@Override
	public ArrayList<Person> readPersons()
	{
		ArrayList<Person> arrL = new ArrayList<Person>();
		
		try
		{
		ResultSet rs = stmt.executeQuery("SELECT * FROM person");
		while(rs.next())
		{
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setFName(rs.getString("first_name"));
			person.setLName(rs.getString("last_name"));
			person.setAge(rs.getInt("age"));
			person.setIdStreet(rs.getInt("id_street"));
			
			arrL.add(person);
		}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return arrL;
	}
	
	@Override
	public void createPerson(Person person)
	{
		String fName =person.getFName();
		String lName = person.getLName();
		int age = person.getAge();
		int idStreet = person.getIdStreet();
		
		String query = "INSERT INTO person (first_name,last_name,age,id_street) VALUES ('"
					   +fName+"','"+ lName +"','"+ age + "','" + idStreet +"');";
		try
		{
			stmt.executeUpdate(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}		
	}
	
	@Override
	public void updatePerson(Person person)
	{
		String fName = person.getFName();
		String lName = person.getLName();
		int age =      person.getAge();
		int idStreet = person.getIdStreet();
		int id = person.getId();
		
		String query = "UPDATE person SET first_name='" 
				+ fName + "',last_name='" + lName +
				"',age='" + age + "',id_street='" + idStreet + "' WHERE id="+id;
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void deletePerson(Person person) 
	{
		int id = person.getId();
		String query = "DELETE FROM person WHERE id="+id;
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}