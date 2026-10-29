package com.kh.example.chap01_throws.run;

import com.kh.example.chap01_throws.controller.ThrowsController;

public class Run {
	public static void main(String[] args) {
		System.out.println("프로그램 실행...");
		ThrowsController tc = new ThrowsController ();
		try {
			tc.method1();
			System.out.println("나는 출력될까 안될까?1111");
		} catch(NullPointerException e){ 
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("Exception 예외 잡음!!!");		
		} finally {
			System.out.println("나는 출력될까 안될까?2222");
		}
		System.out.println("프로그램 종료...");
	}

}
