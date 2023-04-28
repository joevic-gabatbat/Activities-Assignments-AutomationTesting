package activity2;

public class Constructors {
	
	private String name;
	
	public Constructors(String n) {
		this.name = n;
	}
	
	public String getName() {
		return name;
	}

	public static void main(String[] args) {
		
		// 5. This is for Constructor
		Constructors cons = new Constructors("Joe");
		System.out.println("Hi! My name is " + cons.getName());

	}

}
