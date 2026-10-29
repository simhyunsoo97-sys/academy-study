package com.kh.example.set.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

import com.kh.example.set.model.compare.SetComparator;
import com.kh.example.set.model.vo.Dog;

public class SetController {
	public void doSet() {
		HashSet<String> set = new HashSet();  // 타입 추론
		
		boolean bool1 = set.add("철수");
		boolean bool2 = set.add("현수");
		boolean bool3 = set.add("정수");
		System.out.printf("bool1 : %b, bool2 : %b, bool3 : %b\n", bool1,  bool2, bool3);
		System.out.println("set : " + set);
		
		boolean bool4 = set.add("철수");
		System.out.println("bool4 : " + bool4);
		System.out.println("set : " + set);
		
		Set<Dog> dogSet = new HashSet<Dog>();
		dogSet.add(new Dog("철수", 2.2));
		dogSet.add(new Dog("현수", 3.3));
		dogSet.add(new Dog("정수", 2.0));
		System.out.println(dogSet);
		
		dogSet.add(new Dog("철수", 2.2));
		System.out.println(dogSet);
		
		Set<String> set2 = new LinkedHashSet<>();
		set2.add("수정");
		set2.add("민정");
		set2.add("혜정");
		set2.add("유정");
		System.out.println("set2 : " + set2);
		
		set2.add("기정");
		set2.add("소정");
		set2.add("희정");
		set2.add("혜정");
		System.out.println("set2 : " + set2);
		
		TreeSet<String> set3 = new TreeSet<String>(set2);
		System.out.println("set3 : " + set3);
		
		//TreeSet<String> set4 = new TreeSet<String>(new SetComparator());
		//TreeSet<String> set4 = new TreeSet<String>((o1, o2) -> o2.compareTo(o1));
		TreeSet<String> set4 = new TreeSet<String>(Comparator.reverseOrder());
		set4.addAll(set2);
		set4.add("미정");
		System.out.println("set4 : " + set4);
		
		System.out.println("-------------------------------------");
		
		// 1. for-each문 이용
		//for(int i = 0; i < set4.size(); i++) {
		//	set4.get
		//}
		for(String str:set4) {
			System.out.println(str);			
		}	
		// 2. list화 하기
		ArrayList<String> list = new ArrayList<>(set4);		
		for(int i = 0; i < list.size(); i++) {
		System.out.println(list.get(i));
		}
		
		System.out.println();
		
		// 3. iterator 사용하기
		Iterator<String> it = set4.iterator();
		while(it.hasNext()) {
			String element = it.next();
			System.out.println(element);
		}
		while(it.hasNext()) {
			System.out.println("re : " + it.next());
		}
		
		System.out.println();
		
		// ListIterator : 양방향, Iterator의 자식
		ListIterator<String> lit = list.listIterator();
		while(lit.hasNext()) {
			System.out.println("next : " + lit.next());
		}
		while(lit.hasPrevious()) {
			System.out.println("prev : " + lit.previous());
		}
		
	}
}
