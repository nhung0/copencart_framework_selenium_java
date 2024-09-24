package pageObjects.opencart;

import org.openqa.selenium.WebDriver;

import OpenCartPageUIs.AddressPageUI;
import OpenCartPageUIs.SearchPageUI;

public class SearchPageObject extends ActionPageObject{
	WebDriver driver;
	public SearchPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public void clickToSearchButton() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElment(driver, SearchPageUI.SEARCH_BUTTON);
	}
	public boolean isErrorSearchTextDisplayed() {
		waitForElementVisible(driver, SearchPageUI.ERROR_SEARCH_MESSAGE);
		return isElementDisplayed(driver, SearchPageUI.ERROR_SEARCH_MESSAGE);
	}
	public void selectCategoriesDropdown(String category) {
		waitForElementClickable(driver, SearchPageUI.CATEGORY_DROPDOWN_PARENT);
		selectIteminDropdownByJS(driver, SearchPageUI.CATEGORY_DROPDOWN_PARENT, SearchPageUI.CATEGORY_DROPDOWN_CHILD, category );
		
		
	}
	
	

}
