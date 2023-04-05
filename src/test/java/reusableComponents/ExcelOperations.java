package reusableComponents;

import java.io.File;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {

	// Path hard coded

	File f;
	Workbook wb;
	Sheet sh;

	public ExcelOperations(String sheetName) {
		f = new File("./src/test/resources/ActitimeTestData.xlsx");
		try {
			wb = WorkbookFactory.create(f);
		} catch (Exception e) {
		}
		sh = wb.getSheet(sheetName);
	}

	public HashMap<String, String> getTestDataInMap(int row) throws Exception {

		HashMap<String, String> hm = new HashMap<String, String>();
		for (int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
			hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(row).getCell(i).toString());
		}
		return hm;
	}

	public int getRowCount() {
		return sh.getLastRowNum();
	}

	public int getCellCount() {
		return sh.getRow(0).getLastCellNum();
	}
}
