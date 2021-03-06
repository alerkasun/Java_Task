package loop;

public class Loop {
	public static String even()
	{
		String result="";
		int sum=0;
		int quantity=0;
		for(int i=1;i<=99;i++)
		{
			if(i%2==0)
			{
				sum+=i;
				quantity+=1;
			};
		}
		return result="Summ = " + sum + " Quantity = " + quantity;
	}
	public static boolean isPrime(int a) {
	    if (a < 2) return false;
	    for (int i = 2; i*i <= a; i++)
	        if (a % i == 0) return false;
	    return true;
	}
	public static long rootOfPositiveWholeNumber(double n)
	{
		long result = Math.round(Math.sqrt(n));
		return result;
	}
	public static int factorial(int n)
	{
		int result=1;
		for(int i=1;i<=n;i++)
		{
			result*=i;
		}
		return result;
	}
	public static int sumofnumbers(int a)
	{
		int sum = 0;
		char[] chars = String.valueOf(a).toCharArray();
		for (char c: chars) {
			if (Character.isDigit(c))
			sum += Character.digit(c, 10);
		}
		return sum;
	}
	public static int reverse(int a)
	{
		StringBuilder s = new StringBuilder();
		s.append(a);
		s.reverse();
		return Integer.parseInt(s.toString());
	}
	
}
