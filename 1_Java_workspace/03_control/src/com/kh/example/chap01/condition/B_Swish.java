package com.kh.example.chap01.condition;

import java.util.Scanner;

public class B_Swish {
	public void method1() {
		// 정수 두 개와 연산기호 문자 1개를 입력 받아 연산 수행한 결과 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 값 : ");
		int first = sc.nextInt();
		System.out.print("두 번째 값 : ");
		int second = sc.nextInt();
		sc.nextLine();
		System.out.print("연산자(+,-,*,/) : ");
		char op = sc.nextLine().charAt(0);//에러가 나는거 string땜에 나는거다 string을 char로 바꾸면된다
		
		int resulrt = 0;
		switch(op) {
		case '+':
			resulrt = first + second;
		case '-':
			resulrt = first - second;
		case '*' :
			resulrt = first * second;
		case '/' :
			resulrt = first / second;
		default:
			System.out.println("제시한 연산자만 계산이 가능합니다."); // 안내문구 
			System.out.println("계산 결과는 임시 값 0으로 출력됩니다.");//안내문구 있으면 좋다
		
		
		}
		
		System.out.printf("%d %c %d = %d\n", first, op, second, resulrt);
		
		
	}public void method2() {
		// 키보드로 입력한 숫자가 짝수인지 홀수인지 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 : ");
		int num = sc.nextInt();
		String str;
		switch(num % 2) {
		case 0:
			str = "짝수";
			break;
		default:
			str = "홀수";
			
		}
		System.out.printf("%d은(는) %s입니다.", num, str);
		
	}
	public void method3() {
		// 1부터 12까지 중 하나의 정수를 사용자에게 입력 받고
		// 해당 숫자 달에 마지막 날짜 출력
		// ex. 1월의 마지막 날짜는 31일입니다.
		Scanner sc = new Scanner(System.in);
		System.out.println("1~12 사이의 숫자를 입력하세요 : ");
		int month = sc.nextInt();
		int last = 0;
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12 : 
			last = 31; break;
		case 2 :
			last = 28; break;
		case 4,6,9,11 :
			last = 30; break;
		
		default: System.out.println("1이상 12이하여야 합니다. 날짜는 임의로 출력됩니다. ");
		}
		System.out.printf("%d월의 마지막 날짜는 %d일입니다.", month, last);
		
		
		
		
	}
	public void method4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 간단 계산기");
		System.out.println("2. 홀수짝수 판별기");
		System.out.println("3. 달의 마지막 날짜");
		System.out.println("메뉴 번호 :" );
		int menuNum = sc.nextInt();
		
		switch(menuNum) {
		case 1:
			System.out.println("==간단 계산기");
			method1();
		case 2:
			System.out.println("==[홀수짝수 판별기");
			method2();
		case 3:
			System.out.println("==[달의 마지막 날짜");
			method3();
			break;
			
		default: System.out.println("잘못 입력하셨습니다.");
		}
	}
}
