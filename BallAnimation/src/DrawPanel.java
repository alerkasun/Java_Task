
import java.awt.Color;

import javax.swing.Timer;
import javax.swing.JPanel;


public class DrawPanel extends JPanel 
{
	public DrawPanel(Commands comm)
	{
		this.setBounds(0, 0, 500, 500);
		this.setLayout(null);
		this.addMouseListener(comm.mouseListener);
		this.setBackground(Color.white);
		Timer timer = new Timer(50, comm.timerListener);
		timer.start();
	}	

}
