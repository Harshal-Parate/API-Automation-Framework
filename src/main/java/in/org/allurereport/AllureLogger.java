package in.org.allurereport;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.testng.ITestResult;

import java.util.Arrays;

public final class AllureLogger {

	private AllureLogger() {}

	public static void addAllureLog(String msg) {
		Allure.step(msg);
	}

	public static void addAllureLog(ITestResult result, String msg) {
		Allure.step("'" + result.getTestContext().getAttribute("Test case") + "'" + msg);
	}

	public static void addAllureLog(String testCaseName, String msg, Status status) {
		Allure.step("'" + testCaseName + "'" + msg, status);
	}

	public static void allStackTraceLogOnTestFailure(ITestResult result, Status status) {
		Allure.step(result.getThrowable().toString(), status);
		Allure.step(Arrays.toString(result.getThrowable().getStackTrace()), status);
	}
}
