import java.util.Scanner;

public class Task_1_25 {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int i;
	        System.out.print("Введите сторону квадрата (целое число) : ");
	        if(sc.hasNextInt()) { 
	          i = sc.nextInt(); 
	          System.out.println("Периметр квадрата равен " + i*4);
	        } else {
	            System.out.println("Вы ввели не целое число");
	          }
	      }
	  }