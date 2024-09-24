package pageObjects.opencart;

import org.openqa.selenium.WebDriver;

import OpenCartPageUIs.LoginPageUI;
import OpenCartPageUIs.LogoutPageUI;
import OpenCartPageUIs.RegisterPageUI;

public class LogoutPageObject extends ActionPageObject{
	WebDriver driver;
	public LogoutPageObject(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
	}
	public void clickToContinueButton() {
		waitForElementClickable(driver, LogoutPageUI.LOGOUT_CONTINUE_BUTTON);
		clickToElementByJS(driver, LogoutPageUI.LOGOUT_CONTINUE_BUTTON);
		sleepInSecond(2);
	}
	
	


}
