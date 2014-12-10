package production;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Person_DAO_XML implements Person_DAO {

	private DocumentBuilder db 	= null;
	private Document 		dom = null;
	
	@Override
	public void connect()
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try
		{
			//Using factory get an instance of document builder
			db = dbf.newDocumentBuilder();

			// Parse using builder to get DOM representation of the XML file
			dom = db.parse("Persons.xml");
		}
		catch (ParserConfigurationException | SAXException | IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub

	}

	@Override
	public void create(Person p) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Person> read()
	{

		Element docEl = dom.getDocumentElement();

		ArrayList<Person> persons = new ArrayList<Person>();
		
		//get a nodelist of elements
		NodeList nl = docEl.getElementsByTagName("person");
		if(nl != null && nl.getLength() > 0)
		{
			for(int i = 0 ; i < nl.getLength();i++)
			{
				//get the employee element
				Element el = (Element)nl.item(i);

				//get the Employee object
				Person p = getPerson(el);

				//add it to list
				persons.add(p);
			}
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

	/**
	 * Get object Person from the type Element
	 * @param persEl
	 * @return
	 */
	private Person getPerson(Element persEl)
	{
		Person p = new Person();

		p.setId(getIntValue(persEl,"id"));
		p.setFirstName(getTextValue(persEl, "firstName"));
		p.setLastName(getTextValue(persEl, "lastName"));
		p.setAge(getIntValue(persEl,"age"));

		return p;
	}

	/**
	 * Gettin string value from Elemint
	 * @param el
	 * @param tagName
	 * @return
	 */
	private String getTextValue(Element el, String tagName)
	{
		String textVal = null;
		NodeList nl = el.getElementsByTagName(tagName);
		
		if(nl != null && nl.getLength() > 0)
		{
			Element e = (Element)nl.item(0);
			textVal = e.getFirstChild().getNodeValue();
		}

		return textVal;
	}
	
	/**
	 * Get an integer value from Element
	 * @param el
	 * @param tagName
	 * @return
	 */
	private int getIntValue(Element el, String tagName)
	{
		return Integer.parseInt(getTextValue(el, tagName));
	}
}
