package com.kh.example.chap02_class.controller;

public class Run {
	public static void main(String[]args) {
		PublicTest pt = new PublicTest();
		pt.test();
		
		//Default Test dt = new DefaultTest(); //해결방법은 주석처리밖에없다
		
		DefaultTest dt = new DefaultTest();	
		dt.test();
		
	}

}
