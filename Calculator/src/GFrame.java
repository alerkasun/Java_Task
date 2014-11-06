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
		setLayout(new GridLayout(2, 1));
		
		Box box = Box.createVerticalBox();
		GPanel panel = new GPanel();
		box.add(panel);
		box.add(new GButtons(panel.getJTextField()));
		add(box);
		setVisible(true);
	}
}