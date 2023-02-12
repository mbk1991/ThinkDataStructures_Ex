package com.allendowney.thinkdast;

import org.junit.Before;
import org.junit.Test;

public class ListNodeTest {
	ListNode node0;
	ListNode node1;
	ListNode node2;
	ListNode node3;
	
	
	@Before
	public void setUp() {
		node1 = new ListNode(1);
		node2 = new ListNode(2);
		node3 = new ListNode(3);
		
		node1.next = node2;
		node2.next = node3;
		
		node0 = new ListNode(0,node1);
		
	}
	
	@Test
	public void TestLinkedList() {
		System.out.println(node0);
		System.out.println(node1);
		System.out.println(node2);
		System.out.println(node3);
	}

}
