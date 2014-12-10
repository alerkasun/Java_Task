

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JDialog;

public class Commands 
{

	ConnectListener    actionConnect    = new ConnectListener();
	DisconnectListener actionDisConnect = new DisconnectListener();
	CreateListener     actionCreate     = new CreateListener();
	ReadListener       actionRead       = new ReadListener();
	UpdateListener     actionUpdate     = new UpdateListener();
	DeleteListener     actionDelete     = new DeleteListener();

	private Person_DAO_MySQL ds = null;
	
	DBConnect_TablePanel panelWork = null;
	
	DBConnect_PersonDialog dlg = null;

	public Commands()
	{
		ds = new Person_DAO_MySQL();
		dlg = new DBConnect_PersonDialog();
	}

	class ConnectListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				ds.Connect();
			} 
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
		}
	}

	class DisconnectListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				ds.DisConnect();
			}
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
		}
	}

	class CreateListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{	
			dlg.setVisible(true);
			//if(dlg. result == Md.OK)
			{
				ds.Create(dlg.getPerson());
			}
		}

	}
	class ReadListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{	
			try 
			{
				panelWork.mdlPerson.ar = ds.Read();
				panelWork.tblPerson.updateUI();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
	
	class UpdateListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{	
			//panelWork.tblPerson.gets
			//new OptionFrame(e.getActionCommand());
			//table.updateTable();
		}

	}
	class DeleteListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{	
			//new OptionFrame(e.getActionCommand());
			//table.updateTable();
		}

	}
}
