package pageObject.opencard.admin;

import org.openqa.selenium.WebDriver;

import OpenCartAdminPageUI.ActionAdminPageUI;
import OpenCartAdminPageUI.DashboardAdminPageUI;
import OpenCartAdminPageUI.ProductAdminPageUI;
import OpenCartPageUIs.ActionPageUI;

import common.basePage;
import common.pageGeneratorManagerOpenCart;
import pageObjects.opencart.HomePageObject;

public class ProductAdminPageObject extends ActionAdminPageObject {
	
	WebDriver driver;
	
	
	public ProductAdminPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
	}


	
	
	public void clickToDashboardLink() {
		waitForElementClickable(driver, ProductAdminPageUI.DASHBOARD_LINK);
		clickToElementByJS(driver, ProductAdminPageUI.DASHBOARD_LINK);
		
	}



	
	
	

	
	
	
	

	

	

	


	

	


	

	

}
