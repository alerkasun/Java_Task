package calc;

import javax.swing.JFrame;

public class GFrame extends JFrame 
{
	public GFrame()
	{
		setTitle("Ìîÿ ïåðâàÿ ÃÓÈ àïïà!!!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 300, 500, 450);
		add( new GPanel() );
		setVisible(true);
	}
}