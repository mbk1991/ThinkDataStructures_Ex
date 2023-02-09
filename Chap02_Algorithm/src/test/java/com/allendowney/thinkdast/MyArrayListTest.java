package com.allendowney.thinkdast;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class MyArrayListTest {

	protected List<Integer> myList;
	protected List<Integer> list;

	@Before
	public void setUp() throws Exception {
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		myList = new MyArrayList<Integer>();
		myList.addAll(list);
	}

	@Test
	public void testMyList() {
		assertEquals(myList.size(), 3);
	}

	@Test
	public void testSet() {
		Integer val = myList.set(1, 5);
		assertEquals(val, 2);

		val = myList.set(0, 6);
		assertEquals(val, 1);

		val = myList.set(2, 7);
		assertEquals(val, 3);

		assertThat(myList.get(0), is(new Integer(6)));
		assertThat(myList.get(1), is(new Integer(5)));
		assertThat(myList.get(2), is(new Integer(7)));

		try {
			myList.set(-1, 0);
			fail();
		} catch (IndexOutOfBoundsException e) {
		}

		try {
			myList.set(4, 0);
			fail();
		} catch (IndexOutOfBoundsException e) {
		}
	}

	@Test
	public void add() {
		MyArrayList<Integer> mal = new MyArrayList<Integer>();
		mal.add(1);
		mal.add(2);
		for (int i = 0; i < mal.size; i++) {
			System.out.println(mal.get(i));
		}
	}
}
