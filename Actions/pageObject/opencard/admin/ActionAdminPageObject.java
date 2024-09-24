package pageObject.opencard.admin;

import org.openqa.selenium.WebDriver;

import OpenCartAdminPageUI.ActionAdminPageUI;
import OpenCartAdminPageUI.DashboardAdminPageUI;
import OpenCartPageUIs.ActionPageUI;
import OpenCartPageUIs.AddressPageUI;
import OpenCartPageUIs.DesktopsUI;
import OpenCartPageUIs.HomePageUI;
import OpenCartPageUIs.RegisterPageUI;
import OpenCartPageUIs.WishListPageUI;
import common.basePage;
import common.pageGeneratorManagerOpenCart;

public class ActionAdminPageObject extends basePage {

	WebDriver driver;

	protected ActionAdminPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToDynamicTextbox(String idName, String value) {
		scrollToElementOnTop(driver, ActionAdminPageUI.DYNAMIC_TEXTBOX, idName);
		waitForElementVisible(driver, ActionAdminPageUI.DYNAMIC_TEXTBOX, idName);
		sendkeyToElementByJS(driver, ActionAdminPageUI.DYNAMIC_TEXTBOX, value, idName);
		sleepInSecond(2);
	}

	public void enterToDynamicTexareaBox(String locator, String AreaTextValue) {
		waitForElementVisible(driver, ActionAdminPageUI.DYNAMIC_TEXAREA, locator);
		sendkeyToElementByJS(driver, ActionAdminPageUI.DYNAMIC_TEXAREA, AreaTextValue, locator);

	}

	public void openUrlSearchPage(String url) {
		openPageUrl(driver, url);

	}

	public void selectToBarDynamicDropDown(String sortType, String locator, String locator2) {
		waitForElementClickable(driver, ActionAdminPageUI.DYNAMIC_BAR_MENU_DROPDOWN_PARENT, locator, locator2);
		selectIteminDropdown(driver, ActionAdminPageUI.DYNAMIC_BAR_MENU_DROPDOWN_PARENT,
				ActionAdminPageUI.DYNAMIC_BAR_MENU_DROPDOWN_ITEM, sortType, locator, locator2);
		sleepInSecond(2);
	}

	public void selectToDynamicDropDown(String sortType, String locator) {
		waitForElementClickable(driver, ActionAdminPageUI.DYNAMIC_DROPDOWN_PARENT, locator);
		selectIteminDropdownByJS(driver, ActionAdminPageUI.DYNAMIC_DROPDOWN_PARENT,
				ActionAdminPageUI.DYNAMIC_DROPDOWN_ITEM, sortType, locator);
		sleepInSecond(2);

	}

	public boolean isImageItemDisplayed(String locator, String locator1) {
		waitForElementVisible(driver, ActionAdminPageUI.DYNAMIC_IMAGE_LINK, locator, locator1);
		return isElementDisplayed(driver, ActionAdminPageUI.DYNAMIC_IMAGE_LINK, locator, locator1);

	}

	public void clickToViewItemButton(String locator) {
		waitForElementClickable(driver, ActionAdminPageUI.VIEW_ITEM_BUTTON, locator);
		clickToElementByJS(driver, ActionAdminPageUI.VIEW_ITEM_BUTTON, locator);
		sleepInSecond(2);
	}

	public boolean isProductNameLinkItemDisplayed(String locator, String locator1) {
		waitForElementVisible(driver, ActionAdminPageUI.DYNAMIC_NAME_PRODUCE_LINK, locator, locator1);
		return isElementDisplayed(driver, ActionAdminPageUI.DYNAMIC_NAME_PRODUCE_LINK, locator, locator1);
	}

	public String getModelItemText(String locator, String locator1) {
		waitForElementVisible(driver, ActionAdminPageUI.DYNAMIC_MODEL_ITEM_VALUE, locator, locator1);
		return getElmentText(driver, ActionAdminPageUI.DYNAMIC_MODEL_ITEM_VALUE, locator, locator1);
	}

	public boolean isProductNameDisplayed(String locator, String locator1) {
		waitForElementVisible(driver, ActionAdminPageUI.DYNAMIC_PRODUCE_NAME, locator, locator1);
		return isElementDisplayed(driver, ActionAdminPageUI.DYNAMIC_PRODUCE_NAME, locator, locator1);
	}

