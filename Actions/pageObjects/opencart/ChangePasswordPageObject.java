package pageObjects.opencart;

import org.openqa.selenium.WebDriver;

import OpenCartPageUIs.ChangePassPageUI;
import OpenCartPageUIs.RegisterPageUI;

public class ChangePasswordPageObject extends ActionPageObject {
	WebDriver driver;

	public ChangePasswordPageObject(WebDriver driver) {

		super(driver);
		this.driver = driver;
	}

	
}
