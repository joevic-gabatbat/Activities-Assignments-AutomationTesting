package test1;

public class SampleClass1 {
	static int num1 = 999;
	static int num2 = 5;
	
	public static void addition(int a) {
		int sum = a + num2;
		System.out.println("Sum of 2 numbers is " + sum);
	}
	
	public static void multiplication(int a) {
		num1 = 10;
		int prod = num1 * a;
		System.out.println("Product of 2 numbers is " + prod);
	}
}
