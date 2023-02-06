package sort;

public class SelectionSort {
	/*
	 * 빅오 표기법 :최악의 경우 소요 시간을 표기.
	 * 상수O(1), 선형O(n), 이차O(n^2)
	 * 
	 * 01.i와 j의 위치를 바꾼다.
	 */
	public static void swapElements(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/*
	 * 02.최소 index를 반환한다.
	 */
	public static int indexLowest(int[] array,int start) {
		int lowIndex = start;
		for(int i=start; i<array.length; i++) {
			if(array[i]<array[lowIndex]) {
				lowIndex = i;
			}
		}
		return lowIndex;
	}
	
	/*
	 * 03.선택정렬로 배열을 정렬한다.
	 */
	public static void selectionSort(int[] array) {
		for(int i=0; i<array.length; i++) {
			swapElements(array,i,indexLowest(array,i));
		}
	}
}
