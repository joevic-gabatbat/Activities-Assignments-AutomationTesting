package exams;

public class Question12 {

	public static void main(String[] args) {

		long sum = 0, n = 10;
		int i = 1;
		while (i <= n / 2) {
			if (n % i == 0) {
				sum = sum + i;
			}
			i++;
		}
		if (sum == n) {
			System.out.println(n + " is a perfect number.");
		} else {
			System.out.println(n + " is not a perfect number.");
		}
	}

}
