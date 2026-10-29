package com.kh.example.chap06_method.controller;

import com.kh.example.chap05_constructor.model.vo.User;

public class MethodPractice {
	public void method1() {
		//반환값x   매개변수x
		System.out.println("매개변수와 반환 값 둘 다 없음");
	}
	public int method2() {
		// 반환값o 매개변수o
		// return 0; // 리터럴 넣기

		int i = 0;
		return i; //변수 넣기
		//릴터럴끼리의 연산, 변수 연산 등등..
		//반환타입에 적은 것과 일치하기만 하면 됨
	}
		public void method3(char ch, int num) {
			// 반화값x            매개변수o
			char ch2 = (char)(ch + num);
			System.out.println(ch + "에서" + num + "만큼 뒤에 있는 문자는" +ch2 + "입니다.");
			
	}
		public char method4(String str , int index) {
//			char ch = str.charAt(index);
//		    return ch;
			return str.charAt(index);
			
	}
		public User method5(int[]array, double dNum) {
			System.out.println("MP array : " + array);
			System.out.println("MP DnUM : " + dNum);
			User u = new User("user03", "아무개", array[0], dNum );
			System.out.println("");
			return u;
			
			
	}	
}
