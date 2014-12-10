
public class CalcAPI
{
	public static int calc (int a, int b, String s)
	{
		int res = 0;
		switch(s)
		{
			case "+":
			res = a + b;
			break;
			case "-":
			res = a - b;
			break;
			case "*":
			res = a * b;
			break;
			case "*/":
			res = a / b;
			break;
		}
		return res;
	}
}