package com;

import java.util.Scanner;

public class Number5 {	
	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = 0;
    System.out.print("Введите оценку : ");
    a = sc.nextInt(); 
	if(a>=0 & a<=19) 
		System.out.println("F");
	if(a>=20 & a<=39)
		System.out.println("E");
	if(a>=40 & a<=59)
		System.out.println("D");
	if(a>=60 & a<=75)
		System.out.println("C");
	if(a>=75 & a<=89)
		System.out.println("B");
	if(a>=90 & a<=100)
		System.out.println("A");
	if(a<0 || a>100) 
		System.out.println("Wrong Mark!");
}
}