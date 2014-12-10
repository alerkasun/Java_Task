import java.util.Scanner;


public class Console {

	public static void enterNumb ()
	{
		int a = 0;
		int b = 0;
		String op = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.println ("Enter A:");
		a = Integer.valueOf(sc.nextLine());
		System.out.println("Enter B:");
		b = Integer.valueOf(sc.nextLine());
		System.out.println("Enter operation:");
		op = sc.nextLine();
		
		System.out.println(Operations.getRusult(a, b, op));
		
	}
}
