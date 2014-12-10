package production;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;


public class Person_DAO_Mongo implements Person_DAO
{

	private MongoClient 	mongo 	= null;
	private DB 				db 		= null;
	private DBCollection 	coll	= null;

	@Override
	public void connect()
	{
		try
		{
			mongo = new MongoClient( "localhost" , 27017 );
			db = mongo.getDB("resident");
			coll = db.getCollection("Persons");
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void disconnect()
	{
		
	}

	@Override
	public void create(Person p)
	{
		BasicDBObject document = new BasicDBObject();
		
		document.put("Id", p.getId());
		document.put("FirstName", p.getFirstName());
		document.put("LastName", p.getLastName());
		document.put("Age", p.getAge());
		
		coll.insert(document);
	}

	@Override
	public ArrayList<Person> read()
	{
		ArrayList<Person> persons = new ArrayList<>();
		
		DBCursor cursor = coll.find();

		while(cursor.hasNext())
		{
			BasicDBObject dbObject = (BasicDBObject)cursor.next(); 
			Person p = new Person();

			p.setId(dbObject.getInt("Id"));
			p.setFirstName(dbObject.getString("FirstName"));
			p.setLastName(dbObject.getString("LastName"));
			p.setAge(dbObject.getInt("Age"));
			
			persons.add(p);
		}

		return persons;
	}

	@Override
	public void update(Person p)
	{
		BasicDBObject query = new BasicDBObject();
		query.put("Id", p.getId());
	 
		BasicDBObject newDocument = new BasicDBObject();
	 
		newDocument.put("Id", p.getId());
		newDocument.put("FirstName", p.getFirstName());
		newDocument.put("LastName", p.getLastName());
		newDocument.put("Age", p.getAge());
		
		BasicDBObject updateObj = new BasicDBObject();
		updateObj.put("$set", newDocument);
	 
		coll.update(query, updateObj);
	}

	@Override
	public void delete(Person p)
	{
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("Id", p.getId());
	 
		coll.remove(searchQuery);
	}
}
