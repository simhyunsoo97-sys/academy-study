package com.kh.operator;

import java.util.Scanner;

public class G_Triple {
	public void method1() {  //메소드에 주석을 써주는이유 복습할떄 기억안나면 참고자료용으로
		// 입력한 정수가 홀수인지 짝수인지 판별
		// 홀수이면 "홀수입니다" 출력
		// 짝수이면 "짝수입니다" 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		int num = sc.nextInt();
		
		String result = (num % 2 == 0) ? "짝수입니다" : "홀수입니다"; // 소괄호는 좀더 잘보이라고 씀
		System.out.println(num +"은(는) " + result);
		}
	

	
	public void method2() {
		// 입력한 정수가 양수인지 아닌지 판별
		//양수면 "양수다", 양수가 아니면 "양수가 아니다" 출력
		//33
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
//		int num = sc.nextInt();
		//String result = num > 0 ? "양수입니다" : "양수가 아닙니다";
		
		// 양수면 "양수다",0이면"0이다", 그 무엇도 아니면(음수면) "음수다" 출력
		
		int num1 = sc.nextInt();
		String result1 = num1 > 0 ? "양수입니다" : num1 == 0 ? "0입니다" : "음수입니다";
		System.out.println(num1 +"은(는) " + result1);			
		
		
		}
	}


		
