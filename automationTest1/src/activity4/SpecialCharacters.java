package activity4;

public class SpecialCharacters {

	public static void main(String[] args) {
		
		String s = "HJsjha*asdj@Poa!asd///KkdsaK!!!";
		System.out.println(s.replaceAll("[a-z A-Z]+", ""));

	}

}
