package com.kh.example.chap04_class.controller;

public class KindsOfVariable2 {
	public static int staticNum;
	
	private int testNum = 10; // 인스턴트 변수
	private static int staticTestNum = 10; // 클래스 변수 
	
	public void test() {
		testNum++;
		System.out.println("testNum : " + testNum);
		staticTestNum++;
		System.out.println("testNum : " + staticTestNum );
		
	}
	

}
