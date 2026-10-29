package com.kh.operator;

public class C_Arithmetic {
	public void method() {
	int num1 = 10;
	int num2 = 20;
	System.out.println(num1/num2);
	System.out.println(num1%num2);
	
	double num3 = 15.0;
	double num4 = 4;
	System.out.println(num3/num4);
	System.out.println(num3%num4);
	System.out.println(num1/num4);//2.5
	System.out.println(num1/(int)num4);//2
	
	System.out.println("2가 출력되게 만들기! 단, 형변환은 한 번만!!");
	double num5 = 2.4;
	double num6 = 1.2;
	System.out.println((int)(num5/num6));//2.0
	System.out.println((int)(num5/num6));//2.4
	System.out.println((int)(num5/num6));//2  
	System.out.println((int)(num5/num6));//2 
	
	
			
		

	}
	

}
