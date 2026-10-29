package com.kh.example.practice4.model.vo;

public class Run {
	public static void main(String[]args) {
		Book b1 = new Book();
		b1.inform();
		
		Book b2 = new Book("돈의 흐름", "책심사", "홍길동");
		b2.inform();
		
		Book b3 = new Book("공부 잘하는 아이의 비결", "천재기획", "동길홍", 20000, 0.2);
		b3.inform();
		
		
	}

}
