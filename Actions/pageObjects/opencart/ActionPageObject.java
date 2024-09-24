package pageObjects.opencart;

import org.openqa.selenium.WebDriver;

import OpenCartPageUIs.ActionPageUI;
import OpenCartPageUIs.AddressPageUI;
import OpenCartPageUIs.DesktopsUI;
import OpenCartPageUIs.HomePageUI;
import OpenCartPageUIs.RegisterPageUI;
import OpenCartPageUIs.WishListPageUI;
import common.basePage;
import common.pageGeneratorManagerOpenCart;

public class ActionPageObject extends basePage {

	WebDriver driver;

	protected ActionPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getDynamicErrorMessageText(String idName) {
		waitForElementVisible(driver, ActionPageUI.DYNAMIC_TEXTBOX_ERRORMASSAGE_BY_ID, idName);
		return getElmentText(driver, ActionPageUI.DYNAMIC_TEXTBOX_ERRORMASSAGE_BY_ID, idName);
	}

	public void clickToDynamicItemNameLink(String locator, String locator1) {
		waitForElementClickable(driver, ActionPageUI.ITEM_IMAGE_LINK, locator, locator1);
		
		clickToElementByJS(driver, ActionPageUI.ITEM_IMAGE_LINK, locator, locator1);

	}

	public void enterToDynamicTextbox(String idName, String value) {
		scrollToElementOnTop(driver, ActionPageUI.DYNAMIC_TEXTBOX, idName);
		waitForElementVisible(driver, ActionPageUI.DYNAMIC_TEXTBOX, idName);
		sendKeysToElment(driver, ActionPageUI.DYNAMIC_TEXTBOX, value, idName);
		sleepInSecond(3);
	}

	public void selectToMyAccountDropdown(String accountType) {
		waitForElementClickable(driver, ActionPageUI.MYACCOUNT_DROPDOWN_PARENT);
		selectIteminDropdownByJS(driver, ActionPageUI.MYACCOUNT_DROPDOWN_PARENT,ActionPageUI.MYACCOUNT_DROPDOWN_REGISTER_ITEM, accountType);
		sleepInSecond(3);
	}
	
	
	public void enterToDynamicTexareaBox(String locator, String AreaTextValue) {
		waitForElementVisible(driver, ActionPageUI.DYNAMIC_TEXAREA, locator);
		sendKeysToElment(driver, ActionPageUI.DYNAMIC_TEXAREA, AreaTextValue, locator);

	}

	public void openUrlSearchPage(String url) {
		openPageUrl(driver, url);

	}

	public void selectDynamicMenuDropdown(String itemName, String locator) {
		scrollToElementOnDown(driver, ActionPageUI.DYNAMIC_MENU_DROPDOWN_PARENT, locator);
		waitForElementClickable(driver, ActionPageUI.DYNAMIC_MENU_DROPDOWN_PARENT, locator);
		selectIteminDropdownByJS(driver, ActionPageUI.DYNAMIC_MENU_DROPDOWN_PARENT, ActionPageUI.DYNAMIC_MENU_DROPDOWN_ITEM,itemName, locator);
		sleepInSecond(2);
	}

	public void selectToDynamicDropDown(String sortType, String locator) {
		waitForElementClickable(driver, ActionPageUI.DYNAMIC_DROPDOWN_PARENT, locator);
		selectIteminDropdownByJS2(driver, ActionPageUI.DYNAMIC_DROPDOWN_PARENT, ActionPageUI.DYNAMIC_DROPDOWN_ITEM,
				sortType, locator);

	}
	
	

	public boolean isImageItemDisplayed(String locator, String locator1) {
		waitForElementVisible(driver, ActionPageUI.DYNAMIC_IMAGE_LINK, locator,locator1);
		return isElementDisplayed(driver, ActionPageUI.DYNAMIC_IMAGE_LINK, locator,locator1);

	}

