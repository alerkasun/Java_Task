import java.awt.Dimension;
import java.awt.Toolkit;


public class MainDrawer {

	public static void main(String[] args)
	{
		DrawerMFrame mFrame = new DrawerMFrame();
		Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize ();
		mFrame.setBounds(sSize.width/2-270,sSize.height/2-250,500,440);

	}

}
