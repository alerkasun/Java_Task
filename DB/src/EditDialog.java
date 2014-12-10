import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class EditDialog extends JDialog
{
	public Commands comm = null;
	public JPanel panel;
	
	private String query = "";
	private int id = 0;
	private JTextField fNameField = null;
	private JTextField lNameField = null;
	private JTextField ageField = null;
	private JTextField idStreetField = null;
	private Person person = null;
	
	public EditDialog()
	{	
		setBounds(300,300,200,200);
        setModal(true);
        setResizable(false);
        setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void addTable(final String command, Person person)
	{ 
		this.person = person;
        panel = new JPanel();
        setTitle(command);
        add(panel);
        panel.setBounds(0, 0, 200, 180);
        panel.setLayout(null);
         
        JButton ok = new JButton("OK");
        ok.setBounds(10, 150, 70, 25);
        panel.add(ok);
        ok.addActionListener(new ActionListener() 
        {
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					if(command.equals("Write"))
					{
						write();
					}
					if(command.equals("Update"))
					{
						update();
					}
					if(command.equals("Delete"))
					{
						delete();
					}
					dispose();
			 	}
	    });
         
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(82, 150, 70, 25);
        cancel.addActionListener(new ActionListener() {
			
        	@Override
        	public void actionPerformed(ActionEvent e) 
			{
				panel = null;
				query = "";
				dispose();
			}
		});
        
	   panel.add(cancel);
	     
	   fNameField =    new JTextField();
	   lNameField =    new JTextField();
	   ageField = 	   new JTextField();
	   idStreetField = new JTextField();
	   
	   fNameField.   setBounds(10,10,100,25);
	   lNameField.   setBounds(10,35,100,25);
	   ageField.	 setBounds(10,70,50,25);
	   idStreetField.setBounds(10,105,50,25);
	   
	   if(command.equals("Update") || command.equals("Delete"))
	   {
		   showPerson(person);
	   }
	   
	   panel.add(fNameField);
	   panel.add(lNameField);
	   panel.add(ageField);
	   panel.add(idStreetField);
	}
	
	private void showPerson(Person person)
	{
		fNameField.setText(person.getFName());
		lNameField.setText(person.getLName());
		ageField.setText(String.valueOf(person.getAge()));
		idStreetField.setText(String.valueOf(person.getIdStreet()));
	}
	
 	public Person getPerson()
	{
		Person person = new Person();
		 
		person.setFName					  (fNameField.getText());
		person.setLName					  (lNameField.getText());
		person.setAge(Integer.valueOf	  (ageField.getText())); 
		person.setIdStreet(Integer.valueOf(idStreetField.getText())); 
		person.setId(this.person.getId());
		
		return person;
	}
	
	
	public void write()
	{
		person = getPerson();	
	}
	
	public void update()
	{
		person = getPerson();
	}
	
	public void delete()
	{
		
	}
}
