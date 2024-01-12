package in.org.listeners;

import in.org.allurereport.AllureManager;
import io.qameta.allure.model.Status;
import org.testng.*;

import static in.org.allurereport.AllureLogger.addAllureLog;
import static in.org.allurereport.AllureLogger.allStackTraceLogOnTestFailure;

public class TestListeners implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		/*
		 * No implementation required as of now
		 */
	}

	@Override
	public void onFinish(ISuite suite) {
		/*
		 * No implementation required as of now
		 */
	}

	@Override
	public void onTestStart(ITestResult result) {
		/*
		 * No implementation required as of now
		 */
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testCaseName = AllureManager.setCurrentTestCaseName(result);
		addAllureLog(testCaseName, " test is passed", Status.PASSED);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testCaseName = AllureManager.setCurrentTestCaseName(result);
		addAllureLog(testCaseName, " test is failed", Status.FAILED);
		allStackTraceLogOnTestFailure(result, Status.FAILED);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testCaseName = AllureManager.setCurrentTestCaseName(result);
		addAllureLog(testCaseName, " test is skipped", Status.SKIPPED);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		/*
		 * No implementation required as of now
		 */
	}

	@Override
	public void onStart(ITestContext context) {
		/*
		 * No implementation required as of now
		 */
	}

	@Override
	public void onFinish(ITestContext context) {
		/*
		 * No implementation required as of now
		 */
	}
}
