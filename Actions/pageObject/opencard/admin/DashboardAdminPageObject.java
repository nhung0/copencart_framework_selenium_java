package pageObject.opencard.admin;

import org.openqa.selenium.WebDriver;

import OpenCartAdminPageUI.ActionAdminPageUI;
import OpenCartAdminPageUI.DashboardAdminPageUI;
import OpenCartPageUIs.ActionPageUI;

import common.basePage;
import common.pageGeneratorManagerOpenCart;
import pageObjects.opencart.HomePageObject;

public class DashboardAdminPageObject extends ActionAdminPageObject {
	
	WebDriver driver;
	
	
	public DashboardAdminPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
	}


	public void clickRemovePopupButton() {
		waitForElementClickable(driver, DashboardAdminPageUI.REMOVE_BUTTON);
		clickToElementByJS(driver, DashboardAdminPageUI.REMOVE_BUTTON);
		
	}

	
	

	
	
	
	

	

	

	


	

	


	

	

}
