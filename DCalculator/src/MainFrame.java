import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainFrame extends JFrame {
	
	public static JPanel sPanel = null;
	public static JPanel bPanel = null;
	public static JPanel oPanel = null;
	public static JTextField rField = null;
	
	public static int a = 0;
	public static String operation = "";
	
	public MainFrame() 
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize ();
		setBounds(sSize.width/2-195, sSize.height/2-205, 390, 410);
		setResizable(false);
		setLayout(null);
			
		sPanel = new JPanel();
		bPanel = new JPanel();
		oPanel = new JPanel();
		rField = new JTextField();
		JPanel mPanel = new JPanel();
		Font font1 = new Font("SansSerif", Font.BOLD, 30);
			
		sPanel.setBounds(0,  0,  390, 90);
		bPanel.setBounds(0,  90, 230, 300);
		oPanel.setBounds(230,90, 160, 300);
		mPanel.setBounds(0,  0,  390, 410);
		rField.setBounds(20, 20, 350, 50);
		
		bPanel.setBackground(Color.gray);
		oPanel.setBackground(Color.gray);
		
		rField.setText("0");
		rField.setFont(font1);
		
		setContentPane(mPanel);
		
		mPanel.setLayout(null);
		bPanel.setLayout(null);
		oPanel.setLayout(null);
		sPanel.setLayout(null);
		
		mPanel.add(sPanel);
		mPanel.add(bPanel);
		mPanel.add(oPanel);
		
		sPanel.add(rField);
		
		oPanelButtons();
		bPanelButtons();
		
		
		setVisible(true);
	}
	
	public static void actionParse (String act)
	{
		if (act.equals("+") || act.equals("-") || act.equals("*") || act.equals("/") || act.equals("=") || act.equals("MC"))
		{
			actionSelect(act);
			return;
		} 
		else
		{
			writeNumber(act);
		}
	}
	
	public static void writeNumber (String n)
	{
		if (rField.getText().equals("0"))
		{
			rField.setText(""+n);
			return;
		} 
			rField.setText(rField.getText()+n);
	}
	
	public static void actionSelect (String act)
	{
		if (act.equals("MC"))
		{
			a = 0;
			operation = "";
			rField.setText("0");
			return;
		}
		if (act.equals("="))
		{
			if (operation.equals(""))
			{
				return;
			}
			
			int b = Integer.valueOf(rField.getText());
			int result = Operations.getRusult(a, b, operation);
			rField.setText(String.valueOf(result));
			a = result;
			operation = "";
			return;
		}
		operation = act;
		a = Integer.valueOf(rField.getText());
		rField.setText("0");
	}
	
	public static void oPanelButtons ()
	{
		int posX = 20;
		int posY = 230;
		for (int i=0; i<6;i++)
		{
			if (i == 0)
			{
				oPanel.add(createButton(posX,posY,50,120,"="));
				posY -=70;
			}
			if (i == 1)
			{
				oPanel.add(createButton(posX,posY,50,50,"*"));
				posX += 70;
			}
			if (i == 2)
			{
				oPanel.add(createButton(posX,posY,50,50,"/"));
				posX = 20;
				posY -= 70;
			}
			if (i == 3)
			{
				oPanel.add(createButton(posX,posY,50,50,"+"));
				posX += 70;
			}
			if (i == 4)
			{
				oPanel.add(createButton(posX,posY,50,50,"-"));
				posX = 20;
				posY -= 70;
			}	
			if (i == 5)
			{
				oPanel.add(createButton(posX,posY,50,120,"MC"));
				
			}
		}
	} 

	public static void bPanelButtons ()
	{
		int posX = 20;
		int posY = 230;
		
		for (int i=0; i<10;i++)
		{
			if (i == 0)
			{
				bPanel.add(createButton(posX,posY,50,120,String.valueOf(i)));
				posY= 160;
				continue;
			}
			bPanel.add(createButton(posX,posY,50,50,String.valueOf(i)));
			posX += 70;
			if (i == 3 || i == 6)
			{
				posY -= 70;
				posX = 20;
			}
		}
	}
	
	public static JButton createButton (int x, int y,int sW, int sH, final String n)
	{
	    final JButton btn = new JButton(String.valueOf(n));
		btn.setBounds(x, y, sH, sW);
		btn.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				actionParse (btn.getText());
			}
		});
		return btn;
	}	
}
