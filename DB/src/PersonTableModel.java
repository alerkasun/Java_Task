import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class PersonTableModel extends AbstractTableModel {

	public ArrayList<Person> personList = new ArrayList<Person>();
	
	@Override
	public String getColumnName(int column)
	{
		String retStr = "";
		
		switch(column)
		{
			case 0: retStr = "ID"; break;
			case 1: retStr = "First Name"; break;
			case 2: retStr = "Last Name"; break;
			case 3: retStr = "Age"; break;
			case 4: retStr = "ID Street"; break;
		}
		return retStr;
	}
	
	@Override
	public int getColumnCount() 
	{	
		return 5;
	}

	@Override
	public int getRowCount() 
	{
		return personList.size();
	}

	@Override
	public Object getValueAt(int row, int column) 
	{
		Object retObj = null;
		Person person = personList.get(row);
		
		switch(column)
		{
			case 0: retObj = person.getId(); break;
			case 1: retObj = person.getFName(); break;
			case 2: retObj = person.getLName(); break;
			case 3: retObj = person.getAge(); break;
			case 4: retObj = person.getIdStreet(); break;
		}
		return retObj;
	}

}
