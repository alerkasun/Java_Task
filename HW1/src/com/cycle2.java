package com;

import java.util.Scanner;

public class cycle2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int a = 0;
        System.out.print("Введите a : ");
        a = sc.nextInt(); 
        if (a <= 2) {
        	System.out.println("NO");
        }
        else{
        	if(a%2==0)
        	System.out.println("yes" +  a / 2);
        }

}
}