import java.awt.Button;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	JButton btn1 = null;
	private final JTextField txt1;
	
	public GPanel() 
	{
		setLayout(null);
		txt1 = new JTextField();
		add(txt1);
		txt1.setBounds(10, 50, 250, 22);
	}
	
	public JTextField getJTextField() {
		return txt1;
	}
}