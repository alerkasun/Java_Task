import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


public class TablePanel extends JPanel {
	
	public JTable table = null; 
	public Commands comm = null;
	public PersonTableModel personTableModel = null;
	
	public TablePanel()
	{
		setBounds(10,10,480,200);

		personTableModel = new PersonTableModel();	
		table = new JTable(personTableModel);
		JScrollPane pane = new JScrollPane(table);
		
		
		add(pane);
	}	

}