	public void upLoadFile(String fileName) {
		waitForElementVisible(driver, ActionPageUI.UPLOAD_FILE_TYPE);
		uploadMultipleFiless(driver, fileName);

	}
	
	

	public boolean isProductNameLinkItemDisplayed(String locator, String locator1) {
		waitForElementVisible(driver, ActionPageUI.DYNAMIC_NAME_PRODUCE_LINK, locator,locator1);
		return isElementDisplayed(driver, ActionPageUI.DYNAMIC_NAME_PRODUCE_LINK, locator,locator1);
	}

	public String getModelItemText(String locator, String locator1) {
		waitForElementVisible(driver, ActionPageUI.DYNAMIC_MODEL_ITEM_VALUE, locator,locator1);
		return getElmentText(driver, ActionPageUI.DYNAMIC_MODEL_ITEM_VALUE, locator,locator1);
	}

	public String getUnitPriceItemText(String locator) {
		waitForElementVisible(driver, ActionPageUI.DYNAMIC_PRICE_ITEM_VALUE,locator);
		return getElmentText(driver, ActionPageUI.DYNAMIC_PRICE_ITEM_VALUE, locator);
	}

	public void clickToWishListHeaderButton() {
		waitForElementClickable(driver, ActionPageUI.WISHLIST_HEADER_BUTTON);
		clickToElementByJS(driver, ActionPageUI.WISHLIST_HEADER_BUTTON);

	}

	public void selectDynamicMenuDropdownAll(String itemName, String locator) {
		waitForElementClickable(driver, ActionPageUI.DYNAMIC_MENU_DROPDOWN_PARENT, locator);

		selectIteminDropdown(driver, ActionPageUI.DYNAMIC_MENU_DROPDOWN_PARENT,
				ActionPageUI.DYNAMIC_MENU_DROPDOWN_ALL_ITEM, itemName, locator);

	}

	public ActionPageObject clickToDynamicPageLink(String pageName) {

		waitForElementClickable(driver, ActionPageUI.DYNAMIC_HEADER_LINKS_BY_NAME, pageName);
		clickToElment(driver, ActionPageUI.DYNAMIC_HEADER_LINKS_BY_NAME, pageName);
		switch (pageName) {
		case "Edit Account":
			return pageGeneratorManagerOpenCart.getEditCustormerPage(driver);

		case "Password":
			return pageGeneratorManagerOpenCart.getChangePasswordPage(driver);

		case "Address Book":
			return pageGeneratorManagerOpenCart.getAddressPage(driver);

		case "Wish List":
			return pageGeneratorManagerOpenCart.getWishListPage(driver);

		default:
			new RuntimeException(" page name incorrect.");
			return null;
			
		}
		
		
	}

	public void clickToDynamicButton(String locator) {
		waitForElementClickable(driver, ActionPageUI.DYNAMIC_BUTTON, locator);
		clickToElementByJS(driver, ActionPageUI.DYNAMIC_BUTTON, locator);

	}

	public void clickToOptionLabelButton(String locator) {
		scrollToElementOnTop(driver, ActionPageUI.DYNAMIC_OPTION_LABEL_BUTTON, locator);
		waitForElementClickable(driver, ActionPageUI.DYNAMIC_OPTION_LABEL_BUTTON, locator);
		clickToElementByJS(driver, ActionPageUI.DYNAMIC_OPTION_LABEL_BUTTON, locator);

	}

	public void clickToDynamicCompareLabelButton(String locator) {
		scrollToElementOnTop(driver, ActionPageUI.DYNAMIC_COMPARE_LABEL_BUTTON, locator);
		waitForElementClickable(driver, ActionPageUI.DYNAMIC_COMPARE_LABEL_BUTTON, locator);
		clickToElementByJS(driver, ActionPageUI.DYNAMIC_COMPARE_LABEL_BUTTON, locator);
		sleepInSecond(3);

	}

