import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Person_DAO_MySQL
{
	private Connection conn = null;
	private Statement  st   = null;
	
	public void Connect() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/home_work6", "root", "root");
        st = conn.createStatement();
	}
	
	public void DisConnect() throws SQLException
	{
		st.close();
		conn.close();
	}
	public void Create(Person p)
	{
		
	}
	public ArrayList<Person> Read() throws SQLException
	{
		ArrayList<Person> ar = new ArrayList<Person>();
		
		String query = "SELECT id, firstname, lastname, age FROM persons;";
		ResultSet res = st.executeQuery(query);
		while( res.next() )
		{
			Person p = new Person();
			p.setId   ( Integer.valueOf(res.getInt("id")) );
			p.setFName( res.getString("firstname") );
			p.setLName( res.getString("lastname") );
			p.setAge  ( Integer.valueOf(res.getInt("age")) );
			ar.add(p);
		}
		
		return ar;
	}
	public void Update(Person p)
	{
		//st.executeUpdate();
	}
	public void Delete(Person p)
	{
		
	}
}
