
public class Asterix {
	public static void main(String[] args)
	{
		System.out.println("Equilateral Triangle");
		for(int i=1; i<=7; i++)
		{
			for(int j=7-i; j>0; j--)
				 {
				 	System.out.print(" ");
				 }
			for(int k=7-i; k<7; k++) 
				 {
					 System.out.print(" *");
				 }
			System.out.print("\n");
		}
	}	
}
