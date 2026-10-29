package com.kh.example.chap04_class.controller;

public class Run {
	public static void main(String[]args) {
		KindsOfVariable1 kov1 = new KindsOfVariable1();
//		kov1.method1();
//		kov1.method2();
		
		KindsOfVariable2 kov2 = new KindsOfVariable2();
		//kov2.staticNum = 0;
		KindsOfVariable2.staticNum =0;
		kov2.test(); // 11 11
		kov2.test(); // 12 12
		kov2.test(); // 13 13
		
		
		KindsOfVariable2 kov22 = new KindsOfVariable2();
		kov22.test(); // 
				
	}

}
