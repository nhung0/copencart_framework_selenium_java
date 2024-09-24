package pageObjects.opencart;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import OpenCartPageUIs.SortAndDisplayPageUI;
import OpenCartPageUIs.SuccessPageUI;

public class SuccessPageObject extends ActionPageObject {
	WebDriver driver;

	public SuccessPageObject(WebDriver driver) {

		super(driver);
		this.driver = driver;
	}

	public boolean isOrderMessageDisplayed() {
		waitForElementVisible(driver, SuccessPageUI.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, SuccessPageUI.SUCCESS_MESSAGE);
	}

	

}
