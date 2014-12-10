import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
 
public class Show
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
     
    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
     
    JOptionPane.showMessageDialog(frame,
        "Answer: '" + res + "'.");
    System.exit(0);
  }
}