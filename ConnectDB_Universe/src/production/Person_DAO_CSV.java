package production;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Person_DAO_CSV implements Person_DAO {

	private BufferedReader fileReader = null;
	
	@Override
	public void connect()
	{
        try
        {
        	fileReader = new BufferedReader(new FileReader("Persons.csv"));
		}
        catch (FileNotFoundException e)
        {
			e.printStackTrace();
		}
	}

	@Override
	public void disconnect()
	{ 
        try
        {
			fileReader.close();
		}
        catch (IOException e)
        {
			e.printStackTrace();
		}
	}

	@Override
	public void create(Person p)
	{
		try
		{
			FileWriter writer = new FileWriter("Persons.csv", true);
			 
			writer.append(String.valueOf(p.getId()));
			writer.append(',');
			writer.append(p.getFirstName());
			writer.append(',');
			writer.append(p.getLastName());
			writer.append(',');
			writer.append(String.valueOf(p.getAge()));
			writer.append('\n');
 
			writer.flush();
			writer.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Person> read()
	{
		try
		{
			fileReader = new BufferedReader(new FileReader("Persons.csv"));
		}
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		
		ArrayList<Person> persons = new ArrayList<Person>();
		String line = "";
		
        try
        {
			while ((line = fileReader.readLine()) != null)
			{
			    String[] tokens = line.split(",");
			    
			    Person p = new Person();

				p.setId(Integer.valueOf(tokens[0]));
				p.setFirstName(tokens[1]);
				p.setLastName(tokens[2]);
				p.setAge(Integer.valueOf(tokens[3]));

				persons.add(p);
			}
			
		}
        catch (IOException e)
        {
			e.printStackTrace();
		}
		
		return persons;
	}

	@Override
	public void update(Person p)
	{
		File inputFile = new File("Persons.csv");
		File tempFile = new File("myTempFile.txt");

		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			String lineToUpdate = p.getId()+"," + p.getFirstName() + "," + p.getLastName() + "," + p.getAge();
			String currentLine;

			while((currentLine = reader.readLine()) != null)
			{
				String[] tokens = currentLine.split(",");
				
			    if(tokens[0].equals(String.valueOf(p.getId())))
			    {
			    	writer.write(lineToUpdate + System.getProperty("line.separator"));
			    	continue;
			    }
			    
			    writer.write(currentLine + System.getProperty("line.separator"));
			}
			
			writer.close(); 
			reader.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		tempFile.renameTo(inputFile);
	}

	@Override
	public void delete(Person p)
	{
		File inputFile = new File("Persons.csv");
		File tempFile = new File("myTempFile.txt");

		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			String lineToRemove = p.getId()+"," + p.getFirstName() + "," + p.getLastName() + "," + p.getAge();
			String currentLine;

			while((currentLine = reader.readLine()) != null)
			{
			    // trim newline when comparing with lineToRemove
			    String trimmedLine = currentLine.trim();
			    
			    if(trimmedLine.equals(lineToRemove))
			    	continue;
			    
			    writer.write(currentLine + System.getProperty("line.separator"));
			}
			
			writer.close(); 
			reader.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		tempFile.renameTo(inputFile);
	}

}
