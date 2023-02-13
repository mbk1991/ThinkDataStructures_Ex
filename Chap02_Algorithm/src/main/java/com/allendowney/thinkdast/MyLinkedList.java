/**
 * 
 */
package com.allendowney.thinkdast;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements List<E> {

	/**
	 * Node is identical to ListNode from the example, but parameterized with T
	 *
	 * @author downey
	 *
	 */
	private class Node {
		public E data;
		public Node next;

		public Node(E data) {
			this.data = data;
			this.next = null;
		}

		@SuppressWarnings("unused")
		public Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}

		public String toString() {
			return "Node(" + data.toString() + ")";
		}
	}

	private int size; // keeps track of the number of elements
	private Node head; // reference to the first node

	/**
	 *
	 */
	public MyLinkedList() {
		head = null;
		size = 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// run a few simple tests
		List<Integer> mll = new MyLinkedList<Integer>();
		mll.add(1);
		mll.add(2);
		mll.add(3);
		System.out.println(Arrays.toString(mll.toArray()) + " size = " + mll.size());

		mll.remove(new Integer(2));
		System.out.println(Arrays.toString(mll.toArray()) + " size = " + mll.size());
	}

	@Override
	public boolean add(E element) {
		// 01.head node가 null인지 체크한다.
		if (head == null) {
			// 02.null이라면 head에 Node객체를 할당한다.
			head = new Node(element);
		} else {
			// 03.null이 아니라면 node.next가 null일 때까지 리스트를 탐색한다.
			Node node = head;
			// loop until the last node
			for (; node.next != null; node = node.next) {
			}
			// 04.마지막 node의 next에 Node객체를 할당한다.
			node.next = new Node(element);
		}
		// 05.size를 1 올려준다.
		size++;
		return true;
	}

	@Override
	public void add(int index, E element) {
		// TODO: FILL THIS IN!
		if (index == 0) {
			head = new Node(element, head);
		} else {
			Node node = getNode(index - 1);
			node.next = new Node(element, node.next);
		}
		size++;

		// 내 풀이는 size++이 없고 비효율적인 느낌
		// 00.add할 node 객체를 만든다.
//		Node addNode = new Node(element);
//		if(index == 0) {
//			//01.제일 앞에 add할 경우 next에 head를 달아준다.
//			addNode.next = head;
//		}else if(index==size) {
//			//02.제일 뒤에 add할 경우 매개변수 1개짜리add를 사용한다.
//			add(element);
//		}else {
//			//03.중간에 삽입할 경우 
//			//삽입하는 node.next = 원래 index node
//			//원래 index 이전 node.next = 삽입하는 node
//			
//			Node originNode = getNode(index);
//			Node beforeNode = getNode(index-1);
//			
//			beforeNode.next = addNode;
//			addNode.next = originNode;
//		}
	}

	@Override
	public boolean addAll(Collection<? extends E> collection) {
		boolean flag = true;
		for (E element : collection) {
			flag &= add(element);
		}
		return flag;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> collection) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	@Override
	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		for (Object obj : collection) {
			if (!contains(obj)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public E get(int index) {
		Node node = getNode(index);
		return node.data;
	}

	/**
	 * Returns the node at the given index.
	 * 
	 * @param index
	 * @return
	 */
	private Node getNode(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}

	@Override
	public int indexOf(Object target) {
		// TODO: FILL THIS IN!
		Node node = head;
		for (int i = 0; i < size; i++) {
			if (equals(target, node.data)) {
				return i;
			}
			node = node.next;
		}
		return -1;

		// 내 풀이
//		if(target == null) {
//			throw new NullPointerException();
//		}
//		//01.반환할 index를 선언하고 0으로 초기화한다.
//		int index = 0;
//		//02.head부터 마지막 node요소까지 매개변수와 data를 비교한다.
//		//같은 경우 index를 반환한다.
//		for(Node node = head; node == null; node = node.next) {
//			if(equals(node.data,target)) {
//				return index;
//			}
//			
//			//03. for문을 반복할 때마다 index를 +1해준다.
//			index++;
//		}
//		//04.for문이 끝난 경우 -1을 반환한다.
//		return -1;
	}

	/**
	 * Checks whether an element of the array is the target.
	 *
	 * Handles the special case that the target is null.
	 *
	 * @param target
	 * @param object
	 */
	private boolean equals(Object target, Object element) {
		if (target == null) {
			return element == null;
		} else {
			return target.equals(element);
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<E> iterator() {
		E[] array = (E[]) toArray();
		return Arrays.asList(array).iterator();
	}

	@Override
	public int lastIndexOf(Object target) {
		Node node = head;
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (equals(target, node.data)) {
				index = i;
			}
			node = node.next;
		}
		return index;
	}

	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return null;
	}

	@Override
	public boolean remove(Object obj) {
		int index = indexOf(obj);
		if (index == -1) {
			return false;
		}
		remove(index);
		return true;
	}

	@Override
	public E remove(int index) {
		// TODO: FILL THIS IN!
		E element = get(index);
		if (index == 0) {
			head = head.next;
		} else {
			Node node = getNode(index-1);
			node.next = node.next.next;
		}
		size--;
		return element;

		// 내 풀이
		// 00.getNode()로 인덱스 체크 및 이전 node 할당.
//		Node previousNode = getNode(index);
//		if(index == 0) {
//			//01.index가 0(head)인 경우
//			head = getNode(index+1);
//		}else if(index == size-1) {
//			//02.index가 size-1(끝)인 경우
//			getNode(index-1).next = null;
//		}else {
//			//03.중간의 index인 경우
//			getNode(index-1).next = getNode(index+1);
//		}
//		return previousNode.data;
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		boolean flag = true;
		for (Object obj : collection) {
			flag &= remove(obj);
		}
		return flag;
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E set(int index, E element) {
		Node node = getNode(index);
		E old = node.data;
		node.data = element;
		return old;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex) {
			throw new IndexOutOfBoundsException();
		}
		// TODO: classify this and improve it.
		int i = 0;
		MyLinkedList<E> list = new MyLinkedList<E>();
		for (Node node = head; node != null; node = node.next) {
			if (i >= fromIndex && i <= toIndex) {
				list.add(node.data);
			}
			i++;
		}
		return list;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		int i = 0;
		for (Node node = head; node != null; node = node.next) {
			// System.out.println(node);
			array[i] = node.data;
			i++;
		}
		return array;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException();
	}
}
