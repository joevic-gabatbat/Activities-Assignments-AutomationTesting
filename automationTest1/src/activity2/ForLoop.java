package activity2;

public class ForLoop {

	public static void main(String[] args) {

		// 1. This is for ForLoop
		int num = 5;
		for (int i = 1; i <= num; ++i) {
			for (int j = 1; j <= i; ++j) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
}
