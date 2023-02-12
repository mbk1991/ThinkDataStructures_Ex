package com.allendowney.thinkdast;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest extends MyArrayListTest {
	protected List<Integer> list;
	protected List<Integer> mylist;
	
	@Before
	public void setUp() throws Exception{
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		mylist = new MyLinkedList<Integer>();
		mylist.addAll(list);
	}
	
	@Test
	public void TestIndexOf() {
		assertEquals(mylist.indexOf(2),1);
	}
}
