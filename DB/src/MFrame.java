import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


public class MFrame extends JFrame {
	
	public MFrame() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		setBounds(600, 600, 500, 320);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Commands commands = new Commands();
		
		TablePanel  tablePanel  = new TablePanel();
		ButtonPanel buttonPanel = new ButtonPanel(commands);
		
		commands.tablePanel  = tablePanel;
		commands.buttonPanel = buttonPanel;

		add(tablePanel);
		add(buttonPanel);
		
		setVisible(true);
	}	
}
