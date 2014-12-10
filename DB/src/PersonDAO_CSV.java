//
//	import java.io.FileWriter;
//	import java.io.IOException;
//	 
//	public class PersonDAO_CSV
//	{
//	   public static void main(String [] args)
//	   {
//		   generateCsvFile("/home/valeriy//test.csv"); 
//	   }
//	 
//	   private static void generateCsvFile(String sFileName)
//	   {
//		try
//		{
//		    FileWriter writer = new FileWriter(sFileName);
//	 
//		    writer.append("DisplayName");
//		    writer.append(',');
//		    writer.append("Age");
//		    writer.append('\n');
//	 
//		    writer.append("MKYONG");
//		    writer.append(',');
//		    writer.append("26");
//	            writer.append('\n');
//	 
//		    writer.append("YOUR NAME");
//		    writer.append(',');
//		    writer.append("29");
//		    writer.append('\n');
//	 
//		    //generate whatever data you want
//	 
//		    writer.flush();
//		    writer.close();
//		}
//		catch(IOException e)
//		{
//		     e.printStackTrace();
//		} 
//	    }
//	}




import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;


public class PersonDAO_CSV implements PersonDAOInterface
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
	}
	
//	public Person fromDBObject(DBObject doc)
//	{
//		Person p = new Person();
//		
//		p.setId((Integer) doc.get("id"));
//		p.setFName((String) doc.get("first_name"));
//		p.setLName((String) doc.get("last_name"));
//		p.setAge((Integer) doc.get("age"));
//		p.setIdStreet((Integer) doc.get("id_street"));
//		
//		return p;
//	}
//	
//	public BasicDBObject toDBObject(Person person)
//	{
//		BasicDBObject d = new BasicDBObject();
//		
//		d.put("id",(Integer) person.getId());
//		d.put("first_name", person.getFName());
//		d.put("last_name", person.getLName());
//		d.put("age",(Integer) person.getAge());
//		d.put("id_street",(Integer) person.getIdStreet());
//		
//		return d;
//	}
//
//	@Override
//	public ArrayList<Person> readPersons()
//	{
//		ArrayList<Person> personList = new ArrayList<Person>();
//		
//		
//		System.out.println(personCollection.find());
//		
//		
//		DBCursor cursorDoc = personCollection.find();
//		while (cursorDoc.hasNext()) {
//			System.out.println(cursorDoc.next());
//		}
//		return personList;
//	}
	
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
