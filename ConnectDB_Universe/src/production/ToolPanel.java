package production;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToggleButton;


public class ToolPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToolPanel(PersonTableModel model)
	{
		/**
		 * Items for selecting database.
		 */
		JRadioButtonMenuItem rbtnSQL 	= new JRadioButtonMenuItem("MySQL");
		rbtnSQL.setSelected(true); // Selected by default
		
		JRadioButtonMenuItem rbtnMongo 	= new JRadioButtonMenuItem("MongoDB");
		JRadioButtonMenuItem rbtnH2 	= new JRadioButtonMenuItem("H2");
		JRadioButtonMenuItem rbtnSQLh 	= new JRadioButtonMenuItem("MySQL hibernate");
		JRadioButtonMenuItem rbtnCSV 	= new JRadioButtonMenuItem("CSV");
		JRadioButtonMenuItem rbtnXML 	= new JRadioButtonMenuItem("XML");
		JRadioButtonMenuItem rbtnJSON 	= new JRadioButtonMenuItem("JSON");
		JRadioButtonMenuItem rbtnMock 	= new JRadioButtonMenuItem("Mock");
		
		/**
		 * Group our item for selecting database.
		 */
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbtnSQL);
		bg.add(rbtnMongo);
		bg.add(rbtnH2);
		bg.add(rbtnSQLh);
		bg.add(rbtnCSV);
		bg.add(rbtnXML);
		bg.add(rbtnJSON);
		bg.add(rbtnMock);
		
		/**
		 * CRUD buttons for database.
		 */
		JButton btnCreate 	= new JButton("Create");
		JButton btnRead 	= new JButton("Read");
		JButton btnUpdate 	= new JButton("Update");
		JButton btnDelete 	= new JButton("Delete");
		
		/**
		 * Button for connecting and disconnecting database.
		 */
		JToggleButton tbtnConnect = new JToggleButton("Connect");
		tbtnConnect.setForeground(Color.RED); // Make a red color text on it
		
		/**
		 * Setting optional cases
		 */
		Commands cmd = new Commands();
		cmd.model = model;
		
		/**
		 * Setting actions for all components
		 */
		btnRead.	addActionListener(cmd.read);
		btnCreate.	addActionListener(cmd.invokeDlg);
		btnUpdate.	addActionListener(cmd.invokeDlg);
		btnDelete.	addActionListener(cmd.invokeDlg);
		tbtnConnect.addActionListener(cmd.connect);
		
		rbtnSQL.	addActionListener(cmd.selectDB);
		rbtnMongo.	addActionListener(cmd.selectDB);
		rbtnH2.		addActionListener(cmd.selectDB);
		rbtnSQLh.	addActionListener(cmd.selectDB);
		rbtnCSV.	addActionListener(cmd.selectDB);
		rbtnXML.	addActionListener(cmd.selectDB);
		rbtnJSON.	addActionListener(cmd.selectDB);
		rbtnMock.	addActionListener(cmd.selectDB);
		
		/**
		 * Setting layout manager for a panel.
		 * Initializing constraints.
		 */
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		/**
		 * Adding radio buttons
		 */
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 0;
		add(rbtnSQL, c);
		
		c.gridx = 0;
		c.gridy = 1;
		add(rbtnSQL, c);
		
		c.gridx = 0;
		c.gridy = 2;
		add(rbtnMongo, c);
		
		c.gridx = 0;
		c.gridy = 3;
		add(rbtnH2, c);
		
		c.gridx = 0;
		c.gridy = 4;
		add(rbtnSQLh, c);
		
		c.gridx = 0;
		c.gridy = 5;
		add(rbtnCSV, c);
		
		c.gridx = 0;
		c.gridy = 6;
		add(rbtnXML, c);
		
		c.gridx = 0;
		c.gridy = 7;
		add(rbtnJSON, c);
		
		c.gridx = 0;
		c.gridy = 8;
		add(rbtnMock, c);
		
		/**
		 * Adding CRUD buttons
		 */
		c.insets = new Insets(10, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 9;
		add(btnCreate, c);
		
		c.gridx = 0;
		c.gridy = 10;
		add(btnRead, c);
		
		c.gridx = 0;
		c.gridy = 11;
		add(btnUpdate, c);
		
		c.gridx = 0;
		c.gridy = 12;
		add(btnDelete, c);
		
		/**
		 * Adding connect/disconnect button
		 */
		c.gridx = 0;
		c.gridy = 13;
		add(tbtnConnect, c);
		
	}
}
