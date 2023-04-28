package library;

public class App {

	public static void main(String[] args) {

		Excel excel = new Excel("./Data/TestData.xlsx");
		excel.setSheet("TestData - Account info");
//		excel.setSheet("TestData - Login Credentials");
//		excel.readSheetData();
//		String desiredValue = excel.getCellData(1, 2);
		String desiredValue = excel.getCellData(1, "LastName");
		System.out.println("The Lastname of Mike is " + desiredValue);
		
//		System.out.println("Column Number is " + excel.getColNumber("LastName"));
//		System.out.println("Total Number of Rows is " + excel.getRowCount());
		
		excel.closeFile();

	}

}
