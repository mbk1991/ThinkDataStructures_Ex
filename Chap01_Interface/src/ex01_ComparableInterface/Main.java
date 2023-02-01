package ex01_ComparableInterface;

public class Main {
	public static void main(String[] args) {
		Integer num1 = new Integer();
		num1.value = 3;

		Integer num2 = new Integer();
		num2.value = 10;

		int result = num1.compareTo(num2);
		System.out.println("result = " + result);
	}
}
