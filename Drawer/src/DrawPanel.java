import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

import javax.swing.JColorChooser;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;


public class DrawPanel extends JPanel {
	
	private int x = 0;
	private int y = 0;
	private Color color = null;
	public int size = 0;
	
	
	public DrawPanel()
	{
		setBounds(30,40,470,400);
		setLayout(null);	
		
		color = Color.black;
		size = 1;
		
		setBackground(Color.white);
		MListener mL = new MListener();
		addMouseListener(mL);
		addMouseMotionListener(mL);
	}
	
	public void draw(int nX, int nY)
	{	
		Graphics g = this.getGraphics();
		Graphics2D gr = (Graphics2D) g;
		
		gr.setColor(color);
		gr.setStroke(new BasicStroke(size));
		gr.draw(new Line2D.Float(x, y, nX, nY));
		x = nX;
		y = nY;
	}

	public void setColor()
	{
		Color c =  JColorChooser.showDialog(null,"Choose Background Color",Color.black);
		if(c != null)
		{
			color = c;
		}
	}
	
	public void setLineSize()
	{
		SliderDialog sD = new SliderDialog();
		size = ((Integer) sD.getInputValue());;
	}
	
	public void popupM ()
	{
		PopupListener pL = new PopupListener();
		
		JPopupMenu jpM = new JPopupMenu();
		JMenuItem selColor = new JMenuItem("Select Color");
		selColor.addActionListener(pL);
		
		JMenuItem selSize = new JMenuItem("Select Line Width");
		selSize.addActionListener(pL);
		
		jpM.add(selSize);
		jpM.addSeparator();
		jpM.add(selColor);
		
		jpM.show(DrawPanel.this, x, y);
	}
	
	public void popupSelect(ActionEvent e)
	{
		String eStr = e.getActionCommand();
		
		if (eStr.equals("Select Color"))
		{
			setColor();
		}
		if (eStr.equals("Select Line Width"))
		{
			setLineSize();
		}
	}
	
	private class MListener implements MouseListener, MouseMotionListener
	{

		@Override
		public void mouseClicked(MouseEvent arg0) 
		{
		}

		@Override
		public void mouseEntered(MouseEvent arg0) 
		{	
		}

		@Override
		public void mouseExited(MouseEvent arg0) 
		{	
		}

		@Override
		public void mousePressed(MouseEvent e) 
		{	
			x = e.getX();
			y = e.getY();
			if (e.getModifiers() == InputEvent.BUTTON3_MASK)
			{
			popupM();
			}
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) 
		{		
		}

		@Override
		public void mouseDragged(MouseEvent e) 
		{	
			if (e.getModifiers() != InputEvent.BUTTON3_MASK)
			{
				  draw(e.getX(),e.getY());
			}
		  
		}

		@Override
		public void mouseMoved(MouseEvent arg0) 
		{	
		}
		
	}

	private class PopupListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
		popupSelect(e);
			
		}
	}

}
