import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class SliderDialog extends JOptionPane {

		public SliderDialog()
		{
			final JSlider sizeSlider = new JSlider (1,20,1);
			sizeSlider.setMajorTickSpacing(5);
			sizeSlider.setMinorTickSpacing(1);
			sizeSlider.setSnapToTicks(true);
			sizeSlider.setPaintTicks(true);
			sizeSlider.setPaintLabels(true);
			setInputValue(1);
			
			ChangeListener cListener = new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent arg0) {
					setInputValue(new Integer(sizeSlider.getValue()));
				}
			};
			sizeSlider.addChangeListener(cListener);
			
			setMessage(new Object[] {"Size", sizeSlider});
			setOptionType(JOptionPane.OK_CANCEL_OPTION);
			JDialog d = createDialog(null, "My Slider");
			d.setVisible(true);
			
		}
		
}
