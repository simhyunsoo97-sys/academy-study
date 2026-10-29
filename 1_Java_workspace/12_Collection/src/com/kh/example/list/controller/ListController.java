package com.kh.example.list.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.kh.example.list.model.compare.ListComparator;
import com.kh.example.list.model.compare.ScoreComparator;
import com.kh.example.list.model.compare.StudentComparator;
import com.kh.example.list.model.vo.Student;

public class ListController {
	public void doList() {
		List l = new ArrayList();
		
		ArrayList<String> list = new ArrayList<String>(3);
		list.add("테스트");
		list.add("도대담");
		list.add("남나눔");
		
		System.out.println("list : " + list); // 테스트, 도대담, 남나눔 => 순서 유지
		
		list.add("하현호");
		System.out.println("list : " + list); // 테스트, 도대담, 남나눔, 하현호 => 크기 제약 x		
		System.out.println("현재 list에 담긴 element 개수 :" + list.size());
		
		list.add("문미미");
		System.out.println("list : " + list);
		System.out.println("현재 list에 담긴 element 개수 : " + list.size());
		
		// add(int index, E e):void
		list.add(0, "류라라");
		System.out.println("list : " + list);
		
		list.add(3, "강건강");
		System.out.println("list : " + list);
		
		// remove(int index):E
		String remove = list.remove(1);
		System.out.println("list.remove(1) 결과 : " + remove);
		System.out.println("list : " + list);
		
		// remove(Object o):boolean		
		boolean remove1 = list.remove("강건강");
		boolean remove2 = list.remove("홍길동");
		System.out.println("list.remove(\"강건강\") 결과 : " + remove1);
		System.out.println("list.remove(\"홍길동\") 결과 : " + remove2);
		System.out.println("list : " + list);
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("박보배", 100));
		studentList.add(new Student("강건강", 40));
		studentList.add(new Student("차청춘", 70));
		System.out.println(studentList);
		
		studentList.remove(new Student("박보배", 100));
		System.out.println(studentList);
		
		System.out.println("\n equals()와  hashCode() 오버라이딩 안 하고 삭제하기!\n");
		for(int i = 0; i < studentList.size(); i++) {
			Student s = studentList.get(i);
			String name = s.getName();
			int score = s.getScore();
			if(name.equals("박보배") && score == 100) {
				studentList.remove(i);
			}
		}
				
		// 정렬 1. collections 이용
		Collections.sort(list);
		System.out.println("list 정렬1 : " + list);
				
		//Collections.sort(list, new ListComparator()); // 원래 버젼
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -o1.compareTo(o2);
			}
		}); // 익명 클래스
		System.out.println("list 정렬2 : " +list);
								
				
		// 정렬 2. List 이용
		//list.sort(new ListComparator()); // 원래 버젼
		list.sort((o1, o2) -> -o1.compareTo(o2)); // 람다 버젼
		System.out.println("list 정렬3 : " + list);
		list.sort(Comparator.reverseOrder()); // comparator 이용
		System.out.println("-----------------------------------");
		studentList.add(new Student("정재주",60));
		studentList.add(new Student("윤에의",70));
		studentList.add(new Student("송성실",20));
		studentList.add(new Student("강건강",70));
		
		Collections.sort(studentList);
		System.out.println("studentList 이름 오름차순 : " + studentList);
		
		Collections.sort(studentList, new ScoreComparator()); // 원래 버젼
		Collections.sort(studentList, (o1, o2) ->((Integer)o1.getScore()).compareTo(o2.getScore())); // 람다 버젼
		Collections.sort(studentList, Comparator.comparing(Student::getScore).reversed()); // Comparator 버젼
		System.out.println(" studentList 성적 내림차순 : " + studentList);
		
		studentList.sort(new StudentComparator());
		System.out.println("studentList 성적 오름차순, 이름 내림차순 : " + studentList);
		System.out.println("------------------------------------");
		
		l.add(100);
		l.add("문자열");
		l.add(false);
		l.add(studentList);
		System.out.println("다양한 타입 삽입 : " + l);
		
		// set(int index, E e):E
		String set = list.set(3, "박보배");
		System.out.println("set(3, \"박보배\") 결과 : " + set);
		System.out.println("list : " + list);
		
		// get(int index):E
		System.out.println("list.get(2) 결과 : " + list.get(2));
		System.out.println("list : " + list);
		
		// subList(int index1, int index2):List<E>
		System.out.println("list 추출 : " + list.subList(2, 5));
		System.out.println("list : " + list);
		
		// contains(Object o):boolean
		// indexOf(Object o):int
		System.out.println("남나눔이 list에 있나요? : " + list.contains("남나눔"));
		System.out.println("차청춘이 list에 있나요? : " + list.contains("차청춘"));
		System.out.println("list 중 남나눔의 위치는 어디인가요? : " + list.indexOf("남나눔"));
		System.out.println("list 중 차청춘의 위치는 어디인가요? : " + list.indexOf("차청춘"));
		
		// clear():void
		// isEmpty():boolean
		System.out.println("list : " + list);
		System.out.println("lost가 비어있나요? " + list.isEmpty());
		list.clear();
		System.out.println("list : " + list);
		System.out.println("lost가 비어있나요? " + list.isEmpty());
		
		
		
		
		
		
	}
}
