package com.opencart.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.serviceworker.model.RegistrationID;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.baseTest;
import common.pageGeneratorManagerOpenCart;
import pageObjects.opencart.HomePageObject;
import pageObjects.opencart.LoginPageObject;
import pageObjects.opencart.LogoutPageObject;
import pageObjects.opencart.MyAccountSideBarPageObject;
import pageObjects.opencart.RegisterPageObject;
import pojoData.Opencart.LoginInfo;
import pojoData.Opencart.RegisterInfo;

public class User_02_Login extends baseTest{
	WebDriver driver;
	private LoginPageObject ologinPage;

	private HomePageObject ohomePage;
	private LoginInfo loginInfo;
	private RegisterInfo registerInfo;
	private MyAccountSideBarPageObject myAccountPage;
	private RegisterPageObject oregisterPage;
	private LogoutPageObject logoutPage;
	private String oemailValue;
	
	
	
	
	
	

	@Parameters({"url","browser"})
	@BeforeClass
	public void beforeClass(String url, String browserName) {
		driver = getBrowserDriver(url, browserName);
		loginInfo = new LoginInfo();
		registerInfo = new RegisterInfo();
		
	
		registerInfo.setFirstName("Lucy");
		registerInfo.setLastName("Kudo");
		registerInfo.setPassword("123456");
		registerInfo.setEmail("pham12345@gmail.com");
		
		ohomePage = pageGeneratorManagerOpenCart.getHomePage(driver);
	
		
		

		ohomePage.selectToMyAccountDropdown("Register");
		
		oregisterPage = pageGeneratorManagerOpenCart.getRegisterPage(driver);
		
		oregisterPage.enterToDynamicTextbox("input-firstname", registerInfo.getFirstName());
		oregisterPage.enterToDynamicTextbox("input-lastname", registerInfo.getLastName());
		oregisterPage.enterToDynamicTextbox("input-email", randomEmail());
		oemailValue = oregisterPage.getEmailDynamicValueTexbox("input-email");
		oregisterPage.enterToDynamicTextbox("input-password", registerInfo.getPassword());
		oregisterPage.clickToAgreeToggleButton();
		oregisterPage.clickToDynamicButton("submit");
		
	
		oregisterPage.selectToMyAccountDropdown("Logout");
		logoutPage = pageGeneratorManagerOpenCart.getLogoutPage(driver);
		logoutPage.clickToContinueButton();
		ohomePage = pageGeneratorManagerOpenCart.getHomePage(driver);
		
		
		
		
		
		
		
		
		
	}

	@Test
	public void User_01_Login_With_Empty_Data() {
		
		ohomePage.selectToMyAccountDropdown("Login");
		
		System.out.println(1);
		ologinPage = pageGeneratorManagerOpenCart.getLoginPage(driver);
		System.out.println(2);
		
		ologinPage.clickToDynamicButton("submit");
		System.out.println(3);
		Assert.assertTrue(ologinPage.isAlertErrorMessageDisplayed("alert"));
	
		
		
		
	
	}

	@Test
	public void User_02_Login_With_Invalid_Email(Method method) {
		ologinPage.selectToMyAccountDropdown("Login");
		System.out.println(7);
		
		ologinPage.enterToDynamicTextbox("input-email", "laveder");
		System.out.println(10);
		ologinPage.enterToDynamicTextbox("input-password", registerInfo.getPassword());
		
		ologinPage.clickToDynamicButton("submit");
		System.out.println(14);
		Assert.assertTrue(ologinPage.isAlertErrorMessageDisplayed("alert"));
		System.out.println(15);

	}
	
	@Test
	public void User_03_Login_With_Unsigned_Email(Method method) {
		ologinPage.selectToMyAccountDropdown("Login");

		ologinPage.enterToDynamicTextbox("input-email", randomEmail());
		ologinPage.enterToDynamicTextbox("input-password", registerInfo.getPassword());
		System.out.println(16);
		ologinPage.clickToDynamicButton("submit");
		Assert.assertTrue(ologinPage.isAlertErrorMessageDisplayed("alert"));
		
		
	}
	
	@Test
	public void User_04_Login_With_registered_Email_And_Empty_Password(Method method) {
		ologinPage.selectToMyAccountDropdown("Login");
		
		ologinPage.enterToDynamicTextbox("input-email", oemailValue);
//		ologinPage.clearToDynamicTextInTextbox("input-password");
		System.out.println(16);
		ologinPage.clickToDynamicButton("submit");
		Assert.assertTrue(ologinPage.isAlertErrorMessageDisplayed("alert"));
		

	}
	
	@Test
	public void User_05_Login_With_Right_Password_And_Email(Method method) {
		ologinPage.selectToMyAccountDropdown("Login");
		ologinPage.enterToDynamicTextbox("input-email", oemailValue);
		ologinPage.enterToDynamicTextbox("input-password",registerInfo.getPassword());
		
		ologinPage.clickToDynamicButton("submit");
		myAccountPage = pageGeneratorManagerOpenCart.getMyAccountSideBarPage(driver);
		Assert.assertTrue(myAccountPage.isMyAccountTextDisplayed());
		System.out.println(18);

	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
