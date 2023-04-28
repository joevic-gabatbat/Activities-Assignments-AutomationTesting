package activity4;

import java.util.Arrays;
import java.util.Collections;

public class Array {

	public static void main(String[] args) {
		int arr1[] = { 1, 3, 5 };
		int arr2[] = { 2, 4, 6 };
		int arrl1 = arr1.length;
		int arrl2 = arr2.length;
		int arrResult[] = new int[arrl1 + arrl2];
		System.arraycopy(arr1, 0, arrResult, 0, arrl1);
		System.arraycopy(arr2, 0, arrResult, arrl1, arrl2);
		Arrays.sort(arrResult);
		StringBuilder des = new StringBuilder(Arrays.toString(arrResult));
		des.replace(des.indexOf("]"), des.indexOf("]") + 1, "[");
		des.replace(des.indexOf("["), des.indexOf("[") + 1, "]");
		System.out.println(des.reverse());
	}
}
