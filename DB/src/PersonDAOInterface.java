import java.util.ArrayList;


public interface PersonDAOInterface
{
	public void connect();
	public void disConnect();
	public void createPerson(Person person);
	public ArrayList<Person> readPersons();
	public void updatePerson(Person person);
	public void deletePerson(Person person);

}
