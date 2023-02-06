package sort;

import org.junit.jupiter.api.Test;

class SelectionSortTest {
	@Test
	void test() {
		int[] arr = {1,5,7,6,4,2,32,15};
		SelectionSort.selectionSort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
