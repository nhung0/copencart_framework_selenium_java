package pageObject.opencard.admin;

import org.openqa.selenium.WebDriver;

import OpenCartPageUIs.ActionPageUI;

import common.basePage;
import common.pageGeneratorManagerOpenCart;
import pageObjects.opencart.HomePageObject;

public class StartAdminPageObject extends ActionAdminPageObject {
	
	WebDriver driver;
	
	
	public StartAdminPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
	}

	

}
