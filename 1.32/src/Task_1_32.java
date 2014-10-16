import java.util.Scanner;

public class Task_1_32 {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int v = 0,m = 0;
	        System.out.print("Введите объем (целое число) : ");
	        if(sc.hasNext()) { 
	          v = sc.nextInt(); 
	        } else {
	            System.out.println("Вы ввели не целое число");
	          }
	        System.out.print("Введите массу тела (целое число) : ");
	        if(sc.hasNext()) { 
		        m = sc.nextInt(); 
		        
	        } else {
	            System.out.println("Вы ввели не целое число");
	          }
	        System.out.println("Плотность равна " + v * m);
	      }
	  }