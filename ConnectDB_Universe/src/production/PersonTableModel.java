package production;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class PersonTableModel extends AbstractTableModel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Collection for outputting to table
	 */
	public ArrayList<Person> persons = new ArrayList<Person>();
	public Person p = new Person();
	
	/**
	 * Table column names
	 */
	private String[] columnNames = {"ID", "FirstName", "LastName", "Age"};
	
	@Override
	public String getColumnName(int column)
	{
		String ret = "";
		
		switch (column) 
		{
			case 0: ret = columnNames[0];
				break;
				
			case 1: ret = columnNames[1];
				break;
				
			case 2: ret = columnNames[2];
				break;
				
			case 3: ret = columnNames[3];
				break;
				
			default:
				break;
		}
		
		return ret;
	}

	@Override
	public int getRowCount()
	{
		return persons.size();
	}

	@Override
	public int getColumnCount()
	{
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		Object ret = null;
		Person p = persons.get(rowIndex);
		
		switch (columnIndex) 
		{
			case 0: ret = p.getId();
				break;
			
			case 1: ret = p.getFirstName();
				break;
				
			case 2: ret = p.getLastName();
				break;
				
			case 3: ret = p.getAge();
				break;
		}
		
		return ret;
	}
}
