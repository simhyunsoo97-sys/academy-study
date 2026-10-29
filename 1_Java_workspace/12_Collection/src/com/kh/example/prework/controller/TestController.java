package com.kh.example.prework.controller;

import com.kh.example.prework.vo.Calculator;
import com.kh.example.prework.vo.Greeting;
import com.kh.example.prework.vo.MeetFirst;

public class TestController {
	public void method() {
		// 1. 일반적인 방법: Greeting interface > MeetFirst > TestController
		Greeting g1 = new MeetFirst();
		g1.say();
		
		// 2. 익명 클래스
		Greeting g2 = new Greeting() {
			@Override
			public void say() {
				System.out.println("반갑습니다");				
			}
		};
		g2.say();
		
		// 3. 람다
		Greeting g3 = () -> System.out.println("하이");
		
		/////////////////////////////////////////////
		
		// 익명 클래스
		Calculator c1 = new Calculator() {
			@Override
			public int sum(int a, int b) {
				return a + b;
			}			
		};
		c1.sum(10, 020);
		
		// 람다
		Calculator c2 = (a, b) -> a + b;
		c2.sum(30, 40);
	}
}
