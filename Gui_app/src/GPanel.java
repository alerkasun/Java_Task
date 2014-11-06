import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GPanel extends JPanel
{
	JButton btn1 = null;
	JTextField txt1 = null;
	
	public GPanel() 
	{
		setLayout(null);
		btn1 = new JButton("Батон 1");
		add(btn1);
		btn1.setBounds(10, 10, 120, 22);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				txt1.setText("Hello, World!!!");
			}
		});
		
		txt1 = new JTextField();
		add(txt1);
		txt1.setBounds(10, 40, 120, 22);
	}
}
