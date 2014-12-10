package operators;

public class Operators {
	public static void main(String[] args)
	{
	}
	
	public static int count(int a, int b)
	{
		int sum = 0;
		if(a % 2 == 0){
			sum = a * b;
		}
		else{
			sum = a + b;
		}
		return sum;
	}
	
	public static String koordinats(int x, int y){
		String otvet = null;
		if(x > 1 && y > 1){
			otvet = "First";
		}
		if(x < 1 && y > 1){
			otvet = "Second";
		}
		if(x < 1 && y < 1){
			otvet = "Third";
		}
		if(x > 1 && y < 1){
			otvet = "Fourth";
		}
		if(x == 0){
			otvet = "The point on the X axis";
		}
		if(y == 0){
			otvet = "The point on the Y axis";
		}
		return otvet;
	}
	
	public static int SumOfPositive(int a,int b,int c)
	{
		int sum=0;
		if(a>0)
			{
			sum+=a;
			}
		if(b>0) {
			sum+=b;
		}
		if(c>0) {
			sum+=c;
		}
		return sum;
	}
	
	public static int max(int a,int b)
	{
		int max=0;
		if(a>=b) max=a;
		else max=b;
		return max;
	}
	
	public static String rating(int a)
	{
		String rating="";
		if(a>=0 & a<=19) rating="F";
		if(a>=20 & a<=39) rating="E";
		if(a>=40 & a<=59) rating="D";
		if(a>=60 & a<=75) rating="C";
		if(a>=75 & a<=89) rating="B";
		if(a>=90 & a<=100) rating="A";
		if(a<0 || a>100) rating="Error";
		return rating;
	}
}
