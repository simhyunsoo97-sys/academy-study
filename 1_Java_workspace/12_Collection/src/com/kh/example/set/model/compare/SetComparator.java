package com.kh.example.set.model.compare;

import java.util.Comparator;

public class SetComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// 정 시리즈 내림 차순
		return  o2.compareTo(o1);
		
		
	}
}
