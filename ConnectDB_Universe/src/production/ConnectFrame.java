package production;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;


public class ConnectFrame extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ConnectFrame()
	{
		setTitle("Connect db");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/**
		 * Creating table panel
		 */
		TablePanel tablePanel = new TablePanel();
		
		/**
		 * Creating tool panel
		 */
		ToolPanel toolPanel = new ToolPanel(tablePanel.tableModel);
		
		/**
		 * Setting layout manager
		 */
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		/**
		 * Adding tool panel
		 */
		c.insets = new Insets(10, 10, 10, 10);
		c.gridx = 0;
		c.gridy = 0;
		add(toolPanel, c);
		
		/**
		 * Adding table panel
		 */
		c.insets = new Insets(10, 0, 10, 10);
		c.gridx = 1;
		c.gridy = 0;
		add(tablePanel, c);
		
		/**
		 * 
		 */
		pack(); 						
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
