import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MainMenu extends JMenuBar {
	
	private  DrawPanel dPanelDelegate = null;
	
	public JMenuBar MainMenu()
	{
		
		AListener aL = new AListener();
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem colorSel = new JMenuItem("Select color");
		fileMenu.add(colorSel);
		
		JMenuItem exitItem = new JMenuItem("Exit");
		fileMenu.add(exitItem);
		
		JMenu editMenu = new JMenu("Edit");
		
		JMenuItem sizeItem = new JMenuItem("Change line widht");
		editMenu.add(sizeItem);
		
		sizeItem.addActionListener(aL);
		colorSel.addActionListener(aL);
		
		JMenuBar mBar = new JMenuBar();
		mBar.add(fileMenu);
		mBar.add(editMenu);
		
		return mBar;
		
	}
	public void itemSelect(String aC)
	{
		if (aC.equals("Select color"))
		{
			dPanelDelegate.setColor();
		}
		if (aC.equals("Change line widht"))
		{
			dPanelDelegate.setLineSize();
		}
		if (aC.equals("Exit"))
		{
			System.exit(0);
		}
	}
	
	public void setdPanel(DrawPanel dP)
	{
		dPanelDelegate = dP;	
	}

	class AListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String aC = e.getActionCommand();
			itemSelect(aC);
		}
		
	}

}
