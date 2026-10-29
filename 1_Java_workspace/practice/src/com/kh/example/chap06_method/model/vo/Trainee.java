package com.kh.example.chap06_method.model.vo;

public class Trainee {
	private String name;
	private final String ACADEMY = "KH";
	private int classRoom;
	private String time;
	private static double score;
	
	
	public Trainee() {}		
	public Trainee(String name, int classRoom, String time, double score) {
		this.name = name;
		this.classRoom = classRoom;
		this.time = time;
		Trainee.score = score;
	}	

	public String getName() {
		return name;
	}	
	public void setName(String name) {
		this.name = name;
		
		
	}
	public String getACADEMY() {
		return ACADEMY;
	}
	public int getclassRoom() {
		return classRoom;
	}
	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public static double getScore(double score) {
		return score;
	}
	public static void setSocre(double score) {
		Trainee.score = score;
	}
	
	public String inform() {
		return ACADEMY +" "  + name + " 훈련생은 " + classRoom + "반" + time + "이고," + score + "점입니다.";
	}
}
