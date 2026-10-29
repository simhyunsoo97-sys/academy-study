package com.kh.example.chap05_constructor.model.vo;

public class User {
	private String userId;
	private String userName;
	private int age;
	private double point;
	
	public User() {
		System.out.println("User htis : "+this);
		//this : 현 객체에 대한 주소를 갖고 있는 레퍼런스 변수
	}
	public User(String userId, String userName, int age, double point) {
		this(userId, userName);
		this.age = age;
		this.point = point;
	}
	
		public User(String userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}
	
	
	public void inform() {
		System.out.println(userId + "," + userName + "," + age + "," + point);
		
		
		

	}
	

}

