import java.util.Scanner;
public class Dialog 
{
	public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        int res = 0;
       
        System.out.print("Введите первое целое число : ");
        a = Integer.parseInt( sc.nextLine() );  
     
        System.out.print("Введите второе целое число : ");
        b = Integer.parseInt( sc.nextLine() );  
        
        System.out.print("Введите операцию : ");
        String op = sc.nextLine(); 
        
        switch (op) 
        {
        case "+":
        	res = a + b;
            break;
        case "-":
        	res = a - b;
            break;
        case "/":
        	res = a / b;
            break;
        case "*":
        	res = a * b;
            break;
        }
        System.out.print("Ответ равен : " + res);
      }
	
}