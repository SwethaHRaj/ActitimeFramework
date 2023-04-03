package reusableComponents;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {

	public void selectFromDropdown(WebElement we, String option) {
		Select s = new Select(we);
		s.selectByValue(option);
	}

	public void selectRadioButton(List<WebElement> wes, String fieldName, String option) throws Exception {
		boolean flag = false;
		for (WebElement we : wes)
			if (we.getText().equalsIgnoreCase(option)) {
				we.click();
				flag = true;
				break;
			}
		if (flag == false)
			throw new Exception(option + " Radio button Option is not available");
	}

	public void selectCheckboxes(List<WebElement> wes, String options) {
		String[] arr = options.split(",");
		List<String> opts = new ArrayList<String>();
		for (String ele : arr) {
			opts.add(ele);
		}
		for (WebElement we : wes)
			for (String option : opts)
				if (we.getText().equalsIgnoreCase(option)) {
					we.click();
					break;
				}
	}

	public void uploadPicture(WebElement we, String filePath) {
		File f = new File(filePath);
		String absoluteFilePath = f.getAbsolutePath();
		we.sendKeys(absoluteFilePath);
	}

	// -----------ERROR VALIDATION Methods-------------------

	public List<String> getDropDownOptionsAsList(WebElement dd_FuelType) {
		Select s = new Select(dd_FuelType);
		List<WebElement> allOptions = s.getOptions();
		List<String> actualOptions = new ArrayList<String>();
		for (WebElement option : allOptions)
			actualOptions.add(option.getText());
		return actualOptions;
	}

}
