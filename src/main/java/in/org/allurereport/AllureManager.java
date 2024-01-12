package in.org.allurereport;

import org.testng.ITestContext;
import org.testng.ITestResult;

import java.util.LinkedList;

public final class AllureManager {

	private AllureManager() {}

	private static final String TEST_CASE = "Test case";

	public static void setAllureReportPrerequisites(String testCaseName, ITestContext testContext) {
		setTestCaseAttribute(testCaseName, testContext);
		removeAllureParameters();
	}

	private static void setTestCaseAttribute(String testCaseName, ITestContext testContext) {
		testContext.setAttribute(TEST_CASE, AllureThreadSafe.setTestCase(TEST_CASE, testCaseName));
	}

	private static void removeAllureParameters() {
		AllureThreadSafe.lifecycle.updateTestCase(testResult -> testResult.setParameters(new LinkedList<>()));
	}

	public static String setCurrentTestCaseName(ITestResult result) {
		AllureThreadSafe.lifecycle.updateTestCase(testResult -> testResult.setName(AllureThreadSafe.getTestCase(TEST_CASE)));
		return AllureThreadSafe.getTestCase(TEST_CASE);
	}
}
