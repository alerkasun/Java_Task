import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	public JComboBox comboBox = null;
	public Commands comm = null;


	public ButtonPanel(Commands comm)
	{
		setBounds(10, 220, 480, 70);
		setBackground(Color.gray);
		setLayout(null);

		String[] cBIntems = {"MySQL DataBase","MongoDataBase","H2 DataBase","MongoDB JSON", "MongoDB CSV"};
		comboBox = new JComboBox(cBIntems);
		comboBox.setBounds(10, 10, 190, 25);
		comboBox.addActionListener(comm.dbchangeListener);

		JButton connectButton =    new JButton("Connect");
		JButton disconnectButton = new JButton("Disconnect");
		JButton writeButton =      new JButton("Write");
		JButton readButton =       new JButton("Read");
		JButton updateButton =     new JButton("Update");
		JButton deleteButton =     new JButton("Delete");

		connectButton.   setBounds(8,35,100,25);
		disconnectButton.setBounds(101,35,100,25);
		writeButton.     setBounds(280, 10, 100, 25);
		readButton.      setBounds(373, 10, 100, 25);
		updateButton.    setBounds(280, 35, 100, 25);
		deleteButton.    setBounds(373, 35, 100, 25);

		connectButton.     addActionListener(comm.connectListener);
		disconnectButton.  addActionListener(comm.disconnectListener);
	 	writeButton.       addActionListener(comm.writeListener);
		readButton.  	   addActionListener(comm.readListener);
		updateButton.	   addActionListener(comm.updateListener);
		deleteButton.	   addActionListener(comm.deleteListener);

		add(connectButton);
		add(disconnectButton);
		add(writeButton);
		add(readButton);
		add(updateButton);
		add(deleteButton);
		add(comboBox);

		setVisible(true);
	}


}
