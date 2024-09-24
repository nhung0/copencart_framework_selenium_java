package reportConfig1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import common.globalConstants;

public class ExtentManager {
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(globalConstants.RELATIVE_PROJECT_PATH + "/extentReport/ExtentReportV5.html");
		reporter.config().setReportName("BankGuru HTML Report");
		reporter.config().setDocumentTitle("BankGuru HTML Report");
		reporter.config().setTimelineEnabled(true);
		reporter.config().setEncoding("utf-8");
		reporter.config().setTheme(Theme.DARK);

		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Company", "Bank");
		extentReports.setSystemInfo("Project", "BankGuru");
		extentReports.setSystemInfo("Team", "BankGuru Testing");
		extentReports.setSystemInfo("JDK version", globalConstants.JAVA_VERSION);
		return extentReports;
	}
}
