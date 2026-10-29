package com.kh.example.list.model.compare;

import java.util.Comparator;

import com.kh.example.list.model.vo.Student;

public class ScoreComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// 점수 내림차순
		
		// 비교 주체 , 비교대상
		//							(오름차순)			(내림차순)
		// 비교 주체가 비교 대상보다 크면 		양수				음수
		// 비교 주체가 비교 대사보다 작으면 	음수 				양수
		//비교 주체와 비교 대상이 같으면		0				0
		Integer subject = o1.getScore();
		Integer object	= o2.getScore();
	
//		if(subject > object) {
//			return -1;
//		} else if(subject < object) {
//			return 1;
//		} else {
//			return 0;
//		}		
		
//		return subject.compareTo(object);
		return object.compareTo(subject);
	}
}