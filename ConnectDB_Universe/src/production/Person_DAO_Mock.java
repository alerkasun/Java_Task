package production;


import java.util.ArrayList;

public class Person_DAO_Mock implements Person_DAO
{
	private ArrayList<Person> persons = new ArrayList<Person>();
	
	@Override
	public void connect()
	{
		Person p = new Person();
		
		p.setId(0);
		p.setFirstName("Evgeniy");
		p.setLastName("Pravda");
		p.setAge(23);
		
		persons.add(p);
		
		p = new Person();
		p.setId(1);
		p.setFirstName("Irina");
		p.setLastName("Galata");
		p.setAge(23);
		
		persons.add(p);
		
		p = new Person();
		p.setId(2);
		p.setFirstName("Alexandr");
		p.setLastName("Shegeda");
		p.setAge(23);
		
		persons.add(p);
		
		p = new Person();
		p.setId(3);
		p.setFirstName("Oleg");
		p.setLastName("Gudeichuk");
		p.setAge(23);
		
		persons.add(p);
		
		p = new Person();
		p.setId(4);
		p.setFirstName("Valera");
		p.setLastName("Sandulov");
		p.setAge(23);
		
		persons.add(p);
		
		p = new Person();
		p.setId(5);
		p.setFirstName("Max");
		p.setLastName("Max");
		p.setAge(23);
		
		persons.add(p);
		
		p = new Person();
		p.setId(6);
		p.setFirstName("Egor");
		p.setLastName("Bojko");
		p.setAge(23);
		
		persons.add(p);
	}

	@Override
	public void disconnect()
	{
		persons = null;
	}

	@Override
	public void create(Person p)
	{
		persons.add(p);
	}

	@Override
	public ArrayList<Person> read()
	{
		return persons;
	}

	@Override
	public void update(Person p)
	{
		persons.set(p.getId(), p);
	}

	@Override
	public void delete(Person p)
	{
		persons.remove(p.getId());
	}
}