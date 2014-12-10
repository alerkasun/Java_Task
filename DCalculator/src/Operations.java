
public class Operations {
	
	public static int getRusult (int a,int b, String op)
	{
		int result = 0;
		
		if (op.equals("+"))
		{
			return a + b;			
		}
		if (op.equals("-"))
		{
			return a - b;
		}
		if (op.equals("/") & a != 0 & b != 0)
		{
			return a / b;
		}
		if (op.equals("*"))
		{
			return a * b;
		}
	
		return result;
	}
}
