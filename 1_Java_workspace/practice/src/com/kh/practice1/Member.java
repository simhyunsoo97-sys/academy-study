package com.kh.practice1;

public class Member {
	private String memberId;
	private String memberPwd;
	private String memberName;
	private int age;
	private char gender;
	private String phone;
	private String eamoil;
	
	public void changName(String name) {
		memberName = name;
				
	}
	public void printName() {
		System.out.println(memberName);
		
	}

}
