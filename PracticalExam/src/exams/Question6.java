package exams;

public class Question6 {

	public static void main(String[] args) {
		int origNum = 12;
		int revNum = reversedNumber(origNum);
		System.out.println("The output is " + PowerOfNum(origNum, revNum));

	}

	public static int reversedNumber(int num) {

		int reversed = 0;

		System.out.println("Original Number: " + num);

		while (num != 0) {

			int digit = num % 10;
			reversed = reversed * 10 + digit;

			num /= 10;
		}

		System.out.println("Reversed Number: " + reversed);
		
		return reversed;
	}
	
	public static long PowerOfNum(int n, int r)
	  {
	    long ans = 1;
	    long mod = 1000000000 + 7;
	    for (int i = 1; i <= r; i++) {
	      ans *= n;
	      ans %= mod;
	    }
	    return ans;
	  }

}
