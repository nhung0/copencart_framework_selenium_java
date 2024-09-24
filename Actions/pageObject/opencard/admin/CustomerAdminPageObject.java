package pageObject.opencard.admin;

import org.openqa.selenium.WebDriver;

import OpenCartAdminPageUI.ActionAdminPageUI;
import OpenCartAdminPageUI.CustomerAdminPageUI;
import OpenCartAdminPageUI.DashboardAdminPageUI;
import OpenCartPageUIs.ActionPageUI;

import common.basePage;
import common.pageGeneratorManagerOpenCart;
import pageObjects.opencart.HomePageObject;

public class CustomerAdminPageObject extends ActionAdminPageObject {
	
	WebDriver driver;
	
	
	public CustomerAdminPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
	}


	public void clickToToggleButton(String locator) {
		waitForElementClickable(driver,CustomerAdminPageUI.DYNAMIC_TOGGLE_BUTTON,locator);
		checkToElement(driver, CustomerAdminPageUI.DYNAMIC_TOGGLE_BUTTON,locator);
	}


	public String getDynamicCustomerValue(String locator) {
		waitForElementVisible(driver, CustomerAdminPageUI.DYNAMIC_CUSTOMER_VALUE, locator);
		return getElmentText(driver, CustomerAdminPageUI.DYNAMIC_CUSTOMER_VALUE, locator);
		
	
	}


	public String getDynamicStatusText(String cusEmail, String locator) {
		waitForElementVisible(driver, CustomerAdminPageUI.STATUS_TEXT, cusEmail,locator);
		return getElmentText(driver, CustomerAdminPageUI.STATUS_TEXT, cusEmail,locator);
	}


	

	
	
	
	
	
	
	


	

	
	
	
	

	

	

	


	

	


	

	

}
