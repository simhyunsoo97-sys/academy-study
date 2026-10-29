package com.kh.operator;

import java.util.Scanner;

public class E_Logical {
	public void method1() {
		// 입력한 정수 값이 1~100 사이의 숫자인지 확인
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 하나 입력 : ");
		int num = sc.nextInt();
		
		boolean is1to100 = num >= 1 && num <= 100;
		System.out.println("1부터 100 사이인지 확인 : " + is1to100);
		
		
	}
	public void method2() {
		// 입력한 문자 값이 대문자인 확인
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자 하나 입력 : ");
		String str = sc.nextLine();
		char ch = str.charAt(0);
		
		boolean isUpper = (ch >= 'A' && ch <= 'Z');
		System.out.println("영어 대문자가 맞습니까? : " + isUpper);
		
		System.out.println("계속 하시려면 Y 또는 y를 입력하세요.");
		System.out.println("계속 하사겠습니까? : ");
		String str2 = sc.nextLine();
		char answer = str2.charAt(0);
		boolean isContinue = (answer == 'Y' || answer == 'y');
		System.out.println("계속하겠다고 하셨나요? :" + isContinue);
	}
}
