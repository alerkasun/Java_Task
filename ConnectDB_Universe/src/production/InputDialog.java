package production;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InputDialog extends JDialog implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Person_DAO pDAO	= null;
	private String 	action 	= null;
	
	private JTextField tfId 		= null;
	private JTextField tfFirstName	= null;
	private JTextField tfLastName 	= null;
	private JTextField tfAge 		= null;
	
	public InputDialog(Person_DAO pDAO, String action, PersonTableModel model)
	{
		setModal(true);
		setTitle("Input dialog");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		/**
		 * Initialize variables
		 */
		this.pDAO 	= pDAO;
		this.action = action;

		/**
		 * Labels for input fields
		 */
		JLabel lId 			= new JLabel("ID");
		JLabel lName 		= new JLabel("Name");
		JLabel lLastName 	= new JLabel("Surname");
		JLabel lAge 		= new JLabel("Age");
		
		/**
		 * Making alignment them right
		 */
		lId.setHorizontalAlignment(SwingConstants.RIGHT);
		lName.setHorizontalAlignment(SwingConstants.RIGHT);
		lLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lAge.setHorizontalAlignment(SwingConstants.RIGHT);
		
		/**
		 * Input fields for setting persons data
		 */
		if(action == "Update" || action == "Delete")
		{
			tfId 		= new JTextField(Integer.toString(model.p.getId()));
			tfFirstName	= new JTextField(model.p.getFirstName());
			tfLastName 	= new JTextField(model.p.getLastName());
			tfAge 		= new JTextField(Integer.toString(model.p.getAge()));
		}
		else
		{
			tfId 		= new JTextField();
			tfFirstName	= new JTextField();
			tfLastName 	= new JTextField();
			tfAge 		= new JTextField();
		}

		/**
		 * "OK" and "Cancel" buttons
		 */
		JButton btnOk 		= new JButton("OK");
		JButton btnCancel 	= new JButton("Cancel");
		
		/**
		 * Setting action listeners for buttons
		 */
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);

		/**
		 * Setting layout manager
		 */
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		
		/**
		 * Adding labels and input fields to a panel
		 */
		c.insets = new Insets(10, 10, 0, 0);
		c.gridx = 0;
		c.gridy = 0;
		add(lId, c);

		c.insets = new Insets(10, 10, 0, 10);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		c.weightx = 1.0;
		add(tfId, c);

		c.insets = new Insets(10, 10, 0, 0);
		c.gridwidth = 1;
		c.weightx = 0.0;
		c.gridx = 0;
		c.gridy = 1;
		add(lName, c);

		c.insets = new Insets(10, 10, 0, 10);
		c.gridwidth = 2;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 1;
		add(tfFirstName, c);

		c.insets = new Insets(10, 10, 0, 0);
		c.gridwidth = 1;
		c.weightx = 0.0;
		c.gridx = 0;
		c.gridy = 2;
		add(lLastName, c);

		c.insets = new Insets(10, 10, 0, 10);
		c.gridwidth = 2;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 2;
		add(tfLastName, c);

		c.insets = new Insets(10, 10, 0, 0);
		c.gridwidth = 1;
		c.weightx = 0.0;
		c.gridx = 0;
		c.gridy = 3;
		add(lAge, c);

		c.insets = new Insets(10, 10, 0, 10);
		c.gridwidth = 2;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 3;
		add(tfAge, c);

		/**
		 * Adding buttons to a panel
		 */
		c.insets = new Insets(10, 10, 10, 0);
		c.gridwidth = 1;
		c.weightx = 0.0;
		c.gridx = 1;
		c.gridy = 4;
		add(btnOk, c);

		c.insets = new Insets(10, 10, 10, 10);
		c.gridx = 2;
		c.gridy = 4;
		add(btnCancel, c);

		/**
		 * 
		 */
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand() == "Cancel")
		{
			dispose();
			return;
		}

		Person p = new Person();

		p.setId(Integer.parseInt(
				tfId.getText()));		// Get person's id
		p.setFirstName(
				tfFirstName.getText());	// Get person's first name
		p.setLastName(
				tfLastName.getText());	// Get person's last name
		p.setAge(Integer.parseInt(
				tfAge.getText()));		// Get person's age

		switch(action)
		{
		case "Create":
			pDAO.create(p);
			break;

		case "Update":
			pDAO.update(p);
			break;
			
		case "Delete":
			pDAO.delete(p);
			break;
			
		default:
			break;
		}

		dispose();
		
	}
}
