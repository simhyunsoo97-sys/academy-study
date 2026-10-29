package com.kh.example.list.model.vo;

import java.util.Objects;

public class Student implements Comparable<Student>{
	private String name;
	private int score;
	
	public Student() {}	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return name + "(" + score + "점)";
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, Integer.valueOf(score));
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name) && score == other.score;
	}
	@Override
	public int compareTo(Student o) {
		// 이름 오름차순
		return name.compareTo(o.name);
		
	}
	
	
	
	
}


