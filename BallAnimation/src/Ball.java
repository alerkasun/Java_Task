import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Random;

import javax.swing.JPanel;


public class Ball extends JPanel
{
	private Point point = new Point(20,10);
	private Color color = null;
	
	public Ball(Point p)
	{
		setLocation(p);
		setSize(40,40);
		setRandomColor();
		setRandomDuration();
	}
	private void setRandomColor()
	{
		Random rdm = new Random();
		Color color = new Color(rdm.nextInt(256),rdm.nextInt(256),rdm.nextInt(256));
		this.color = color;
	}
	
	private void setRandomDuration()
	{
		Random rnd = new Random();
		int n = rnd.nextInt(4);
		int rD = rnd.nextInt(26)+5;
		switch(n)
		{
			case 0: point.x =  rD; point.y =  rD; break;
			case 1: point.x = -rD; point.y =  rD; break;
			case 2: point.x = -rD; point.y = -rD; break;
			case 3: point.x =  rD; point.y = -rD; break;
			default: break;
		}
	}
	
	@Override
	public void paint(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(color);
		g2d.fillOval(1, 1, 38, 38);	
	}
	
	public void go()
	{
		Point p = getLocation();
		p.x = point.x + p.x;
		p.y = point.y + p.y;
		
		setLocation(p);
		
		if(p.x+40 >= 500 || p.x <= 1)
		{
			point.x = -point.x;
		}
		if(p.y+60 >= 500 || p.y <= 1)
		{
			point.y = -point.y;
		}
	}
	

}
