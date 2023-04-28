package activity4;

import java.io.FileReader;

public class IOException {
	
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("SampleData.xlsx");
			System.out.println(fr.read());
			fr.close();
		} catch (Exception e) {
			System.out.println("File cannot be found...");
			e.printStackTrace();
		}
	}

}
