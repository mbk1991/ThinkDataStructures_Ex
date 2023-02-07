package com.allendowney.thinkdast;

import org.junit.Test;

public class MyArrayListTest {
	
	@Test
	public void add() {
		MyArrayList<Integer> mal = new MyArrayList<Integer>();
		mal.add(1);
		mal.add(2);
	}
}
