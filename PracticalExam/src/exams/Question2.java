package exams;

public class Question2 {
 
	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 7, 5 };
//		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int s = 12;
//		int s = 15;
		int n = a.length;

		int[] result = subArraySum(a, n, s);
		for (int val : result) {
//			System.out.print(val + " ");
			System.out.print((val + 1) + " ");
		}
	}

	public static int[] subArraySum(int a[], int n, int sum) {

		int start = 0;
		int end = 1;

		int sumNum = a[0];

		while (end <= n) {
			while (sumNum > sum && start < end - 1) {
				sumNum = sumNum - a[start];
				start++;
			}
			if (sumNum == sum) {
				return new int[] { start, end - 1 };
			}
			if (end < n)
				sumNum = sumNum + a[end];

			end++;
		}
		return new int[] { -1 };

	}

}
