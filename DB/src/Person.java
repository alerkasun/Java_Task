
public class Person {
	private int id;
	private String fName;
	private String lName;
	private int age;
	private int idStreet;
	
	public Person()
	{
	}
	
	public Person(int id,String fName, String lName, int age, int idStreet)
	{
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.idStreet = idStreet;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setFName(String fName)
	{
		this.fName = fName;
	}
	
	public String getFName()
	{
		return fName;
	}
	
	public void setLName(String lName)
	{
		this.lName = lName;
	}
	
	public String getLName()
	{
		return lName;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setIdStreet(int idStreet)
	{
		this.idStreet = idStreet;
	}
	
	public int getIdStreet()
	{
		return idStreet;
	}

}
