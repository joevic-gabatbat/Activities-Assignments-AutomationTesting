package exams;

import java.util.HashSet;

public class Question9 {

	public static void main(String[] args) {
		
		int a[] = { 5, 3, 1, 2, 3};
        int b[] = { 4, 5, 1, 2, 3 };
 
        getUnion(a, a.length, b, b.length);
	}

	static void getUnion(int a[], int n, int b[], int m) {

		// Defining set container s
		HashSet<Integer> s = new HashSet<>();

		// Inserting array elements in s
		for (int i = 0; i < n; i++)
			s.add(a[i]);

		for (int i = 0; i < m; i++)
			s.add(b[i]);
		System.out.print("Total length or arrays after union : " + s.size() + "\n");
		System.out.print("The union set of both arrays is : " + s.toString() + " ");
	}
}
