package exams;

public class Question8 {

	public static void main(String[] args) {
		
		System.out.println(inSequence(1, 3, 2));
	}

	static int inSequence(int a, int b, int c) {
		
		double z = (double) (b - a) / c + 1;
		int h = (int) z;

		if (c == 0 && a == b)
			return 1;
		if (z == h && z > 0)
			return 1;

		return 0;
	}

}
