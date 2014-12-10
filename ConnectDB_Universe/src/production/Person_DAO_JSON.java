package production;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

public class Person_DAO_JSON implements Person_DAO
{

	private JSONParser parser = null;
	
	@Override
	public void connect()
	{
		parser = new JSONParser();
	}

	@Override
	public void disconnect()
	{

	}

	@Override
	public void create(Person p) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Person> read()
	{		
		Object obj = null;
		ArrayList<Person> persons = new ArrayList<Person>();
		
		try
		{
			obj = parser.parse(new FileReader("Persons.json"));
			String str = obj.toString();
			
			JSONObject pers = (JSONObject) JSONValue.parse(str);
			JSONArray array = (JSONArray) pers.get("persons");

			for(int i = 0; i < array.size(); i++)
			{
				Person p = new Person();
				JSONObject o = (JSONObject) array.get(i);

				p.setId(Integer.valueOf(o.get("id").toString()));
				p.setFirstName(o.get("firstName").toString());
				p.setLastName(o.get("lastName").toString());
				p.setAge(Integer.valueOf(o.get("age").toString()));

				persons.add(p);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return persons;
	}

	@Override
	public void update(Person p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Person p) {
		// TODO Auto-generated method stub

	}

}
