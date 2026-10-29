package com.kh.example.chap04_class.controller;

public class KindsOfVariable1 {// 클래스 영역
	// 클래스 영역에 작성된 변수 : 필드 = 멤버 변수= 전역 변수 = 메버 필드
	private int globa1Num;
	
	public void method1(int num) { //메소드 영역
		// 메소드 영역에 작성된 변수 : 지역 변수
		// 매개변수도 일조의 지역 변수 
		int loca1Num;
		
		System.out.println(globa1Num);
		//System.out.println(loca1Num);
		System.out.println(num);
		
	}
	public void method2() {
//		System.out.println(globa1Num);
//		System.out.println(loca1Num);
//		System.out.println(num);
//		
	}
	
}
