package com.kh.example.array;

import java.util.Scanner;

public class A_Array {
	public void method() {
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		int num4 = 40;
		int num5 = 50;
		int num6 = 60;
		int num7 = 70;
		int num8 = 80;
		int num9 = 90;
		
		int sum1 = 0;
		sum1 += num1;
		sum1 += num2;
		sum1 += num3;
		sum1 += num4;
		sum1 += num5;
		sum1 += num6;
		sum1 += num7;
		sum1 += num8;
		sum1 += num9;
		System.out.println(sum1);
		
		int[] arr = new int[9];
		System.out.println("arr :" + arr);
		for(int i = 0; i <arr.length; i++) {
			System.out.println("arr[" + i + "] :" + arr[i]);
			
		}
		
		// 배열 값 초기화 1. 인덱스 이용
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		arr[5] = 60;
		arr[6] = 70;
		arr[7] = 80;
		arr[8] = 90;
		
		//배열 값 초기화2. for문 이용
		for(int i = 0; i <arr.length; i++) {
			arr[i] = 10 * (i + 1);
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] :" + arr[i]);
		}
		int sum2 = 0;
		for(int i = 0; i < arr.length; i++) {
			sum2 += arr[i];
		}
		System.out.println(sum2);
		
		System.out.println("---------------------");
		Scanner sc = new Scanner(System.in);
		System.out.println("반 인원 : ");
		int students = sc.nextInt();
		arr =new int[students];// 배열의 크기는 변경이 불가능함
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] : %d|n",i, arr[i]);
		}
		System.out.println("arr : " + arr);
		
		
		
	}
}
