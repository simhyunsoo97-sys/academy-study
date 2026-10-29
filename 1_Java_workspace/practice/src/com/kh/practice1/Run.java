package com.kh.practice1;

import com.kh.practice3.Circle;

public class Run {
	public static void main(String[]args) {
		Member m = new Member();
//		m.changName(null);
//	    m.printName();
		
//		Product p = new Product();
//	p.information();
		
		Circle  c = new Circle ();
		System.out.println("== 원의 둘레 및 넓이==");
		c.getAreaOfCircle();
		c.getAreaOfCircle();
		
		c.incrementRadius();
		
		System.out.println("== 반지름 1 증가 후 원의 둘레 및 넓이 ==");
		c.getAreaOfCircle();
		c.getAreaOfCircle();
		
	}

}
