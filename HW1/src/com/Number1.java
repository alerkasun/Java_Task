package com;
import java.util.Scanner;

public class Number1 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0,b=0, sum = 0;
        System.out.print("Введите a : ");
          a = sc.nextInt(); 
        System.out.print("Введите b : ");
          b = sc.nextInt(); 
          if(a / 2 == 0){
        	   sum = a + b;
        	   System.out.print (sum);
          }else{
        	  sum = a * b;
        	  System.out.print (sum);
          }
	     }
	 }