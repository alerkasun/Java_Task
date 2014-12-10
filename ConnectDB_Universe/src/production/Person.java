package production;

public class Person 
{
	private int id 	= 0;
	private int age = 0;
	
	private String firstName = null;
	private String lastName  = null;
	
	public Person()
	{
		
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public String toString()
	{
		return "[" + id +  " " + firstName + " " +lastName + " " + age + "]";
	}
}