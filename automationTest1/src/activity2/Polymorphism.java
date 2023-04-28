package activity2;

public class Polymorphism extends ParentClass{
		
		// Overloading to addition method
		static int addition(int num1, int num2) {
			return num1 + num2;
		}
		
		static int addition(int num1, int num2, int num3) {
			return num1 + num2 + num3;
		}
		
		// Overiding the eating method from ParentClass
		public void eating() {
			System.out.println("Dog is eating...");
		}

	public static void main(String[] args) {
		
		// 7. This is for Polymorphism
		Polymorphism pm = new Polymorphism();
		
		// Method Overloading
		System.out.println(pm.addition(20, 25));
		System.out.println(pm.addition(20, 25, 55));
		
		// Method Overiding
		ParentClass cl1 = new ParentClass();
		cl1.eating();
		pm.eating();

	}

}
