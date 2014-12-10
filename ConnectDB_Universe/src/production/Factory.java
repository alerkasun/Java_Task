package production;

public class Factory
{
	private static Person_DAO personDAO = null;
	private static Factory instance = null;
	
	public static synchronized Factory getInstance()
	{
		if (instance == null)
		{
			instance = new Factory();
		}
		
		return instance;
	}

	public Person_DAO getPersonDAO()
	{
		if (personDAO == null)
	    {
	    	personDAO = new Person_DAO_SQLh();
	    }
	    
	    return personDAO;
	}
}
