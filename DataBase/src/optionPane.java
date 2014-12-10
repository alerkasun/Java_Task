import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class optionPane {

	PersonDAO pD = null;
	
	public optionPane() throws SQLException 
	{
		pD = new PersonDAO();
	}
	
	public void writePerson() throws SQLException
	{
		String fName = JOptionPane.showInputDialog(null,"Enter first name");
		String lName = JOptionPane.showInputDialog(null,"Enter last name");
		int age = Integer.valueOf(JOptionPane.showInputDialog(null,"Enter age"));
		int idStreet = Integer.valueOf(JOptionPane.showInputDialog(null,"Enter street id"));
		
		pD.writePerson(fName, lName, age, idStreet);
		
	}
	
	public void readPerson() throws SQLException
	{
		int id = Integer.valueOf(JOptionPane.showInputDialog(null));
		
		ResultSet rs = pD.readPerson(id);
		
		while(rs.next())
		{
			String rStr = "person id=" + rs.getString("id")+ " first name=" + rs.getString("first_name") + " last name=" 
		+ rs.getString("last_name") + " age=" + rs.getString("age") + " street id =" + rs.getString("id_street");
			JOptionPane.showConfirmDialog(null, rStr);
		}
		
	}
	
	public void updatePerson() throws SQLException
	{
		int id = Integer.valueOf(JOptionPane.showInputDialog("Enter id of person to update"));
		
		String fName = JOptionPane.showInputDialog("Enter first name");
		String lName = JOptionPane.showInputDialog("Enter last name");
		int age = Integer.valueOf(JOptionPane.showInputDialog("Enter age"));
		int idStreet = Integer.valueOf(JOptionPane.showInputDialog("Enter street id"));
		
		pD.updatePerson(id, fName, lName, age, idStreet);
		
	}
	
	public void deletePerson() throws SQLException
	{
		int id = Integer.valueOf(JOptionPane.showInputDialog("Enter id of person to delete:"));
		
		pD.deletePerson(id);
	}

}
