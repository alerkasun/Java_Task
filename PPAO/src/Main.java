import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {

	public static void main(String[] args) throws SQLException {
		
		// TODO Auto-generated method stub
		PublicPAO ppp = new PublicPAO();
		ResultSet rs = ppp.readPerson(1);
		
		while(rs.next())
		{
			System.out.println(rs.getString("name"));
		}
		
	}
	

}
