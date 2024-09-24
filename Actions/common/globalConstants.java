package common;

import java.io.File;

public class globalConstants {
	
	public static final String DEV_USER_URL ="https://demo.nopcommerce.com/";
	public static final String DEV_ADMIN_URL ="https://admin-demo.nopcommerce.com/login?ReturnUrl=/admin/";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT =20;
	public static final long LONGG_TIMEOUT =25;
	public static final String DEV_ADMIN_USERNAME ="admin@...";
	public static final String DEV_ADMIN_PASSWORD ="admin";
	public static final String ADMIN_OPENCART_USERNAME ="demo";
	public static final String ADMIN_OPENCART_PASSWORD ="demo";

	public static final String OS_NAME = System.getProperty("os.name");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String RELATIVE_PROJECT_PATH =System.getProperty("user.dir");
	public static final String UPLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "uploadfiles" + File.separator;
	public static final String DOWNLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "downloadfiles" + File.separator;
	public static final String BROWSER_EXTENSION = RELATIVE_PROJECT_PATH + File.separator + "browserExtensions" + File.separator;
	public static final String BROWSER_LOG = RELATIVE_PROJECT_PATH + File.separator + "browserLogs" + File.separator;
	public static final String RESOURCES_PATH = RELATIVE_PROJECT_PATH + File.separator + "resources" + File.separator;
	public static final String ENVIRONMENT_PATH = RELATIVE_PROJECT_PATH + File.separator + "environmentConfig" + File.separator;
	public static final String EXTENT_PATH = RELATIVE_PROJECT_PATH + File.separator + "extentReport" + File.separator;

	// hang so trong global la toan cuc cho tat ca cac class trong framework deu su dung duoc
	
	
	
	
	
}
