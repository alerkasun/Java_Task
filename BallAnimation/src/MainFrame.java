import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class MainFrame extends JFrame {
	
	public MainFrame()
	{
		Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize ();
		setBounds(sSize.width/2,sSize.height/2,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		Commands  commands =  new Commands();
		DrawPanel drawPanel = new DrawPanel(commands);
		
		commands.drawPanel = drawPanel;
		
		add(drawPanel);
		
		setVisible(true);
	}

}
