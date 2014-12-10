import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;


public class SidePanel extends JPanel 
{
	private DrawPanel dPanelDelegate = null;
	
	public SidePanel()
	{
		setBounds(0, 40, 30, 400);
		setBackground(Color.lightGray);
		setLayout(null);
		JButton colorButton = new JButton("C");
		JButton sizeButton = new JButton("S");
		
		BListener bList = new BListener();
		
		colorButton.setBounds(5,10,20,20);
		colorButton.addActionListener(bList);
		
		sizeButton.setBounds(5,40,20,20);
		sizeButton.addActionListener(bList);
		
		add(colorButton);
		add(sizeButton);
	}
	
	public void setdPanel(DrawPanel dP)
	{
		dPanelDelegate = dP;	
	}
	
	public void actionSelect(ActionEvent e)
	{
		String str = e.getActionCommand();
		if (str.equals("C"))
		{
			dPanelDelegate.setColor();
		}
		if (str.equals("S"))
		{
			dPanelDelegate.setLineSize();
		}
	}
	
	public class BListener implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			actionSelect(e);
		} 
	}
}
