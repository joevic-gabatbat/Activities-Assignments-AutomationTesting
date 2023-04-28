package test1;

public class SampleTest2 {
	
	String hello = "Hello World!";//Global Variable
	static int num1 = 12;// Static Variable
	
	public static int method() {
		int num2 = 13;//Local Variable
		return num2;
	}
	
	public static void main(String[] args) {
		
		int num3 = 14;//Instance Variable;
		
		num1 = 15;
		
		
		System.out.println("Global Variable is String hello");
		System.out.println("Static Variable is num1 with value of " + num1);
		System.out.println("Local Variable is num2 with value of " + method());
		System.out.println("Instance Variable is num1 with value of " + num3);
		
	}

}
