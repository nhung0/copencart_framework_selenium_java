package com.opencart.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import common.baseTest;
import common.pageGeneratorManagerOpenCart;
import pageObjects.opencart.HomePageObject;
import pageObjects.opencart.LoginPageObject;
import pageObjects.opencart.RegisterPageObject;
import pojoData.Opencart.RegisterInfo;
import reportConfig1.ExtentTestManager;

public class User_01_Register extends baseTest {

	WebDriver driver;
	private LoginPageObject ologinPage;
	private RegisterPageObject oregisterPage;
	private HomePageObject ohomePage;
	private RegisterInfo registerInfo;
	protected String emailValue;

	@Parameters({ "url", "browser" })
	@BeforeClass
	public void beforeClass(String url, String browserName) {
		driver = getBrowserDriver(url, browserName);
		registerInfo = new RegisterInfo();
	

		registerInfo.setEmail(randomEmail());
		registerInfo.setFirstName("Lucy");
		registerInfo.setLastName("Kudo");
		registerInfo.setPassword("123456");
		registerInfo.setEmail("pham1234@gmail.com");

		ohomePage = pageGeneratorManagerOpenCart.getHomePage(driver);

	}

	@Test
	public void User_01_Register_With_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Create new customer account");
		ExtentTestManager.getTest().log(Status.INFO, "Open register page");
		ohomePage.selectToMyAccountDropdown("Register");

		oregisterPage = pageGeneratorManagerOpenCart.getRegisterPage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Click submit button");
		oregisterPage.clickToDynamicButton("submit");
		ExtentTestManager.getTest().log(Status.INFO, "Verify errror firstname");
		Assert.assertEquals(oregisterPage.getDynamicErrorMessageText("error-firstname"),
				"First Name must be between 1 and 32 characters!");
		ExtentTestManager.getTest().log(Status.INFO, "Verify errror lastname");
		Assert.assertEquals(oregisterPage.getDynamicErrorMessageText("error-lastname"),
				"Last Name must be between 1 and 32 characters!");
		ExtentTestManager.getTest().log(Status.INFO, "Verify errror email");
		Assert.assertEquals(oregisterPage.getDynamicErrorMessageText("error-email"),
				"E-Mail Address does not appear to be valid!");
		ExtentTestManager.getTest().log(Status.INFO, "Verify errror password");
		Assert.assertEquals(oregisterPage.getDynamicErrorMessageText("error-password"),
				"Password must be between 4 and 20 characters!");

	}

	@Test
	public void User_02_Register_With_Invalid_Email(Method method) {
		oregisterPage.selectToMyAccountDropdown("Register");
	
		oregisterPage.enterToDynamicTextbox("input-firstname", registerInfo.getFirstName());
	
		oregisterPage.enterToDynamicTextbox("input-lastname", registerInfo.getLastName());
	
		oregisterPage.enterToDynamicTextbox("input-email", "laveder");
	
		oregisterPage.enterToDynamicTextbox("input-password",registerInfo.getPassword() );
		
		oregisterPage.clickToNewsLetterToggleButton();
		
		oregisterPage.clickToAgreeToggleButton();

		oregisterPage.clickToDynamicButton("submit");
	
		Assert.assertTrue(oregisterPage.isErrorEmailMessageDisplayed());

	}

	@Test
	public void User_03_Register_With_Successful_Information(Method method) {
		oregisterPage.selectToMyAccountDropdown("Register");
		oregisterPage.enterToDynamicTextbox("input-firstname", registerInfo.getFirstName());
		oregisterPage.enterToDynamicTextbox("input-lastname", registerInfo.getLastName());
		oregisterPage.enterToDynamicTextbox("input-email", randomEmail());

		emailValue = oregisterPage.getEmailDynamicValueTexbox("input-email");

		oregisterPage.enterToDynamicTextbox("input-password", registerInfo.getPassword());
		oregisterPage.clickToAgreeToggleButton();
		System.out.println(1);
		oregisterPage.clickToDynamicButton("submit");

		Assert.assertTrue(oregisterPage.isSuccessfulMessageDisplayed());

	}

	 @Test
	public void User_04_Register_With_Existed_Email(Method method) {
		oregisterPage.selectToMyAccountDropdown("Logout");
		oregisterPage.selectToMyAccountDropdown("Register");

		oregisterPage.enterToDynamicTextbox("input-firstname", registerInfo.getFirstName());
		oregisterPage.enterToDynamicTextbox("input-lastname", registerInfo.getLastName());
		oregisterPage.enterToDynamicTextbox("input-email", emailValue);

		oregisterPage.enterToDynamicTextbox("input-password", registerInfo.getPassword());

		oregisterPage.clickToDynamicButton("submit");

		Assert.assertTrue(oregisterPage.isAlertErrorMessageDisplayed("alert"));

	}

	@Test
	public void User_05_Register_With_Password_Less_Than_4_Characters(Method method) {
		oregisterPage.selectToMyAccountDropdown("Register");
		oregisterPage.enterToDynamicTextbox("input-firstname", registerInfo.getFirstName());
		oregisterPage.enterToDynamicTextbox("input-lastname", registerInfo.getLastName());
		oregisterPage.enterToDynamicTextbox("input-email", registerInfo.getEmail());
		oregisterPage.enterToDynamicTextbox("input-password", "123");

		oregisterPage.clickToDynamicButton("submit");
		Assert.assertTrue(oregisterPage.isErrorPasswordMessageDisplayed());

	}

	@Test
	public void User_06_Register_With_Password_More_Than_20_Characters(Method method) {
		oregisterPage.selectToMyAccountDropdown("Register");
		oregisterPage.enterToDynamicTextbox("input-firstname", registerInfo.getFirstName());
		oregisterPage.enterToDynamicTextbox("input-lastname", registerInfo.getLastName());
		oregisterPage.enterToDynamicTextbox("input-email", registerInfo.getEmail());
		oregisterPage.enterToDynamicTextbox("input-password",
				"111111111111111111111111111111111111111111111111111111111111");

		oregisterPage.clickToDynamicButton("submit");

		Assert.assertTrue(oregisterPage.isErrorPasswordMessageDisplayed());

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
