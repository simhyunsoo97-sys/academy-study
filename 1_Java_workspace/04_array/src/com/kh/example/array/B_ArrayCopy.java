package com.kh.example.array;

import java.util.Arrays;

public class B_ArrayCopy {
	public void method1() {
		int[] originArr = {1, 2, 3, 4, 5}; // 배열 선언/ 할다과 동시에 초기화
		int[]copyArr = originArr; //얕은 복사
		System.out.println("originArr : " + originArr);
		System.out.println("copyArr : " +  copyArr);
		
		System.out.println("originArr : " );
		for(int i = 0; i < originArr.length; i++ ) {
			System.out.print(originArr[i] + " ");
			
		}
		System.out.println();
		System.out.println("copyArr : ");
		for(int i = 0; i < copyArr.length; i++ ) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();
		System.out.println("=== originArr[0 = 99; 변경 ===");
		originArr[0] = 99;
		
		System.out.println("originArr : " + originArr);
		System.out.println("copyArr : " +  copyArr);
		
		System.out.println("originArr : " );
		for(int i = 0; i < originArr.length; i++ ) {
			System.out.print(originArr[i] + " ");
			
		}
		System.out.println();
		System.out.println("copyArr : ");
		for(int i = 0; i < copyArr.length; i++ ) {
			System.out.print(copyArr[i] + " ");
		}

	}
	public void method2() {
		int[] originArr = {1, 2, 3, 4, 5};
		int[] copyArr = new int[5];
		
		System.out.println("originArr : " + originArr);
		System.out.println("copyArr : " +  copyArr);
		
		System.out.println("originArr : " );
		for(int i = 0; i < originArr.length; i++ ) {
			System.out.print(originArr[i] + " ");
			
		}
		System.out.println();
		System.out.println("copyArr : ");
		for(int i = 0; i < copyArr.length; i++ ) {
			System.out.print(copyArr[i] + " ");
		}
		
		System.out.println();
		System.out.println("=== for문을 이용한 1:1 값 복사 ===");
		
		for(int i = 0; i < originArr.length; i++) {
			copyArr[i] = originArr[i];
			
		}
		System.out.println("originArr : " + originArr);
		System.out.println("copyArr : " +  copyArr);
		
		System.out.println("originArr : " );
		for(int i = 0; i < originArr.length; i++ ) {
			System.out.print(originArr[i] + " ");
			
		}
		System.out.println();
		System.out.println("copyArr : ");
		for(int i = 0; i < copyArr.length; i++ ) {
			System.out.print(copyArr[i] + " ");
			
		}
		System.out.println();
		System.out.println("=== originArr[0] =99;  변경===");
		
		
	}
	public void method3() {
		int[] originArr = {1, 2, 3, 4, 5};
		int[] copyArr = new int [10];
		System.out.println("originArr : " + originArr);
		System.out.println("copyArr : " +  copyArr);
		
		System.out.println("originArr : " );
		for(int i = 0; i < originArr.length; i++ ) {
			System.out.print(originArr[i] + " ");
			
		}
		System.out.println();
		System.out.println("copyArr : ");
		for(int i = 0; i < copyArr.length; i++ ) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();
		System.out.println("=== System.arraycopy 이용한 값 복사 ===");
		//System.arraycopy(src, srcPos, dest, destPos, length);
		// src : 원본 배열 
		// srcPos : 원본 배열에서 복사를 시작할 위치
		// dest : 복사 배열
		// destPos : 복사 배열에서 붙여넣기를 시작할위치
		// length : 복사 길이
		// 원본 배열의 0 index부터 원본 배열의 길이만큼 복사 후, 복사 배열 3 index부터 붙여넣기
		System.arraycopy(originArr, 0, copyArr, 3, originArr.length);
		
		System.out.println("originArr : " + originArr);
		System.out.println("copyArr : " +  copyArr);
		
		System.out.println("originArr : " );
		for(int i = 0; i < originArr.length; i++ ) {
			System.out.print(originArr[i] + " ");
			
		}
		System.out.println();
		System.out.println("copyArr : ");
		for(int i = 0; i < copyArr.length; i++ ) {
			System.out.print(copyArr[i] + " ");
		}
	}
		public void method4() {
			int[] originArr = {1, 2, 3, 4, 5};
			int[] copyArr = new int [10];
			
			System.out.println("originArr : " + originArr);
			System.out.println("copyArr : " +  copyArr);
			
			System.out.println("originArr : " );
			for(int i = 0; i < originArr.length; i++ ) {
				System.out.print(originArr[i] + " ");
				
			}
			System.out.println();
			System.out.println("copyArr : ");
			for(int i = 0; i < copyArr.length; i++ ) {
				System.out.print(copyArr[i] + " ");
				
			}
			System.out.println();
			System.out.println("=== Arrays.copyOf() 이용한 값 복사 ===");
			copyArr = Arrays.copyOf(originArr, originArr.length);
			
			System.out.println("originArr : " + originArr);
			System.out.println("copyArr : " +  copyArr);
			
			System.out.print("originArr : " );
			for(int i = 0; i < originArr.length; i++ ) {
				System.out.print(originArr[i] + " ");
				
			}
			System.out.println();
			System.out.print("copyArr : ");
			for(int i = 0; i < copyArr.length; i++ ) {
				System.out.print(copyArr[i] + " ");
			}

			
		}
	}

