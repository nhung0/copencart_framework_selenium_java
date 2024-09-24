package pageObjects.opencart;

import org.openqa.selenium.WebDriver;

import OpenCartPageUIs.ChangePassPageUI;
import OpenCartPageUIs.CheckOutPageUI;
import OpenCartPageUIs.RegisterPageUI;
import OpenCartPageUIs.ShopCartPageUI;

public class CheckOutPageObject extends ActionPageObject {
	WebDriver driver;

	public CheckOutPageObject(WebDriver driver) {

		super(driver);
		this.driver = driver;
	}

	public void selectToShippingNationalityDropdown(String nationality) {
		waitForElementClickable(driver, CheckOutPageUI.SHIP_NATIONALITY_DROPDOWN_PARENT);
		selectIteminDropdown(driver, CheckOutPageUI.SHIP_NATIONALITY_DROPDOWN_PARENT,
				CheckOutPageUI.SHIP_NATIONALITY_DROPDOWN_CHILD_ITEM, nationality);
		sleepInSecond(2);

	}

	public void selectToShippingStateDropdown(String state) {
		waitForElementClickable(driver, CheckOutPageUI.SHIP_STATE_DROPDOWN_PARENT);
		selectIteminDropdown(driver, CheckOutPageUI.SHIP_STATE_DROPDOWN_PARENT,
				CheckOutPageUI.SHIP_STATE_DROPDOWN_CHILD_ITEM, state);
		sleepInSecond(2);
	}

	public void clickToShippingAndPaymentMethodButton(String idLocator, String idLocator1, String idLocator2) {
		waitForElementClickable(driver, CheckOutPageUI.METHOD_BUTTON, idLocator, idLocator1);
		clickToElment(driver, CheckOutPageUI.METHOD_BUTTON, idLocator, idLocator1);
		sleepInSecond(2);
		waitForElementClickable(driver, CheckOutPageUI.METHOD_RADIO_BUTTON, idLocator2);
		clickToElment(driver, CheckOutPageUI.METHOD_RADIO_BUTTON, idLocator2);

	}

	public String getTotalPriceCheckOutWithoutShippingTextDisplayed() {
		waitForElementVisible1(driver, CheckOutPageUI.TOTAL_PRICE_CHECKOUT_VALUE_WITHOUT_SHIPPING);
		return getElmentText(driver, CheckOutPageUI.TOTAL_PRICE_CHECKOUT_VALUE_WITHOUT_SHIPPING);
	}

}
