package pageObjects.opencart;

import org.openqa.selenium.WebDriver;

import OpenCartPageUIs.ActionPageUI;
import OpenCartPageUIs.AddressPageUI;
import OpenCartPageUIs.MyAccountSideBarPageUI;
import OpenCartPageUIs.WishListPageUI;

public class WishListPageObject extends ActionPageObject{
	WebDriver driver;
	public WishListPageObject(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
	}
	public boolean isMyWishlistTextDisplayed() {
		waitForElementVisible(driver, WishListPageUI.MY_WISHLIST_MESSAGE);
		sleepInSecond(3);
		return isElementDisplayed(driver,WishListPageUI.MY_WISHLIST_MESSAGE);
		
		
	}
	
	
	public void clickToCartLabelButton() {
		waitForElementClickable(driver, WishListPageUI.FIRST_CART_BUTTON);
		clickToElementByJS(driver, WishListPageUI.FIRST_CART_BUTTON);
		
	}
	
	public void clickToRemoveLabelButton() {
		waitForElementClickable(driver, WishListPageUI.REMOVE_BUTTON);
		clickToElementByJS(driver, WishListPageUI.REMOVE_BUTTON);
		
	}
	public String getWishListPriceItemText(String locator) {
		waitForElementVisible(driver, WishListPageUI.WISHLIST_PRICE_ITEM_VALUE,locator);
		return getElmentText(driver, WishListPageUI.WISHLIST_PRICE_ITEM_VALUE, locator);
	}
	
	

}
