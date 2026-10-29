package com.kh.example.chap02.loop;

import java.util.Scanner;

public class A_For {
	public void method1() {
		// 1부터 5까지 출력
		for (int i = 1; i <= 5; i++) {
//			System.out.println(i + "번째 반복문 수행");
		}

	}

	public void method_1() {
		// 자기 소개 다섯 번 하기 : 내이은 xxx이야
		for (int i = 1; i <= 5; i++) {
			System.out.println("내 이름은 심현수야");
		}
	}

	public void method2() {
		// 5부터 1까지 출력
		for (int i = 5; i >= 1; i--) {
			System.out.println(i);

		}
		for (int i = 1; i <= 5; i++) {
			System.out.println(6 - 1);

		}
	}

	public void method2_1() {
		// 8부터 3까지 출력
		for (int i = 8; i >= 3; i--) {
			System.out.println(i);

		}
		for (int i = 0; i < 6; i++) {
			System.out.println(8 - 1);
		}
	}

	public void method3() {
		// 1부터 10사이의 홀수만 출력 : 1 3 5 7 9
		for (int i = 1; i <= 10; i += 2) {
			System.out.println(i);

		}
		for (int i = 1; i <= 10; i++) {
			if (i % 2 != 0) {
				System.out.println(i);

			}
		}
	}

	public void method4() {
		// 정수 두 개를 입력 받아 그 사이 숫자 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 두 개를 입력하세요. ");
		System.out.println("단, 첫 번째 숫자를 두 번째 숫자보다 작게 입력해주세요. ");
		System.out.println("첫 번째 숫자 : ");
		int start = sc.nextInt();
		System.out.println("두 번째 숫자 : ");
		int end = sc.nextInt();

		for (int i = start; i <= end; i++) {
			System.out.println(i);
		}
		int max = end;
		int min = start;
		if (start < end) {
			max = start;
			min = end;
		}

//			
//			for(int i = min; i <= max; i++) {
//				System.out.println("min max 이용 : " + i);
//				}
		for (; min <= max; min++) {
			System.out.println(min);
		}
	}

	public void method5() {
		// 정수를 하나 입력받아 그 수가 1~9 사이의 수일 때만 그 수의 구구단 출력
		// 조건이 맞지 않으면 "!~(사이의 양수를 입력하여야 합니다" 출력
		// ex 1. 1~9사이의 양수를 하나 입력하세요: 5
		// (5단 출력)
		// ex 2. 1~9 사이의 양수를 하나 입력하세요: 10
		// 1~9 사이의 양수를 입력하여야 합니다
		Scanner sc = new Scanner(System.in);
		System.out.println("1~9 사이의 양수를 하나 입력하세요 :");
		int num = sc.nextInt();
		if (num >= 1 && num <= 9) {
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d * %d = %d\n", num, i, num * i);
			}
		} else {
			System.out.println("1~9까사이의 양수를 입력하여야 합니다");
		}

	}

	public void method6() {
		// 1부터 10 사이의 임의의 난수를 저어해 1부터 난수까지의 정수 합꼐 출력
		// (0단계) 0 <= Math.random() < 1 : 0~0.9999999999999999999...
		// (1단계) 0 <= Math.random() * 10 <10 : 0.999999999999999999...
		// (2단계) Math.random() * 10 + 1 < 11 : 1~10.999999999999999999...
		// (3단계) (int)(Math.radom() * 10 + 1) < 11 : 1~10
		// * 2단계와 3단계의 순서는 바뀌어도 됨
		int random = (int) (Math.random() * 10 + 1);
		// System.out.println(random);

		int sum = 0;
		for (int i = 1; i <= random; i++) {
			sum += i;

		}
		System.out.printf("1부터 %d까지의 정수 합계 : %d\n, random, sum");

	}

	public void method7() {
		// 2단부터 9단까지 출력
		for (int dan = 2; dan <= 9; dan++) {
			System.out.println("=====" + dan + "단=====");
			for (int num = 1; num <= 9; num++) {
				System.out.printf("%d * %d= %\n", dan, num, dan * num);

			}
			System.out.println("");

		}

	}

	public void method8() {
		// 아날로그 시계 : 0시 ~ 0분 ~23시 59분
		for (int hour = 0; hour <= 24; hour++) {
			for (int min = 0; min < 60; min++) {
				System.out.printf("%d시 %d분\n", hour, min);

			}
		}
	}

	public void method9() {
		// 한 줄에 별표(*)가 5번 출력되는데
		// 그 줄은 사용자가 입력한 수만큼 출력
		// 풀력할 줄 수 : 3
		// *****
		// *****
		// *****
		Scanner sc = new Scanner(System.in);
		System.out.println("출력할 줄 수 : ");
		int i = sc.nextInt();
		for (int row = 1; i <= row; i++) {
		for(int j = 1; j <= 5; j++)	{
				
			}
			System.out.println(); 
		}
		}
	public void method10() {
		// 한 줄에 별 표 문자(*)를 입력된 줄 수와 칸 수만큼 출력
		// 단, 줄 수와 칸 수가 일치하는 위치에는 줄 번호에 대한 정수 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("줄 수 :");
		int row = sc.nextInt();
		System.out.println("칸 수 : ");
		int col = sc.nextInt();
		
		for(int i = 1; i <= row; i++) {
			for(int j = 1; j <= col; j++) {
				if(i == j) {
					 System.out.println(i);
				} else {
					System.out.println();
				}
				System.out.println();
				
			}
			
		}
		
	}
	}

