package com.kh.variable;

import java.util.Scanner;

public class E_KeyboardInput {
	public void Input1( ) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요 :");
		String name = sc.nextLine();
		
		System.out.print("나이를 입력하세요 :");
		int age = sc.nextInt();
		
		System.out.print("키를 입력하세요 : ");
		double height = sc.nextDouble();
		
		System.out.print(name + "님은 " + age + "세이고 키는" + height + "입니다.");
		
	}
	public void input2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입려하세요 :");
		String name = sc.nextLine();
		System.out.print("나이를 입력하세요 :");
		int age = sc.nextInt();
		System.out.print("주소를 입력하세요 :");
		//String address = sc.nextLine();
		// 해결 방법 1. next()로 변경하기
		//String address = sc.next();
		// next()는 띄어쓰기를 구분자로 봐서 일부 문자열만 가지고 옴
		// 주소의 경우 다수의 띄어쓰기가 생길 수 있으므로 여러 개의 next()가 필요함
		// 다만 사용자마다 주소가 모두 다르기 때문에 next()를 몇 번이나 써야할 지 알 수 없다는 것이 문제
		
//		String address = sc.next();
		
		// 해결 방법 2. 버퍼에 줄바꿈 지우기
		sc.nextLine(); //buffer에 남아있는 줄바꿈 가져가는 용도
		String address = sc.nextLine();
		
		System.out.printf("(%d세)님이 사시는 곳은 %s입니다.", name, age, address);
		
	}


public void input3() {
	Scanner sc = new Scanner(System.in);
	
	// 해결 방법 3. 버퍼에 줄바꿈을 남기지 않기
//	System.out.print("이름을 입려하세요 :");
//	String name = sc.nextLine();
//	System.out.print("나이를 입력하세요 :");
//	
//	
//	String strAge =sc.nextLine();//"20"
//	int age = Integer.parseInt(strAge);// 숫자 형태의 문자열을 숫자로 바꿔줌 = 파싱
//	System.out.print("주소를 입력하세요 :"); 
//	String address = sc.nextLine();
//	
//	// 뮨자열에서 char를 뽑아내기
//	char lastName = name.charAt(0);
//	
//	System.out.printf("%s(%d세)님이 사시는 곳은 %s입니다.", name, age, address);
//	System.out.println();
//	System.out.println("당신은" + lastName + "가 사람이군요!");
	
	
}

}
