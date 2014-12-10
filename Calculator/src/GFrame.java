import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JFrame;


public class GFrame extends JFrame 
{
	public GFrame()
	{
		setTitle("Java Swing Calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 300, 500, 450);
		add( new GPanel() );
		setVisible(true);
	}
}