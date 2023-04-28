package exams;

public class Question1 {

	public static void main(String[] args) {
		 
		String s1 = "hello";
		String s2 = "worlds";
		
		int sl = s1.length() + s2.length();
		
		System.out.println("The length is " + sl);
		System.out.println(s1.compareTo(s2));
		System.out.println(capitalize(s1 +" "+ s2));

	}
	public static final String capitalize(String str)   
	{  
	if (str == null || str.length() == 0) return str;  
	return str.substring(0, 1).toUpperCase() + str.substring(1);  
	}

}
