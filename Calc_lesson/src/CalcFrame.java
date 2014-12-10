import java.awt.BorderLayout;
import javax.swing.JFrame;

public class CalcFrame extends JFrame 
{	
	public CalcFrame() 
	{
		setBounds(200, 150, 300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setContentPane(new CalcPanel() );
		setVisible(true);
	}
}
