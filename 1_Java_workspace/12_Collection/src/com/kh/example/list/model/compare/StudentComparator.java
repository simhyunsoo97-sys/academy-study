package com.kh.example.list.model.compare;

import java.util.Comparator;

import com.kh.example.list.model.vo.Student;

public class StudentComparator implements Comparator<Student>{
	
	// studentList 성적 오름차순, 이름 내림차순
	// 성적으로 오름차순을 하다가 이름이 같으면 이름으로 내림차순 정렬
	@Override
	public int compare(Student o1, Student o2) {
		Integer sScore = o1.getScore();
		Integer oScore = o2.getScore();
		int result = sScore.compareTo(oScore);
		if(result != 0)	{
			return result;
		} else {
			return -o1.getName().compareTo(o2.getName());
		}			
	}
}
