package com.kh.example.chap06_method.run;

import com.kh.example.chap05_constructor.model.vo.User;
import com.kh.example.chap06_method.controller.MethodPractice;
import com.kh.example.chap06_method.model.vo.Trainee;

public class Run {
	public static void main(String[] args) {
		MethodPractice mp = new MethodPractice();
		mp.method1();
		int result = mp.method2();
		System.out.println(result);
		
		mp.method3('A', 10);
				
		System.out.println(mp.method4("apple", result));
		
		System.out.println("==================================");
		
		
		int[] arr = {10, 20, 30};
		System.out.println("Run arr : " + arr);
		
		double point = 12.3;
		User user = mp.method5(arr, point);
		user.inform();
		System.out.println("Run user : " + user);
		
		System.out.println("=====================================");
		
		Trainee t1 = new Trainee();
		System.out.println(t1.inform());
		t1.setName("홍길동");
		t1.setTime("종일");
		System.out.println(t1.inform());
		String name = t1.getName();
		System.out.println(name);
		
		
		Trainee t2 = new Trainee("이동민", 502, "종일", 95);
		System.out.println(t2.inform());
		Trainee.setSocre(100);
		System.out.println(t2.inform());
		
	}
		
}


