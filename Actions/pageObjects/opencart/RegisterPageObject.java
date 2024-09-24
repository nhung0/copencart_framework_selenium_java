package pageObjects.opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import OpenCartPageUIs.ActionPageUI;
import OpenCartPageUIs.RegisterPageUI;


public class RegisterPageObject extends ActionPageObject{
	WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
	}
	
	

	public boolean isErrorEmailMessageDisplayed() {
	    waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
	    String validationMessage = getElementValidationMessage(driver, RegisterPageUI.EMAIL_TEXTBOX);

	    // Get the browser name
	    org.openqa.selenium.Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = capabilities.getBrowserName().toLowerCase();

	    if (browserName.contains("chrome") || browserName.contains("edge")) {
	        return validationMessage.contains("Please include an '@' in the email address.");
	    } else if (browserName.contains("firefox")) {
	        return validationMessage.contains("Please enter an email address.");
	    }
	    return false;
	}
	
	public void clickToNewsLetterToggleButton() {
		waitForElementClickable(driver, RegisterPageUI.NEWSLETTER_TOGGLE_BUTTON);
		clickToElementByJS(driver, RegisterPageUI.AGREE_TOGGLE_BUTTON);
		
		
	}
	
	public void clickToAgreeToggleButton() {
		waitForElementClickable(driver, RegisterPageUI.AGREE_TOGGLE_BUTTON);
		clickToElementByJS(driver, RegisterPageUI.AGREE_TOGGLE_BUTTON);
		
		
	}
	
	
	public boolean isSuccessfulMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.SUCCESS_REGISTER_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.SUCCESS_REGISTER_MESSAGE);
	}



	public boolean isErrorPasswordMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.ERROR_PASSWORD_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.ERROR_PASSWORD_MESSAGE);
	}



	


	
	
	
	






	



	
	

}
