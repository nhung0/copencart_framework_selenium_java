package pageObjects.opencart;

import org.openqa.selenium.WebDriver;

import OpenCartPageUIs.ActionPageUI;
import OpenCartPageUIs.AddressPageUI;
import OpenCartPageUIs.ComparePageUI;
import OpenCartPageUIs.MyAccountSideBarPageUI;
import OpenCartPageUIs.WishListPageUI;

public class ComparePageObject extends ActionPageObject{
	WebDriver driver;
	public ComparePageObject(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
	}
	public boolean isDynamicProductNameLinkItemDisplayed(String locator) {
		waitForElementVisible1(driver, ComparePageUI.COMPARE_NAME_PRODUCE_LINK, locator);;
		return isElementDisplayed(driver, ComparePageUI.COMPARE_NAME_PRODUCE_LINK, locator);
	}
	public void clickToRemoveButton() {
		waitForElementClickable(driver, ComparePageUI.REMOVE_BUTTON);
		clickToElementByJS(driver, ComparePageUI.REMOVE_BUTTON);
		
	}
	public boolean isEmptyCompareMessageDisplayed() {
		waitForElementVisible1(driver, ComparePageUI.EMPTY_COMPARE_MESSAGE);
		return isElementDisplayed(driver, ComparePageUI.EMPTY_COMPARE_MESSAGE);
	}
	public void clickToProduceCompareButton() {
		waitForElementClickable(driver, ComparePageUI.COMPARE_BUTTON);
		clickToElementByJS(driver, ComparePageUI.COMPARE_BUTTON);
	}
	public boolean isCompareBreadcrumbDisplayed() {
		waitForElementVisible1(driver, ComparePageUI.COMPARE_BREADCRUMB);
		return isElementDisplayed(driver, ComparePageUI.COMPARE_BREADCRUMB);
	}
	
}
