package pageObjects.opencart;

import org.openqa.selenium.WebDriver;

import OpenCartPageUIs.ActionPageUI;
import OpenCartPageUIs.AddressPageUI;
import OpenCartPageUIs.MyAccountSideBarPageUI;



public class AddressPageObject extends ActionPageObject{
	WebDriver driver;
	
	
	public AddressPageObject(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
	}


	public void clickAddressButton() {
		waitForElementClickable(driver, AddressPageUI.ADDRESS_BUTTON);
		clickToElment(driver, AddressPageUI.ADDRESS_BUTTON);
		
	}


	public void selectToNationalityDropdown(String nationality) {
		waitForElementClickable(driver, AddressPageUI.NATIONALITY_DROPDOWN_PARENT);
		selectIteminDropdown(driver, AddressPageUI.NATIONALITY_DROPDOWN_PARENT, AddressPageUI.NATIONALITY_DROPDOWN_CHILD_ITEM, nationality );
		
		
	}


	public void selectToStateDropdown(String state) {
		waitForElementClickable(driver, AddressPageUI.STATE_DROPDOWN_PARENT);
		selectIteminDropdown(driver, AddressPageUI.STATE_DROPDOWN_PARENT, AddressPageUI.STATE_DROPDOWN_CHILD_ITEM,state );
		

		
	}


	public boolean isSuccessfullyAddressTextDisplayed() {
		
		waitForElementVisible(driver, AddressPageUI.SUCCESS_ADD_ADDRESS_MESSAGE);
		return isElementDisplayed(driver, AddressPageUI.SUCCESS_ADD_ADDRESS_MESSAGE);
		
	}


	

	
	
	

}
