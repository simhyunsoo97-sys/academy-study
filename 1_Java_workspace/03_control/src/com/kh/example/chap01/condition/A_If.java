package com.kh.example.chap01.condition;

import java.util.Scanner;

public class A_If {
	public void method1() {
		// 키보드로 입력한 숫자가 짝수인지 홀수인지 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("짝수 : ");
		int num = sc.nextInt();
		
		if(num % 2 == 0) {
			System.out.println("짝수입니다.");
			
		}else {
			System.out.println("홀수입니다.");
			
		}
		System.out.println("프로그램 종료");
		
		
		}
		public void method2() {
			// 키보드로 입력한 순자가 양수인지 0인지 음수인지 출력
			Scanner sc = new Scanner(System.in);
			System.out.println("숫자");
			int num = sc.nextInt();
			
			if(num < 0 ) {
				System.out.println("양수");
				
			}else {
				if(num == 0) {
				System.out.println("0임");
				
			} else {
				System.out.println("음수");
				
				}
			}
		}
	
	public void method3( ) {
		// 주민번호를 입력받아(-포함) 사용자의 성별 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("주민등록번호(- 포함) : "); 
		String pNo = sc.nextLine(); //260802-3451245
		char gender = pNo.charAt(7);
		if(gender == '1' || gender == '3') {
			System.out.println("당신은 남자군요");
		} else if(gender == '2' || gender == '4') {
			System.out.println("당신은 여자군요");
		}
		}
		
		public void method4() {
			//나이를 입력받 어린이, 청소년, 성인출력
			//어린이:13세 이하 / 청소년: 13세 초과 19 아허 / 성인19세 초과
			Scanner sc = new Scanner(System.in);
			System.out.println("나이를 입력해주세요 : ");
			int age = sc.nextInt();
			
			if(age <= 13) {
				System.out.println("어린이");
			} else if(age <= 19) {
					System.out.println("청소년");
			} else {
				System.out.println("성인");
			
			}
			
		}
		public void method5() {
			// 사용자에게 이름을 입력받아 본인인지 확인
			Scanner sc = new Scanner(System.in);
			System.out.print("이름 : ");
			String name = sc.nextLine();
			//if(name == "심현수") { // 참조자료형에서 == 비교연산자는 주소 값 비교
			if(name.equals("심현수")) {
				System.out.println("본인입니다");
			} else {
				System.out.println("본인이 아닙니다");
			}
					
			
		}
		
		
		
	}

