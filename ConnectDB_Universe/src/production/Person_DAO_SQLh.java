package production;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.hibernate.Session;


public class Person_DAO_SQLh implements Person_DAO
{
	private Session session = null;
	@Override
	public void connect()
	{
		session = HibernateUtil.createSessionFactory().openSession();
		session.close();
	}

	@Override
	public void disconnect()
	{
		session = HibernateUtil.createSessionFactory().openSession();
		session.close();
	}

	@Override
	public void create(Person p)
	{
		session = HibernateUtil.createSessionFactory().openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public ArrayList<Person> read()
	{

		ArrayList<Person> persons = new ArrayList<Person>();

		session = HibernateUtil.createSessionFactory().openSession();
		persons = (ArrayList<Person>) session.createCriteria(Person.class).list();

		return persons;
	}

	@Override
	public void update(Person p)
	{
		session = HibernateUtil.createSessionFactory().openSession();
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(Person p)
	{
		session = HibernateUtil.createSessionFactory().openSession();
		session.beginTransaction();
		session.delete(p);
		session.getTransaction().commit();
		session.clear();
	}

}
