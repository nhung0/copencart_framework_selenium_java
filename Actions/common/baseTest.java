package common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

public class baseTest {
	private WebDriver driver;

	protected final Logger log;

	public baseTest() {
		log = LogManager.getLogger(getClass());
	}

	protected WebDriver getBrowserDriver(String browserName) {
		browserList browser = browserList.valueOf(browserName.toUpperCase());

		if (browser == browserList.FIREFOX) {

		} else if (browser == browserList.CHROME) {

			driver = new ChromeDriver();

		} else if (browser == browserList.CHROME_HEADLESS) {

		} else if (browser == browserList.EDGE) {

			driver = new EdgeDriver();

		} else if (browser == browserList.FIREFOX_HEADLESS) {

			driver = new FirefoxDriver();

		} else {
			throw new RuntimeException("browser name is not correct");
		}
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.get("https://demo.opencart.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(globalConstants.LONG_TIMEOUT));
		return driver;
	}

	protected WebDriver getBrowserEnvironment(String browserName, String serverName) {
		browserList browser = browserList.valueOf(browserName.toUpperCase());
		if (browser == browserList.FIREFOX) {

			driver = new FirefoxDriver();

		} else if (browser == browserList.CHROME) {

			driver = new ChromeDriver();

		} else if (browser == browserList.OPERA) {

		} else if (browser == browserList.EDGE) {

			driver = new EdgeDriver();

		} else if (browser == browserList.IE) { // không chạy đc

		} else if (browser == browserList.SAFARI) { // không chạy đc

		} else {
			throw new RuntimeException("browser name is not correct");

		}

		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.get(getUrlByServerName(serverName));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(globalConstants.LONG_TIMEOUT));
		return driver;
	}

	private String getUrlByServerName(String serverName) {
		String url = null;
		serverList server = serverList.valueOf(serverName.toUpperCase());
		switch (server) {
		case DEV: {
			url = "https://demo.nopcommerce.com/";
			break;
		}
		case TEST: {
			url = "https://test.nopcommerce.com/";
			break;
		}
		case STATING: {
			url = "https://staging.nopcommerce.com/";
			break;
		}
		default:
			new IllegalArgumentException("unexpected value: " + serverName);
		}
		return url;

	}

	protected WebDriver getBrowserDriver(String url, String browserName) {

		browserList browser = browserList.valueOf(browserName.toUpperCase());
		if (browser == browserList.FIREFOX) {
		
			driver = new FirefoxDriver();

		} else if (browser == browserList.CHROME) {
			Map<String, Object> prefs = new HashMap<String, Object>();

			prefs.put("profile.default_content_setting_values.notifications", 2);

			prefs.put("credentials_enable_service", false);

			prefs.put("profile.password_manager_enabled", false);

			prefs.put("autofill.profile_enabled", false);

			ChromeOptions options = new ChromeOptions();

			options.setExperimentalOption("prefs", prefs); 
			options.addArguments("--disable-notifications");

			driver = new ChromeDriver(options);

			
		} else if (browser == browserList.EDGE) {
			

			driver = new EdgeDriver();

		} else {
			throw new RuntimeException("browser name is not correct");

		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(globalConstants.LONG_TIMEOUT));
		driver.get(url);
	
		return driver;
	}

	public String randomEmail() {
		Random rand = new Random();
		return "abc" + rand.nextInt(99999) + "@gmail.com";

	}

	protected void closeBrowser() {
		String cmd = null;
		try {
			String osName = globalConstants.OS_NAME.toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI 'IMAGENAME eq " + browserDriverName + "*'";
			} else {
				cmd = "pkill " + browserDriverName;
			}
			// đóng browser
			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			// quit
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				System.out.println(" -------------------------- PASSED -------------------------- ");
			} else {
				System.out.println(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				System.out.println(" -------------------------- PASSED -------------------------- ");
			} else {
				System.out.println(" -------------------------- FAILED -------------------------- ");

			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			System.out.println(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			System.out.println(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	@BeforeSuite
	public void deleteFileInReport() {
		// Remove all file in ReportNG screenshot (image)
		deleteAllFileInFolder("reportNGImage");

		// Remove all file in Allure attachment (json file)
		deleteAllFileInFolder("allure-json");
	}

	public void deleteAllFileInFolder(String folderName) {
		try {
			String pathFolderDownload = globalConstants.RELATIVE_PROJECT_PATH + File.separator + folderName;
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			if (listOfFiles.length != 0) {
				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
						new File(listOfFiles[i].toString()).delete();
					}
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

}