	public boolean isProductQuantityDisplayed(String locator, String locator1) {
		waitForElementVisible(driver, ActionAdminPageUI.QUANTITY_VALUE, locator, locator1);
		return isElementDisplayed(driver, ActionAdminPageUI.QUANTITY_VALUE, locator, locator1);
	}

	public boolean isErrorMessageDisplayed(java.lang.String locator, java.lang.String locator1) {
		waitForElementVisible(driver, ActionAdminPageUI.EMPTY_MESSAGE, locator, locator1);
		return isElementDisplayed(driver, ActionAdminPageUI.EMPTY_MESSAGE, locator, locator1);
	}

	public void clickToAddNewAndBackButton(String locator) {
		waitForElementClickable(driver, ActionAdminPageUI.ADD_NEW_AND_BACK_BUTTON, locator);
		clickToElementByJS(driver, ActionAdminPageUI.ADD_NEW_AND_BACK_BUTTON, locator);

	}

	public void clickToCusBackButton(String locator) {
		waitForElementClickable(driver, ActionAdminPageUI.CUS_BACK_BUTTON, locator);
		clickToElementByJS(driver, ActionAdminPageUI.CUS_BACK_BUTTON, locator);

	}

	public void clickToDynamicButton(String locator) {
		waitForElementClickable(driver, ActionAdminPageUI.DYNAMIC_BUTTON, locator);
		clickToElementByJS(driver, ActionAdminPageUI.DYNAMIC_BUTTON, locator);
		sleepInSecond(5);
	}

	public boolean isAlertErrorMessageDisplayed(String locator) {
		waitForElementVisible1(driver, ActionAdminPageUI.ALERT_MESSAGE, locator);
		return isElementDisplayed(driver, ActionAdminPageUI.ALERT_MESSAGE, locator);

	}

	public void clickToDynamicTitleLink(String locator, String locator1) {
		waitForElementClickable(driver, ActionAdminPageUI.DYNAMIC_TITLE_LINK, locator, locator1);
		clickToElementByJS(driver, ActionAdminPageUI.DYNAMIC_TITLE_LINK, locator, locator1);

	}

	public boolean isAlertMessageDisplayed(String locator, String locator1) {
		waitForElementVisible1(driver, ActionAdminPageUI.DYNAMIC_ALERT_MESSAGE, locator, locator1);
		return isElementDisplayed(driver, ActionAdminPageUI.DYNAMIC_ALERT_MESSAGE, locator, locator1);
	}

	public void clickToEditAdminButton(String locator) {
		waitForElementClickable(driver, ActionAdminPageUI.DYNAMIC_ADMIN_BUTTON, locator);
		clickToElementByJS(driver, ActionAdminPageUI.DYNAMIC_ADMIN_BUTTON, locator);

	}

	public void clickToSaveAdminButton(String locator) {
		waitForElementClickable(driver, ActionAdminPageUI.SAVE_BUTTON, locator);
		clickToElementByJS(driver, ActionAdminPageUI.SAVE_BUTTON, locator);
		sleepInSecond(2);

	}

	public void clickToDynamicRadioButtonByID(String locator) {
		waitForElementClickable(driver, ActionAdminPageUI.DYNAMIC_RADIO_AND_CHECKBOX_BUTTON_BY_ID, locator);
		clickToElementByJS(driver, ActionAdminPageUI.DYNAMIC_RADIO_AND_CHECKBOX_BUTTON_BY_ID, locator);

	}

	public void clickToDynamiAddressButton(String locator, String locator1) {
		waitForElementClickable(driver, ActionAdminPageUI.DYNAMIC_ADDRESS_BUTTON, locator, locator1);
		clickToElementByJS(driver, ActionAdminPageUI.DYNAMIC_ADDRESS_BUTTON, locator, locator1);

	}

	public boolean isTitleMessageDisplayed(String locator, String locator1) {
		waitForElementInVisible(driver, ActionAdminPageUI.DYNAMIC_TITLE_ADDRESS_BUTTON, locator, locator1);
		return isElementUndisplayed(driver, ActionAdminPageUI.DYNAMIC_TITLE_ADDRESS_BUTTON, locator, locator1);

	}

}
