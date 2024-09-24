package pageObjects.opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import OpenCartPageUIs.HomePageUI;
import common.pageGeneratorManagerOpenCart;


public class HomePageObject extends ActionPageObject{
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
	}
	public void clickToAccountLink() {
		waitForElementClickable(driver, HomePageUI.ACCOUNT_LINK);
		clickToElment(driver, HomePageUI.ACCOUNT_LINK);
		
		
	}
	
	
	
	
	
}
