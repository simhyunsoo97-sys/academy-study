package com.kh.run;

import java.util.Scanner;

import com.kh.variable.A_Variable;
import com.kh.variable.B_Constant;
import com.kh.variable.C_Casting;
import com.kh.variable.D_PrintMethod;
import com.kh.variable.E_KeyboardInput;

public class Run { // 실행 클래스
	public static void main(String[] args) { // 프로그램 실행
		//com.kh.variable.A_Variable av = new com.kh.variable.A_Variable();
		// 패키지 명을 직접 명시 => 패키지명.클래스명 = 클래스의 풀네임
		A_Variable av = new A_Variable();
		av.declareVariable();
		
		B_Constant bc = new B_Constant();
		bc.finalConstant();
		
		C_Casting cc = new C_Casting();
		cc.cast1();
		
		D_PrintMethod dp =new D_PrintMethod();
		dp.example();
		
		E_KeyboardInput ek = new E_KeyboardInput();
		//ek.input();
		//ek.input2();
		ek.input3();
				
		
			
		}
	}

