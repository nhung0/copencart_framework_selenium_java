package pageObjects.opencart;

import org.openqa.selenium.WebDriver;

import OpenCartPageUIs.ChangePassPageUI;
import OpenCartPageUIs.MyAccountSideBarPageUI;
import OpenCartPageUIs.RegisterPageUI;

public class MyAccountSideBarPageObject extends ActionPageObject {
	WebDriver driver;

	public MyAccountSideBarPageObject(WebDriver driver) {

		super(driver);
		this.driver = driver;
	}

	public boolean isMyAccountTextDisplayed() {
		waitForElementVisible(driver, MyAccountSideBarPageUI.MY_ACCOUNT_MESSAGE);
		return isElementDisplayed(driver, MyAccountSideBarPageUI.MY_ACCOUNT_MESSAGE);
	}

	public boolean isSuccessfullyUpdatedAccountDisplayed() {

		waitForElementVisible(driver, MyAccountSideBarPageUI.SUCCESS_EDIT_ACCOUNT_MESSAGE);

		return isElementDisplayed(driver, MyAccountSideBarPageUI.SUCCESS_EDIT_ACCOUNT_MESSAGE);
	}

	public boolean isSuccessfullyChangePasswordDisplayed() {

		waitForElementVisible(driver, ChangePassPageUI.SUCCESS_REGISTER_MESSAGE);
		return isElementDisplayed(driver, ChangePassPageUI.SUCCESS_REGISTER_MESSAGE);
	}

	public void clickToSearchBarButton() {
		waitForElementClickable(driver, MyAccountSideBarPageUI.SEARCH_BAR_BUTTON);
		clickToElment(driver, MyAccountSideBarPageUI.SEARCH_BAR_BUTTON);

	}

	public void enterToSearchTextbox(String value) {
		waitForElementVisible(driver, MyAccountSideBarPageUI.SEARCH_TEXTBOX);
		sendKeysToElment(driver, MyAccountSideBarPageUI.SEARCH_TEXTBOX, value);
	}

	public void clickToTitleHomePage() {
		waitForElementClickable(driver, MyAccountSideBarPageUI.TITLE_HOME_PAGE);
		clickToElementByJS(driver, MyAccountSideBarPageUI.TITLE_HOME_PAGE);
		
	}

	


		
	

}
