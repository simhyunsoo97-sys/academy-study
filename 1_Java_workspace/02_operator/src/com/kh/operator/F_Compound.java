package com.kh.operator;

public class F_Compound {
	public void method() {
		int num1 = 12;
		int num2 = 12;
		
		num1 = num1 + 3;
		System.out.println("num1 : " + num1);
		num2 += 3;
		System.out.println("num2 : " + num2);
		
		num1 = num1 - 5;
		System.out.println("num1 : " +num1 );
		num2 -= 5;
		System.out.println("num2 : " + num2);
	
		
	}

}
