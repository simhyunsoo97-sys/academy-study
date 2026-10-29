package com.kh.operator;

import java.net.MulticastSocket;

public class B_InDecrease {
	public void method1() {
		int num1 = 10;
		System.out.println("전위 증감 연산자 적용 전 : " + num1);			//10
		System.out.println("++num1 1회 수행 결과 : " + ++num1);  		//11
		System.out.println("++num1 2회 수행 결과 : " + (++num1));		//12
		System.out.println("++num1 3회 수행 결과 : " + (++num1));		//13	
		System.out.println("전위 증감 연산 수행 후 num1의 값 : " + num1);	//13
		
		int num2 = 10;
		System.out.println("전위 증감 연산자 적용 전 : " + num2);			//10
		System.out.println("++num1 1회 수행 결과 : " + ++num2);		//10 -->11
		System.out.println("++num1 2회 수행 결과 : " + (++num2));		//11 -->12
		System.out.println("++num1 3회 수행 결과 : " + (++num2));		//12 -->13
		System.out.println("전위 증감 연산 수행 후 num1의 값 : " + num2);	//13
		
		
		
	}
	
	public void method2() {
		int num1 = 20;
		int result1 = num1++ * 3;
		System.out.println("num1 : " + num1);			//21 
		System.out.println("result1 : " + result1);		//60
		
		int num2 = 20;									
		int result2 = num2++ * 3;						
		System.out.println("num2 : " + num2);			//21
		System.out.println("result2 : " + result2);		//63
		
		System.out.println("-------------------------------------");
		
		int a = 10;
		int b = 20;
		int c= 30;
		System.out.println(a++);						//10
		//a=11 b=20 c=30
		System.out.println((++a) + (b++));				//32
		//a=12 b=21 c=30
		System.out.println((a++) + (--b) + (--c ));		//61
		//a=13 b=20 c=29
		System.out.println("a : " +a);					//13
		System.out.println("b : " +b );					//20
		System.out.println("c : " +c);					//29
		
		
		
	}

}
