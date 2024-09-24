package pageObjects.opencart;

import org.openqa.selenium.WebDriver;

import OpenCartPageUIs.OrderPageUI;

public class OrderPageObject extends ActionPageObject{
	WebDriver driver;
	public OrderPageObject(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
	}
	public void clickToViewButton(String locator) {
		waitForElementClickable(driver, OrderPageUI.VIEW_BUTTON, locator);
		clickToElementByJS(driver, OrderPageUI.VIEW_BUTTON,locator);
	}
	public void clickReorderButton() {
		scrollToElementOnTop(driver, OrderPageUI.REORDER_BUTTON);
		waitForElementClickable(driver, OrderPageUI.REORDER_BUTTON);
		clickToElementByJS(driver, OrderPageUI.REORDER_BUTTON);
	}
	public boolean isOrderInfoDisplayed(String locator) {
		waitForElementVisible(driver, OrderPageUI.ORDER_CART_MESSAGE,locator);
		return isElementDisplayed(driver, OrderPageUI.ORDER_CART_MESSAGE,locator);
	}

}
