package arrays;

public class Array {
	
	public static void array(int []a)
	{
		for(int i = 0; i <a.length; i++)
		{
		if(a[i] %2 != 0)
			a[i] = 0;
	    }
	}
}