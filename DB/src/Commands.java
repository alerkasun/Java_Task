import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Commands {

	public ConnectListener connectListener = new ConnectListener();
	public DisConnectListener disconnectListener = new DisConnectListener();
	public ReadListener readListener = new ReadListener();
	public WriteListener writeListener = new WriteListener();
	public UpdateListener updateListener = new UpdateListener();
	public DeleteListener deleteListener = new DeleteListener();
	public DBChangeListener dbchangeListener = new DBChangeListener();

	private PersonDAOInterface personDAOInterface = null;

	public TablePanel  tablePanel  = null;
	public ButtonPanel buttonPanel = null;

	public Commands() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		personDAOInterface = new PersonDAO_MySQL();
	}

	class DBChangeListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String str = (String) buttonPanel.comboBox.getSelectedItem();

			if(str.equals("MySQL DataBase"))
			{
				personDAOInterface = new PersonDAO_MySQL();
			}
			if(str.equals("MongoDataBase"))
			{
				personDAOInterface = new PersonDAO_MongoDB();
			}
			if(str.equals("H2 DataBase"))
			{
				personDAOInterface = new PersonDAO_H2();
			}
			if(str.equals("MongoDB JSON"))
			{
				personDAOInterface = new PersonDAO_MongoDB_JSON();
			}
			if(str.equals("MongoDB CSV"))
			{
				personDAOInterface = new PersonDAO_MongoDB_CSV();
			}
		}
	}

	class ConnectListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				personDAOInterface.connect();
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
			}
		}
	}

	class DisConnectListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				personDAOInterface.disConnect();
			}
			catch (Exception exp)
			{
				exp.printStackTrace();
			}
		}
	}

	class ReadListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			tablePanel.personTableModel.personList = personDAOInterface.readPersons();
			tablePanel.table.updateUI();
		}
	}

	class WriteListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			EditDialog editDialog = new EditDialog();

			editDialog.addTable("Write", new Person());
			editDialog.setVisible(true);

			personDAOInterface.createPerson(editDialog.getPerson());
		}
	}

	class UpdateListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			int row = tablePanel.table.getSelectedRow();
			Person person = tablePanel.personTableModel.personList.get(row);
			EditDialog editDialog = new EditDialog();
			editDialog.addTable("Update", person);
			editDialog.setVisible(true);

			personDAOInterface.updatePerson(editDialog.getPerson());
		}
	}

	class DeleteListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			int row = tablePanel.table.getSelectedRow();
			Person person = tablePanel.personTableModel.personList.get(row);
			EditDialog editDialog = new EditDialog();
			editDialog.addTable("Delete", person);
			editDialog.setVisible(true);

			personDAOInterface.deletePerson(editDialog.getPerson());
		}
	}
}
