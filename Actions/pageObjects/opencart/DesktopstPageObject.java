package pageObjects.opencart;

import org.openqa.selenium.WebDriver;

import OpenCartPageUIs.ActionPageUI;
import OpenCartPageUIs.DesktopsUI;

public class DesktopstPageObject extends ActionPageObject{
	WebDriver driver;
	public DesktopstPageObject(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
	}
	
	
	public void clickToWishListLabelButton() {
		waitForElementClickable(driver, DesktopsUI.WISHLIST_LABEL_BUTTON);
		clickToElementByJS(driver, DesktopsUI.WISHLIST_LABEL_BUTTON);
		sleepInSecond(3);
		
	}
	
	
	
	public void clickToAlert() {
		acceptAlert(driver);
	}
	public void enterToTextBoxArea(String locator, String value) {
		waitForElementVisible(driver, DesktopsUI.TEXTBOX_AREA, locator);
		sendKeysToElment(driver, DesktopsUI.TEXTBOX_AREA, value, locator);
	}
	public String getDynamicValueTexbox(String locator) {
		waitForElementVisible(driver, ActionPageUI.DYNAMIC_TEXTBOX, locator);
		return getElmentAttribute(driver, ActionPageUI.DYNAMIC_TEXTBOX, "value", locator);
	}


	public void clickToTableCartButton() {
		waitForElementClickable(driver, DesktopsUI.CART_VIEW_BUTTON);
		clickToElementByJS(driver, DesktopsUI.CART_VIEW_BUTTON);
		
	}


	public void clickToRequiryButton() {
		waitForElementClickable(driver, DesktopsUI.REQUIRY_BUTTON);
		clickToElementByJS(driver, DesktopsUI.REQUIRY_BUTTON);
		
	}


	public boolean isRequiryMessageDisplayed() {
		waitForElementVisible(driver, DesktopsUI.REQUIRY_MESSAGE);
		return isElementDisplayed(driver, DesktopsUI.REQUIRY_MESSAGE);
	}


	public void clickToCloseButton() {
		waitForElementClickable(driver, DesktopsUI.CLOSE_BUTTON);
		clickToElementByJS(driver, DesktopsUI.CLOSE_BUTTON);
		
	}


	
	
	
	
	
	
	
	

	

}
