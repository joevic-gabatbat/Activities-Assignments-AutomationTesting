package activity3;

public class Adder implements Arithmetic {
	
	@Override
	public void add(int a, int b) {
		int sum = a + b;
		System.out.println("The Sum of those 2 number is " + sum);
	}

	public static void main(String[] args) {
		
		Adder am = new Adder();
		am.add(5, 5);

	}

}
