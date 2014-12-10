package production;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;


public class Commands
{
	public ActionConnect 	connect 	= null;
	public ActionInvokeDlg	invokeDlg	= null;
	public ActionRead 		read 		= null;
	public ActionSelectDB	selectDB	= null;		
	
	public String 			currDB 		= "MySQL";
	public PersonTableModel model 		= null;
	
	private String 			currAction 	= null;
	private Person_DAO 		pDAO 		= null;

	public Commands()
	{
		connect 	= new ActionConnect();
		invokeDlg 	= new ActionInvokeDlg();
		read 		= new ActionRead();
		selectDB	= new ActionSelectDB();	
	}
	
	/**
	 * Action for "Connect" toggle button
	 * @author maestro-6000
	 *
	 */
	public class ActionConnect implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JToggleButton tbtn = (JToggleButton) e.getSource();

			if(tbtn.isSelected() == true)
			{
				tbtn.setText("Disconnect");
				
				/**
				 * Create connection to needed database
				 */
				switch(currDB)
				{
					case "MySQL":
						pDAO = new Person_DAO_SQL();
						break;
						
					case "MongoDB":
						pDAO = new Person_DAO_Mongo();
						break;
						
					case "H2":
						pDAO = new Person_DAO_H2();
						break;
						
					case "MySQL hibernate":
						pDAO = new Person_DAO_SQLh();
						break;
						
					case "CSV":
						pDAO = new Person_DAO_CSV();
						break;
						
					case "XML":
						pDAO = new Person_DAO_XML();
						break;
						
					case "JSON":
						pDAO = new Person_DAO_JSON();
						break;
						
					case "Mock":
						pDAO = new Person_DAO_Mock();
						break;
						
					default:
						break;
				}
				pDAO.connect();
			}
			else
			{
				pDAO.disconnect();
				tbtn.setText("Connect");
			}
		}
	}
	
	/**
	 * Action for the "Read" button
	 * @author maestro-6000
	 *
	 */
	public class ActionRead implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			model.persons = pDAO.read();
			model.fireTableDataChanged();
		}
	}
	
	/**
	 * Action for "Create", "Delete" and "Update" buttons
	 * @author maestro-6000
	 *
	 */
	public class ActionInvokeDlg implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			currAction = e.getActionCommand();
			new InputDialog(pDAO, currAction, model);
		}
	}
	
	public class ActionSelectDB implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			currDB = e.getActionCommand();
		}	
	}
}
