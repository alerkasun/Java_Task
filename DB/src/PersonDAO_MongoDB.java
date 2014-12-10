
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;


public class PersonDAO_MongoDB implements PersonDAOInterface
{
	private DBCollection personCollection = null;
	private MongoClient mongo = null;
	@Override
	public void connect() 
	{
		try 
		{
			mongo = new MongoClient("localhost",27017);
			DB db = mongo.getDB("111DB");
			personCollection = db.getCollection("persons");
			if (personCollection == null)
			{
				personCollection = db.createCollection("persons", null);
			}
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void disConnect()
	{
		mongo.close();
	}

	@Override
	public void createPerson(Person person)
	{
		person.setId(getId());
		personCollection.insert(toDBObject(person));
	}
	
	public Person fromDBObject(DBObject doc)
	{
		Person p = new Person();
		
		p.setId((Integer) doc.get("id"));
		p.setFName((String) doc.get("first_name"));
		p.setLName((String) doc.get("last_name"));
		p.setAge((Integer) doc.get("age"));
		p.setIdStreet((Integer) doc.get("id_street"));
		
		return p;
	}
	
	public BasicDBObject toDBObject(Person person)
	{
		BasicDBObject d = new BasicDBObject();
		
		d.put("id",(Integer) person.getId());
		d.put("first_name", person.getFName());
		d.put("last_name", person.getLName());
		d.put("age",(Integer) person.getAge());
		d.put("id_street",(Integer) person.getIdStreet());
		
		return d;
	}

	@Override
	public ArrayList<Person> readPersons()
	{
		ArrayList<Person> personList = new ArrayList<Person>();
		
		DBCursor dbcursor = personCollection.find();
		while(dbcursor.hasNext())
		{
			DBObject dbo = dbcursor.next();
			personList.add(fromDBObject(dbo));
			
		}
	
		
		return personList;
	}
	
	private int getId()
	{
		int id = 0;
		
		DBCursor dbcursor = personCollection.find();
		
		while(dbcursor.hasNext())
		{
			DBObject dbo = dbcursor.next();
			int n = (Integer) dbo.get("id");
			if(id < n)
			{
				id = n;
			}
		}
		
		return id+1;
	}

	@Override
	public void updatePerson(Person person)
	{
		BasicDBObject fobj = new BasicDBObject();
		fobj.put("id",person.getId());
		
		DBCursor dbcursor = personCollection.find(fobj);
		
		while(dbcursor.hasNext())
		{
			personCollection.update(dbcursor.next(), toDBObject(person));
		}
	}

	@Override
	public void deletePerson(Person person) 
	{
		BasicDBObject fobj = new BasicDBObject();
		fobj.put("id",person.getId());
		
		DBCursor dbcursor = personCollection.find(fobj);
		while(dbcursor.hasNext())
		{
			personCollection.remove(dbcursor.next());
		}
	}

}
