
public class Asterix2 {
	public static void main(String[] args)
	{
		System.out.println("Second Triangle");
		for(int i=1; i<=7; i++)
		{
			for(int k=7; k>0; k--)
				 {
				 	System.out.print("");
				 }
			for(int l=7-i; l<7; l++) 
				 {
					 System.out.print("*");
				 }
		System.out.print("\n");
		}
	}
	public static void triangle(String[] args)
	{
		System.out.println("Equilateral Triangle");
	}
	
}