package com.kh.example.chap01_throws.controller;

public class ThrowsController {
	public void method1() throws Exception {
		System.out.println("method() 호출됨...");
		method2();
		System.out.println("method() 종료됨...");
		
	}
	public void method2() throws Exception {
		System.out.println("method2() 호출됨...");
		method3();
		System.out.println("method2() 종료됨...");
			
	}		
	public void method3() throws Exception {
		System.out.println("method3() 호출됨...");
		throw new Exception();
		//System.out.println("method3() 종료됨...");
	}	
}