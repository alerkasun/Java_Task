

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DBConnect_PersonDialog extends JDialog
{
	JButton ok = new JButton("ok");
	JButton back = new JButton("back");
	static String query = "";
	JPanel panel;
	JTextField[] fields = {new JTextField(), new JTextField(), new JTextField(), new JTextField()};
	
	public static String getQuery()
	{
		return query;
	}
	
	public DBConnect_PersonDialog()
	{
		setModal(true);
		setLayout(null);
        setBounds(300, 300, 240, 240);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public Person getPerson()
	{
		Person p = new Person();
		
		return p;
	}
	
	public void addPanel(final String command)
	{
		panel = new JPanel();
		add(panel);
		panel.setBounds(0, 0, 240, 240);
		panel.setLayout(null);
		
		ok.setBounds(30, 160, 80, 30);
		back.setBounds(130, 160, 80, 30);
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(command)
				{
				case "Create" :
					create();
					break;
				case "Update" :
					update();
					break;
				case "Delete" :
					delete();
					break;
				}
				
				//Commands.execute();
				dispose();
			}
		});
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});
		
		panel.add(ok);
		panel.add(back);
		
		for (int i = 0; i < fields.length; ++i)
			fields[i].setBounds(30, 30 + 30 * i, 180, 30);
			
		if (command.equals("Create"))
		{
			for (JTextField text : fields)
				panel.add(text);
		} else if (command.equals("Update"))
		{
			for (int i = 0; i < 2; ++i)
				panel.add(fields[i]);
		} else 
			panel.add(fields[0]);
		
		
	}
	
	public void create()
	{
		int id = Integer.parseInt(fields[0].getText());
		String firstname = fields[1].getText();
		String lastname = fields[2].getText();
		int age = Integer.parseInt(fields[3].getText());
		
		query = "INSERT INTO persons VALUES ("
		+ id + ", '" + firstname + "', '" + lastname + "', " + age + ", 1);";
		
		System.out.println(query);
	}
	
	public void update()
	{
		String set = fields[0].getText();
		String condition = fields[1].getText();
		
		query = "UPDATE persons SET " + set + " WHERE " + condition + ";";
	}
	
	public void delete()
	{
		String condition = fields[0].getText();
		
		query = "DELETE FROM persons WHERE " + condition + ";";
	}
}
