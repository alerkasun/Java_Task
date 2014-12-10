package production;
import java.util.ArrayList;


public interface Person_DAO
{
	public void connect();
	public void disconnect();
	public void create(Person p);
	public ArrayList<Person> read();
	public void update(Person p);
	public void delete(Person p);
}
