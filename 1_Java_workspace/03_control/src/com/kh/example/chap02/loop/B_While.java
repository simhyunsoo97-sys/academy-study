package com.kh.example.chap02.loop;

import java.util.Scanner;

public class B_While {
	public void method1() {
		//1부터 5까지 출력(while)
		int i = 1;
		while(i <= 5) {
			System.out.println(i);
			i++;
		 	
			
		}
		
	}
	public void method2() {
		// 5부터1까지 출력(do~while)
		int i = 5;
		do {
			System.out.println(i);
			i--;
		} while(i >= 1);
	}
	public void method3() {
		//정수 하나를 입력받아 그 수가 1~9 사이의 수일 때만 그 수의 구구단 출력
		// 조건이 맞지 않으면 "1~9 사이의 양수를 입력하여야 합니다" 출력 (while)
		Scanner sc = new Scanner(System.in);
		System.out.println("1~9 사이의 양수를 하나 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num >= 1 && num <= 9) {
			int i = 1;
			while(i < 10) {
				System.out.printf("%d * %d\n", num,i,num*1);
				i++;
			}
		}else {
			System.out.println("1~9 사이의 양수를 입력하여야 합니다");
		}
		
	}
	public void method4() {
		// 문자열을 입력받아 인덱스 별로 문자 출력
		// ex. 문자열 입력 : apple
		//		0 : a
		//		1 : p
		//		2 : p
		//		3 : l
		//		4 : e
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();
				
		for(int i = 0; i <str.length(); i++) {
			System.out.println(i + " : " + str.charAt(i));
		}
			int i = 0;
			while(i < str.length()) {
				System.out.println(i +" : " + str.charAt(i));
				i++;
			}
		}
	public void method5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 1~5까지 출력");
		System.out.println("2. 5~1까지 출력");
		System.out.println("3. 구구단 출력");
		System.out.println("4. 문자열 인덱스 출력");
		System.out.println("9. 종료");
		System.out.println("메뉴 번호 : ");
		int menuNum = sc.nextInt();
		
		switch(menuNum) {
		case 1:method1();break;
		case 2:method2();break;
		case 3:method3();break;
		case 4:method4();break;
		case 9:System.out.println("종료합니다."); break;
		default: System.out.println("잘못 입력했습니다.");
		
			
			
		}
	}
	public void method5_1() {
		Scanner sc = new Scanner(System.in);
		
		int menuNum = 0;
		while(menuNum != 9) {
				System.out.println("1. 1~5까지 출력");
				System.out.println("2. 5~1까지 출력");
				System.out.println("3. 구구단 출력");
				System.out.println("4. 문자열 인덱스 출력");
				System.out.println("9. 종료");
				System.out.println("메뉴 번호 : ");
				menuNum = sc.nextInt();
				
				switch(menuNum) {
				case 1:method1();break;
				case 2:method2();break;
				case 3:method3();break;
				case 4:method4();break;
				case 9:System.out.println("종료합니다."); break;
				default: System.out.println("잘못 입력했습니다.");
				}
	    }
		
	}
	
	public void method5_2() {
		Scanner sc = new Scanner(System.in);
			
		int menuNum = 0;	
		do {
			System.out.println("1. 1~5까지 출력");
			System.out.println("2. 5~1까지 출력");
			System.out.println("3. 구구단 출력");
			System.out.println("4. 문자열 인덱스 출력");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 : ");
			menuNum = sc.nextInt();
			
			switch(menuNum) {
			case 1:method1();break;
			case 2:method2();break;
			case 3:method3();break;
			case 4:method4();break;
			case 9:System.out.println("종료합니다.");break;
			default: System.out.println("잘못 입력했습니다.");
			}
		}while(menuNum != 9);
	}		
			
	
	public void method6() {
		// (어제 우리가 만든 메뉴 다시 한 번 더 만들기)
		// 메뉴 1,2,3,4,9 출력하고 메뉴 번호에 맞게 실행 
		//단, 반복은 단 넣어도 됨
           Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. 1~5까지 출력");
			System.out.println("2. 5~1까지 출력");
			System.out.println("3. 구구단 출력");
			System.out.println("4. 문자열 인덱스 출력");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 : ");
			int menuNum = sc.nextInt();
			
			switch(menuNum) {
			case 1:method1();break;
			case 2:method2();break;
			case 3:method3();break;
			case 4:method4();break;
			case 9:System.out.println("종료합니다."); return;
			default: System.out.println("잘못 입력했습니다.");
			}
		}
		
	}
	public void method7() {
		// 문자열을 입력하면 해당 문자열의 길이를 출력하기
		// 단, exit가 들어오면 반복 종료
		// while ver
		Scanner sc = new Scanner(System.in);
		
		String str = ""; // null : 참조 자료형 기본 값, 아무 것도 참조하지 않은 것
		while(!str.equals("exit")) {
			System.out.print("문자열 입력 : ");		
			str = sc.nextLine();		
			System.out.println(str + "의 길이 : " + str.length());
			
		}
	}
	public void method7_1() {
		// 문자열을 입력하면 해당 문자열의 길이를 출력하기
		// 단, exit가 들어오면 반복 종료
		// do while ver
		Scanner sc = new Scanner(System.in);
		
		String str = "";
		do {
			System.out.println("문자열 입려 : ");
			str = sc.nextLine();
			
			System.out.println(str + "의 길이 : " + str.length());
		} while (!str.equals("exit"));
		
	}
	public void mehod7_2() {
		// 문자열을 입력하면 해당 문자열의 길이를 출력하기
		// 단, exit가 들어오면 반복 종료
		// while ver
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("문자열 입려 : ");
			String str = sc.nextLine();
			System.out.println(str + "의 길이 : " + str.length());
			
		}
	}
	public void method8() {
		// 사용자에게 숫자를 하나 입력 받아
		// 1부터 해당 숫자까지의 합계 출력
		// ex. 숫자를 하나 입력하세요 : 3
		//		1부터 3까지의 합은 6입니다.
		// 조건: for문의 조건식은 생략하기 => for(초기식; 증감식)
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int num =- sc.nextInt();
		int sum = 0;
		for(int i = 1; i <= num; i++) {
			sum += i;
			
			if(i == num) {
				break;
				
			}
			System.out.println("1부터" + num + "까지의 합은 " + sum + "입니다.");
		
		}
		
		
	}
}	
	
		
			
			
		
		
		
		
	
		
		
	


