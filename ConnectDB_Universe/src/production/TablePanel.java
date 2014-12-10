package production;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class TablePanel extends JPanel implements MouseListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonTableModel tableModel = null;

	private JTable table = null;

	public TablePanel()
	{
		/**
		 * Table model for a table
		 */
		tableModel = new PersonTableModel();

		/**
		 * Table for data outputting
		 */
		table = new JTable(tableModel);
		table.addMouseListener(this); 

		/**
		 * Scroll pane for our table
		 */
		JScrollPane scrollPane = new JScrollPane(table);

		/**
		 * Setting layout manager for panel
		 */
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.CENTER;

		/**
		 * Adding a scroll pane that contains our table
		 */
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 0;
		add(scrollPane);
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		int rowIndex = table.getSelectedRow();

		tableModel.p.setId(
				Integer.valueOf(
						table.getModel().getValueAt(rowIndex, 0).toString()));
		
		tableModel.p.setFirstName(
				table.getModel().getValueAt(rowIndex, 1).toString());
		
		tableModel.p.setLastName(
				table.getModel().getValueAt(rowIndex, 2).toString());
		
		tableModel.p.setAge(
				Integer.valueOf(
						table.getModel().getValueAt(rowIndex, 3).toString()));

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
