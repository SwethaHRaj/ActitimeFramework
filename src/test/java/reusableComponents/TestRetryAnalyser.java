package reusableComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetryAnalyser implements IRetryAnalyzer {

	
	int counter=1;
	int maxRetryLimit=1;
	@Override
	public boolean retry(ITestResult result) {
		if(counter<maxRetryLimit) {
			counter++;
			return true;
		}
		return false;
	}
}
