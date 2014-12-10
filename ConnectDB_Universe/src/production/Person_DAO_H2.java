package production;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Person_DAO_H2 implements Person_DAO
{
	private Connection 	conn 	= null;
	private Statement 	state 	= null;
	private ResultSet 	rs		= null;

	@Override
	public void connect()
	{
		String url 		= "jdbc:h2:~/test";
		String dbName 	= "";
		String driver 	= "org.h2.Driver";
		String userName = "sa";
		String password = "";

		try
		{
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(
					url + dbName,
					userName,
					password);

			state = conn.createStatement();
		}
		catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public void disconnect()
	{
		try
		{
			if(conn != null)
				conn.close();

			if(state != null)
				state.close();

			if(rs != null)
				rs.close();

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void create(Person p)
	{
		String sql = 
				"INSERT INTO Persons VALUES ("
						+ p.getId() + ", '"
						+ p.getFirstName() + "', '"
						+ p.getLastName() + "', "
						+ p.getAge() + ")";

		try
		{
			state.executeUpdate(sql);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Person> read()
	{
		ArrayList<Person> persons = new ArrayList<>();

		try
		{
			rs = state.executeQuery("SELECT * FROM Persons");

			while (rs.next())
			{
				Person p = new Person();

				p.setId(rs.getInt("Id"));
				p.setFirstName(rs.getString("FirstName"));
				p.setLastName(rs.getString("LastName"));
				p.setAge(rs.getInt("Age"));

				persons.add(p);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return persons;
	}

	@Override
	public void update(Person p)
	{
		String sql =
				"UPDATE Persons SET FirstName='"	+ p.getFirstName()
				+ "', LastName='" + p.getLastName()
				+ "', Age=" + p.getAge()
				+ " WHERE Id=" + p.getId();

		try
		{
			state.executeUpdate(sql);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Person p)
	{
		String sql = "DELETE FROM Persons WHERE Id=" + p.getId();

		try
		{
			state.executeUpdate(sql);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
