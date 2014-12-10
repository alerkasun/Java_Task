package com.ita;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class frameDB extends JFrame {
	
	private PersonDAO pD = null;
	private JTextField idTF = null;
	private JTextField fNameTF = null;
	private JTextField lNameTF = null;
	private JTextField ageTF = null;
	private JTextField idStrTF = null;

	public frameDB() throws SQLException
	{
		pD = new PersonDAO();
		
		setBounds(300,300,90,500);
		setLayout(null);
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		idTF = new JTextField();
		idTF.setBounds(20,10,300,20);
		
		fNameTF = new JTextField();
		fNameTF.setBounds(20, 40, 90, 20);
		
		lNameTF = new JTextField();
		lNameTF.setBounds(20, 70, 90, 20);
		
		ageTF = new JTextField();
		ageTF.setBounds(20, 100, 30, 20);
		
		idStrTF = new JTextField();
		idStrTF.setBounds(20, 130, 30, 20);
		
		JButton createB = new JButton("Create");
		createB.setBounds(20,160,90,20);
		
		JButton readB = new JButton("Read");
		readB.setBounds(20, 190, 90, 20);
		
		JButton updateB = new JButton("Update");
		updateB.setBounds(20,220, 90, 20);
		
		JButton deleteB = new JButton("Delete");
		deleteB.setBounds(20, 250, 90, 20);
		
		BActionListener bAL = new BActionListener();
		
		createB.addActionListener(bAL);
		readB.addActionListener(bAL);
		updateB.addActionListener(bAL);
		deleteB.addActionListener(bAL);
		
		add(idTF);
		add(fNameTF);
		add(lNameTF);
		add(ageTF);
		add(idStrTF);
		
		add(createB);
		add(readB);
		add(updateB);
		add(deleteB);
		
		setVisible(true);
		
		
	}
	
	public void actionSelect(String btnStr) throws SQLException
	{
		
		if (btnStr.equals("Create"))
		{
			pD.writePerson(fNameTF.getText(), lNameTF.getText(), Integer.valueOf(ageTF.getText()), Integer.valueOf(idStrTF.getText()));
		}
		if(btnStr.equals("Read"))
		{
			ResultSet rs = pD.readPerson(Integer.valueOf(idTF.getText()));
			while (rs.next())
			{
				fNameTF.setText(rs.getString("first_name"));
				lNameTF.setText(rs.getString("last_name"));
				ageTF.setText(rs.getString("age"));
				idStrTF.setText(rs.getString("id_street"));
			}
		}
		if(btnStr.equals("Update"))
		{
			pD.updatePerson(Integer.valueOf(idTF.getText()),fNameTF.getText(), lNameTF.getText(), Integer.valueOf(ageTF.getText()), Integer.valueOf(idStrTF.getText()));
		}
		if(btnStr.equals("Delete"))
		{
			pD.deletePerson(Integer.valueOf(idTF.getText()));
		}
	}
	
	class BActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			try {
				actionSelect(e.getActionCommand());
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		
	}
}
