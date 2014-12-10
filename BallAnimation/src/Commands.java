import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import org.w3c.dom.events.MouseEvent;


public class Commands {
	
	public MouseListener mouseListener = new MouseListener();
	public TimerListener timerListener = new TimerListener();
	public DrawPanel drawPanel = null;
	
	public Commands()
	{
	}
	
	class MouseListener implements java.awt.event.MouseListener
	{

		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) 
		{	
		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent e)
		{	
		}

		@Override
		public void mouseExited(java.awt.event.MouseEvent e)
		{		
		}

		@Override
		public void mousePressed(java.awt.event.MouseEvent e) 
		{		
			drawPanel.add(new Ball(e.getPoint()));
		}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) 
		{
		}
		
	}

	class TimerListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			for(Component comp : drawPanel.getComponents())
			{
				Ball bl = (Ball) comp;
				bl.go();
				bl.repaint();
			}
		}
		
	}
}
