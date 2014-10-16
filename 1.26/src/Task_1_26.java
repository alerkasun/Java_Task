import java.util.Scanner;

public class Task_1_26 {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int i;
	        double Pi=3.14;
	        System.out.print("Введите радиус окружности (целое число) : ");
	        if(sc.hasNextInt()) { 
	          i = sc.nextInt(); 
	          System.out.println("Диаметр окружности равен " + 2 * i);
	        } else {
	            System.out.println("Вы ввели не целое число");
	          }
	      }
	  }