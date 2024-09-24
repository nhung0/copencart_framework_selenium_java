package pageObjects.opencart;

import org.openqa.selenium.WebDriver;

import OpenCartPageUIs.LoginPageUI;
import OpenCartPageUIs.RegisterPageUI;

public class LoginPageObject extends ActionPageObject {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {

		super(driver);
		this.driver = driver;
	}

	

}
