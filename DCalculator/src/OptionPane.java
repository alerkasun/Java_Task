import javax.swing.JOptionPane;


public class OptionPane {

	public static void enterNumber()
	{
		int a = 0;
		int b = 0;
		String op = "";
		
		a = Integer.valueOf (JOptionPane.showInputDialog(null));
		b = Integer.valueOf (JOptionPane.showInputDialog(null));
		op = JOptionPane.showInputDialog(null);
		
	    JOptionPane.showMessageDialog(null, Operations.getRusult(a, b, op));
		
	}
}
