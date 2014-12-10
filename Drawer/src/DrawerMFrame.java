import java.awt.Color;
import java.awt.MenuBar;

import javax.swing.JFrame;


public class DrawerMFrame extends JFrame {

	public DrawerMFrame()
	{
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
		ToolsPanel tPanel = new ToolsPanel();
		DrawPanel dPanel = new DrawPanel();
		SidePanel sPanel = new SidePanel();
		MainMenu mMenu = new MainMenu();
		this.setJMenuBar(mMenu.MainMenu());
		
		tPanel.setdPanel(dPanel);
		sPanel.setdPanel(dPanel);
		mMenu.setdPanel(dPanel);
		
		add(dPanel);
		add(tPanel);
		add(sPanel);
		setVisible(true);
	}
	
	
}
