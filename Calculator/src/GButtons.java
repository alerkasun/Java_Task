import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GButtons extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField textField;
	JButton btn1 = null;
	
	public GButtons(JTextField textField) {
		this.textField = textField;
		setLayout(new GridLayout(3, 3));
		add(button(1));
		add(button(2));
		add(button(3));
		add(button(4));
		add(button(5));
		add(button(6));
		add(button(7));
		add(button(8));
		add(button(9));
	}
	
	private JButton button(int value) {
		JButton button = new JButton(String.valueOf(value));
		button.addActionListener(buttonAction(value));
		return button;
	}
	
	private ActionListener buttonAction(final int value) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)  {
				textField.setText(textField.getText() + value);
			}
		};
	}
	
}
