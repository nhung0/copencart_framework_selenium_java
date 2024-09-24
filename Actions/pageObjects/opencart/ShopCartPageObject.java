package pageObjects.opencart;

import org.openqa.selenium.WebDriver;

import OpenCartPageUIs.ActionPageUI;
import OpenCartPageUIs.AddressPageUI;
import OpenCartPageUIs.CheckOutPageUI;
import OpenCartPageUIs.ShopCartPageUI;

public class ShopCartPageObject extends ActionPageObject{
	WebDriver driver;
	public ShopCartPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	



	public String getTotalPriceItemText() {
		waitForElementVisible(driver, ShopCartPageUI.TOTAL_PRICE_ITEM_VALUE);
		return getElmentText(driver, ShopCartPageUI.TOTAL_PRICE_ITEM_VALUE);
	}




	public void clickToRemoveButton(String locator) {
		waitForElementClickable(driver, ShopCartPageUI.REMOVE_BUTTON, locator);
		clickToElementByJS(driver, ShopCartPageUI.REMOVE_BUTTON,locator);
		
		
	}




	public void enterToQuantityTexbox(String locator,String value) {
		waitForElementClickable(driver, ShopCartPageUI.QUANTITY_TEXTBOX,locator);
		sendKeysToElment(driver, ShopCartPageUI.QUANTITY_TEXTBOX, value, locator);
		
	}




	public void clickToUpdateButton(String locator) {
		waitForElementClickable(driver, ShopCartPageUI.UPDATE_BUTTON, locator);
		clickToElementByJS(driver, ShopCartPageUI.UPDATE_BUTTON,locator);
		
	}




	public void clickToCheckOutButton() {
		waitForElementClickable(driver, ShopCartPageUI.CHECKOUT_BUTTON);
		clickToElementByJS(driver, ShopCartPageUI.CHECKOUT_BUTTON);
		
	}




	public String getTotalPriceCheckOutTextDisplayed() {
		scrollToElementOnTop(driver, CheckOutPageUI.TOTAL_PRICE_CHECKOUT_VALUE);
		waitForElementVisible1(driver, CheckOutPageUI.TOTAL_PRICE_CHECKOUT_VALUE);
		return getElmentText(driver, CheckOutPageUI.TOTAL_PRICE_CHECKOUT_VALUE);
	}
	
	
	

	
	




}
