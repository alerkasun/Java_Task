import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcPanel  extends JPanel
{
	public JTextField txtN1 = null;
	public JTextField txtOp = null;	
	public JTextField txtN2 = null;	
	public JTextField txtRes = null;	
	public JButton 	  btnGo = null;

	
	public CalcPanel() {
		setLayout(null);
		txtN1 = new JTextField();
		txtOp = new JTextField();
		txtN2 = new JTextField();
		txtRes = new JTextField();
		btnGo = new JButton("Go");
		
		txtN1. setBounds(10, 10,  120, 20);
		txtOp. setBounds(90, 40,  40, 20);
		txtN2. setBounds(10, 70,  120, 20);
		txtRes.setBounds(10, 100, 120, 20);
		btnGo. setBounds(10, 130, 120, 20);
		
		add(txtN1);
		add(txtOp);
		add(txtN2);
		add(txtRes);
		add(btnGo);
		
		btnGo.addActionListener( new CalcListener() );
		
	}

	private class CalcListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int n1 = Integer.parseInt(txtN1.getText());
			int n2 = Integer.parseInt(txtN2.getText());
			String op = txtOp.getText();
			int res = CalcAPI.calc(n1, n2, op);
			txtRes.setText(Integer.toString(res));
		}
	}
}
