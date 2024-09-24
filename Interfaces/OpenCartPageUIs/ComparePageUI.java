package OpenCartPageUIs;

import org.openqa.selenium.WebDriver;

import OpenCartPageUIs.AddressPageUI;
import OpenCartPageUIs.MyAccountSideBarPageUI;
import OpenCartPageUIs.WishListPageUI;

public class ComparePageUI {
	public static final String COMPARE_NAME_PRODUCE_LINK = "xpath=//div[@id='content']//a/strong[contains(text(),'%s')]";
	public static final String REMOVE_BUTTON = "xpath=//div[@id='content']//table//tbody[3]//a";
	public static final String EMPTY_COMPARE_MESSAGE = "xpath=//div[@id='content']//p[text()='You have not chosen any products to compare.']";
	public static final String COMPARE_BUTTON = "xpath=//div[@id='display-control']//a";
	public static final String COMPARE_BREADCRUMB = "xpath=//div[@id='display-control']//a";

	
}