	public void clickToDirectCartLabelButton(String locator) {
		waitForElementClickable(driver, ActionPageUI.DYNAMIC_CART_LABEL_BUTTON_WITHOUT_CLICKING_LINK, locator);
		clickToElementByJS(driver, ActionPageUI.DYNAMIC_CART_LABEL_BUTTON_WITHOUT_CLICKING_LINK, locator);
		sleepInSecond(3);
	}
	
	public void clickToShoppingCartHeaderButton() {
		waitForElementClickable(driver, ActionPageUI.SHOPPING_CART_BUTTON);
		clickToElementByJS(driver, ActionPageUI.SHOPPING_CART_BUTTON);
		
		
	}

	public boolean isAlertErrorMessageDisplayed(String locator) {
		waitForElementVisible1(driver, ActionPageUI.ALERT_MESSAGE, locator);
		return isElementDisplayed(driver, ActionPageUI.ALERT_MESSAGE, locator);
		
	}
	
	public boolean isAlertErrorMessageUnDisplayed(String locator) {
		waitForElementInVisible(driver, ActionPageUI.ALERT_MESSAGE, locator);
		return isElementUndisplayed(driver, ActionPageUI.ALERT_MESSAGE, locator);
		
	}

	public void clearToDynamicTextInTextbox(String locator) {
		waitForElementVisible(driver, ActionPageUI.DYNAMIC_TEXTBOX);
		clearToElment(driver, ActionPageUI.DYNAMIC_TEXTBOX, locator);

	}

	public void clickToDynamicCheckBoxButtonByID(String locator) {
		scrollToElementOnTop(driver, ActionPageUI.DYNAMIC_RADIO_AND_CHECKBOX_BUTTON_BY_ID, locator);
		waitForElementClickable(driver, ActionPageUI.DYNAMIC_RADIO_AND_CHECKBOX_BUTTON_BY_ID, locator);
		checkToElement(driver, ActionPageUI.DYNAMIC_RADIO_AND_CHECKBOX_BUTTON_BY_ID, locator);
		sleepInSecond(2);
	}
	
	public void clickToDynamicRadioButtonByID(String locator) {
		waitForElementClickable(driver, ActionPageUI.DYNAMIC_RADIO_AND_CHECKBOX_BUTTON_BY_ID, locator);
		clickToElementByJS(driver, ActionPageUI.DYNAMIC_RADIO_AND_CHECKBOX_BUTTON_BY_ID, locator);

	}
	

	public boolean isUnitPriceItemTextDisplayed(String locator, String locator1) {
		waitForElementVisible1(driver, ActionPageUI.DYNAMIC_PRICE_ITEM_VALUE, locator,locator1);
		return isElementDisplayed(driver, ActionPageUI.DYNAMIC_PRICE_ITEM_VALUE, locator, locator1);
	}
	
	public String getTotalPriceItemTextDisplayed(String locator) {
		waitForElementVisible1(driver, ActionPageUI.DYNAMIC_TOTAL_PRICE_ITEM_VALUE, locator);
		return getElmentText(driver, ActionPageUI.DYNAMIC_TOTAL_PRICE_ITEM_VALUE, locator);
	}

	public String getEmailDynamicValueTexbox(String locator) {
		waitForElementVisible1(driver, ActionPageUI.DYNAMIC_TEXTBOX, locator);
		return getElmentAttribute(driver, ActionPageUI.DYNAMIC_TEXTBOX, "value", locator);

	}

	public void clickToViewItemButton(String locator) {
		waitForElementClickable(driver, ActionPageUI.VIEW_ITEM_BUTTON, locator);
		clickToElementByJS(driver, ActionPageUI.VIEW_ITEM_BUTTON, locator);
		sleepInSecond(3);
	}
	
	public boolean isEmptyMessageDisplayed(String locator) {
		waitForElementVisible(driver, ActionPageUI.EMPTY_MESSAGE, locator);
		return isElementDisplayed(driver,ActionPageUI.EMPTY_MESSAGE, locator);
		
	}

}
