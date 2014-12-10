package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import production.*;

public class Person_DAO_Test
{
	private Person_DAO pDAO = new Person_DAO_Mock();
//	private Person_DAO pDAO = new Person_DAO_SQL();
//	private Person_DAO pDAO = new Person_DAO_SQLh();
//	private Person_DAO pDAO = new Person_DAO_Mongo();
//	private Person_DAO pDAO = new Person_DAO_H2();
//	private Person_DAO pDAO = new Person_DAO_JSON();
//	private Person_DAO pDAO = new Person_DAO_CSV();
//	private Person_DAO pDAO = new Person_DAO_XML();
	
	@Test
	public void testIt() throws Exception
	{
		pDAO.connect();
		
		ArrayList<Person> persons = new ArrayList<Person>();

		/**
		 * Test create
		 */
		Person expected = new Person();
		expected.setId(7);
		expected.setFirstName("Stanislav");
		expected.setLastName("Shandyga");
		expected.setAge(25);
		
		pDAO.create(expected);
		
		persons = pDAO.read();
		Person actual = persons.get(persons.size() - 1);
		
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getFirstName(), actual.getFirstName());
		assertEquals(expected.getLastName(), actual.getLastName());
		assertEquals(expected.getAge(), actual.getAge());
		
		/**
		 * Test update
		 */
		expected = new Person();
		expected.setId(7);
		expected.setFirstName("Superman");
		expected.setLastName("Shandyga");
		expected.setAge(100);
		
		pDAO.update(expected);
		
		persons = pDAO.read();
		actual = persons.get(persons.size() - 1);
		
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getFirstName(), actual.getFirstName());
		assertEquals(expected.getLastName(), actual.getLastName());
		assertEquals(expected.getAge(), actual.getAge());
		
		/**
		 * Test delete
		 */
		expected = new Person();
		expected.setId(7);
		expected.setFirstName("Superman");
		expected.setLastName("Shandyga");
		expected.setAge(100);
		
		pDAO.delete(expected);
		
		persons = pDAO.read();
		int size = persons.size();
		assertEquals(7, size);
		
		pDAO.disconnect();
	}
}
