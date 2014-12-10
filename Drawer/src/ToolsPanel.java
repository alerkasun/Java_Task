import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ToolsPanel extends JPanel 
{
	//public DrawPanel dP = null;
	public String[] btArray = null;
	private JSlider sizeSlider = null;
	private DrawPanel dPanelDelegate = null;
	
	
	public ToolsPanel()
	{
		setBounds(0,0,500,40);
		setBackground(Color.gray);
		setLayout(null);
		
		sizeSlider = new JSlider(1, 20, 1);
		sizeSlider.setPaintTicks(true);
		sizeSlider.setBounds(10, 5, 100, 30);
		sizeSlider.setPaintTicks(true);
		sizeSlider.setMinorTickSpacing(2);
		sizeSlider.setForeground(Color.white);
		
		sizeSlider.setSnapToTicks(true);
		sizeSlider.addChangeListener(new sliderListener());
		
		add(sizeSlider);
		
		JButton colorBtn = new JButton("Color");
		
		colorBtn.setBounds(115,5,75,30);
		
		BListener bListener = new BListener();
		colorBtn.addActionListener(bListener);
		add(colorBtn);	
	}
	
	public void setdPanel(DrawPanel dP)
	{
		dPanelDelegate = dP;	
	}
	
	private void actionSelect (ActionEvent e)
	{
		String aC = e.getActionCommand();

		if(aC.equals("Color"))
		{
			dPanelDelegate.setColor();	 
		}
	}
	
	private void changeSize ()
	{
		dPanelDelegate.size = sizeSlider.getValue();
	}
	class sliderListener implements ChangeListener
	{

		@Override
		public void stateChanged(ChangeEvent e) 
		{
			changeSize();
		}
		
	}
	
	class BListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			actionSelect(e);
		}
	}
	
	
}
