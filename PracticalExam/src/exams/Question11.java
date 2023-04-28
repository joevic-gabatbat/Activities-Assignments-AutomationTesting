package exams;

public class Question11 {
	
	public static void main(String[] args) {
		
		int x = 5;
		int fact = 1;
		
		for(int i = 1; i <= x; i++) {
			fact = fact * i;
		}
		
		System.out.printf("The Factorial of %1d is %02d.", x, fact);
		
	}
}
