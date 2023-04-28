package library;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	String filePath = "";
	FileInputStream fis = null;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	HashMap<String, Integer> colNums = null;
	int rowCount = 0;

	public Excel(String filePath) {

		try {
			this.filePath = filePath;
			// This will find the file
			FileInputStream fis = new FileInputStream(new File(this.filePath));
			System.out.println("File Input Stream Successfully...");
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// This will read the sheet on the file based on the provided sheet name
	public void setSheet(String sheetName) {
		sheet = wb.getSheet(sheetName);
		populateColumns();
		rowCount = sheet.getLastRowNum();
	}
	
	// This will count all the Rows that has a value
	public int getRowCount() {
		return rowCount+1;
	}
	
	// Populate the Column Names with Column Numbers using HashMap
	public void populateColumns() {
		colNums = new HashMap<String, Integer>();
		
		int colIndex = 0;
		Row row = sheet.getRow(0);
		Iterator<Cell> cells = row.cellIterator();
		
		while(cells.hasNext()) {
			Cell cell = cells.next();
			String colName = cell.getStringCellValue();
			colNums.put(colName, colIndex);
			colIndex++;
		}
	}
	
	// This will check for the Column Number based on Column Name
	public int getColNumber(String colName) {
		return colNums.get(colName);
	}
	
	// This will read cell dynamically based on Column Names
	public String getCellData(int rowNum, String colName) {
		String cellValue = "";
		int colNum = getColNumber(colName);
		cellValue = getCellData(rowNum, colNum);
		return cellValue;
	}
	
	

	// This will read a specific cell on the selected sheet
	public String getCellData(int rowNum, int colNum) {
		String cellValue = "";
		try {
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(colNum);

			if (cell.getCellType() == CellType.STRING) {
				cellValue = cell.getStringCellValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cellValue;
	}

	// This will read the sheet
	public void readSheetData() {
		Iterator<Row> rows = sheet.rowIterator();
		while (rows.hasNext()) {
			Row curRow = rows.next();
			Iterator<Cell> cells = curRow.cellIterator();
			while (cells.hasNext()) {
				Cell curCell = cells.next();
				CellType cType = curCell.getCellType();

				// This will check the value if String or Number and will return an value
				String value = "";
				if (cType == CellType.STRING) {
					value = curCell.getStringCellValue();
				} else if (cType == CellType.NUMERIC) {
					value = "" + curCell.getNumericCellValue();
				}

				System.out.println("Value : " + value);
			}
		}
	}
	
	// This will close FileInputStream and Workbook to prevent memory leak
	public void closeFile() {
		try {
			if(fis!=null) {
				fis.close();
				wb.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
