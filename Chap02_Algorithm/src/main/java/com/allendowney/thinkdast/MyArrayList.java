package com.allendowney.thinkdast;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 
 * @author mbk19
 * @param <T>
 */

//List인터페이스를 MyArrayList로 구현한다.
public class MyArrayList<T> implements List<T> {
	int size;  //요소의 개수를 저장한다.
	private T[] array; // 요소를 배열에 저장한다.

	@SuppressWarnings("unchecked")
	public MyArrayList() {
		size = 0;
		array = (T[]) new Object[10];
	}

	public static void main(String[] args) {
		MyArrayList<Integer> mal = new MyArrayList<>();
		mal.add(1);
		mal.add(2);
		mal.add(3);
		System.out.println(Arrays.toString(mal.toArray()) + " size = " + mal.size);

		mal.remove(new Integer(2));
		System.out.println(Arrays.toString(mal.toArray()) + " size= " + mal.size);
	}

	@Override
	public boolean add(T element) {
		if(size >= array.length) {
			T[] bigger = (T[]) new Object[array.length*2];
			System.arraycopy(array,0,bigger,0,array.length);
			array = bigger;
		}
		array[size] = element;
		size++;
		return true;
	}

	@Override
	public void add(int index, T element) {

		// 01. index validation 체크
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		// 02.element를 add하면서 array배열 사이즈를 늘린다.
		add(element);

		// 03.[index+1] 위치부터 한 칸 씩 뒤로 이동시킨다.
		for (int i = size - 1; i > index; i--) {
			array[i] = array[i - 1];
		}
		// 04.index위치에 element를 할당한다.
		array[index] = element;
	}

	@Override
	public boolean addAll(Collection<? extends T> collection) {

		// 01.플래그 선언 및 true 초기화
		boolean flag = true;

		// 02.
		for (T element : collection) {
			flag &= add(element); // flag = flag & add(element)
		}
		return flag;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> collection) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		size = 0;
	}

	@Override
	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		for (Object element : collection) {
			if (!contains(element)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}

	@Override
	public int indexOf(Object target) {
		// TODO: FILL THIS IN!
		for(int i=0; i<size; i++) {
			if(target.equals(array[i])) {
				return i;
			}
		}
		return -1;
	}

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
	public Iterator<T> iterator() {
		T[] copy = Arrays.copyOf(array, size);
		return Arrays.asList(copy).iterator();
	}

	@Override
	public int lastIndexOf(Object target) {

		// 01.target이 뒤에서부터 몇번째 인덱스와 같은지 확인 후 인덱스를 리턴
		for (int i = size - 1; i >= 0; i--) {
			if (equals(target, array[i])) {
				return i;
			}
		}
		// 02.같은 것이 없으면 -1반환
		return -1;
	}

	@Override
	public ListIterator<T> listIterator() {
		T[] copy = Arrays.copyOf(array, size);
		return Arrays.asList(copy).listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		T[] copy = Arrays.copyOf(array, size);
		return Arrays.asList(copy).listIterator(index);
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
	public T remove(int index) {
		// TODO: FILL THIS IN!
		T obj = get(index);
		
		for(int i=index; i<size-1; i++) {
			array[i] = array[i+1];
		}
		size--;
		return obj;
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
	public T set(int index, T element) {
		// TODO: FILL THIS IN!
		//=======================
		//내 코드.
		//=======================
//		if(index < 0 || index >= size) {
//			throw new IndexOutOfBoundsException();
//		}
//		
//		T previoslyElement = array[index];
//		array[index] = element;
//			
//		return previoslyElement;
		//=======================
		//답안
		//=======================
		T old = get(index);
		array[index] = element;
		return old;
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex) {
			throw new IndexOutOfBoundsException();
		}
		T[] copy = Arrays.copyOfRange(array,fromIndex,toIndex);
		return Arrays.asList(copy);
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(array, size);
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException();
	}
}
