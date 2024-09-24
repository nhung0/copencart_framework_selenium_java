package com.opencart.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
import pageObjects.opencart.SearchPageObject;
import pageObjects.opencart.SortAndDisplayPageObject;
import pojoData.Opencart.LoginInfo;
import pojoData.Opencart.RegisterInfo;

public class User_05_Sort_Displayed_Paging extends baseTest{
	WebDriver driver;
	private LoginPageObject ologinPage;
	private SortAndDisplayPageObject sortPage;

	private HomePageObject ohomePage;

	private MyAccountSideBarPageObject myAccountPage;
	private RegisterPageObject oregisterPage;
	private LogoutPageObject logoutPage;


	protected String updatedEmail;
	protected String passValue;


	private RegisterInfo registerInfo;

	private String oemailValue;

	@Parameters({ "url", "browser" })
	@BeforeClass
	public void beforeClass(String url, String browserName) {
		driver = getBrowserDriver(url, browserName);
		
		registerInfo = new RegisterInfo();
		
		registerInfo.setFirstName("Lucy");
		registerInfo.setLastName("Kudo");
		registerInfo.setPassword("123456");

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

		System.out.println(16);

		oregisterPage.selectToMyAccountDropdown("Logout");
		logoutPage = pageGeneratorManagerOpenCart.getLogoutPage(driver);
		logoutPage.clickToContinueButton();
		ohomePage = pageGeneratorManagerOpenCart.getHomePage(driver);

		ohomePage.selectToMyAccountDropdown("Login");
		ologinPage = pageGeneratorManagerOpenCart.getLoginPage(driver);
		ologinPage.enterToDynamicTextbox("input-email", oemailValue);
		ologinPage.enterToDynamicTextbox("input-password", registerInfo.getPassword());
		passValue = ologinPage.getEmailDynamicValueTexbox("input-password");
		ologinPage.clickToDynamicButton("submit");
		myAccountPage = pageGeneratorManagerOpenCart.getMyAccountSideBarPage(driver);

	}

	@Test
	public void User_01_Sort_With_Name_A_To_Z() {
		myAccountPage.selectDynamicMenuDropdownAll("Show All Desktops","Desktops");
		sortPage = pageGeneratorManagerOpenCart.getSortAndDisplayPage(driver);
		sortPage.selectToDynamicDropDown("Name (A - Z)", "input-sort");
		Assert.assertTrue(sortPage.isProduceNameAToZ());


	}

	@Test
	public void User_02_Sort_With_Name_Z_To_A(Method method) {
		sortPage.selectToDynamicDropDown("Name (Z - A)", "input-sort");
		Assert.assertTrue(sortPage.isProduceNameZToA());
		
	}

	@Test
	public void User_03_Sort_With_Price_Low_To_High(Method method) {
		sortPage.selectToDynamicDropDown("Price (Low > High)", "input-sort");
		Assert.assertTrue(sortPage.isProducePriceLowToHigh());
	}
	
	@Test
	public void User_04_Sort_With_Price_High_To_Low(Method method) {
		sortPage.selectToDynamicDropDown("Price (High > Low)", "input-sort");
		Assert.assertTrue(sortPage.isProducePriceHighToLow());
	}

	@Test
	public void User_05_Display_With_10_Items_One_Page(Method method) {
		sortPage.selectToDynamicDropDown("10","input-limit");
		Assert.assertTrue(sortPage.isTensProduceDisplayed());
		Assert.assertTrue(sortPage.isNextIconDisplayed());
		sortPage.clickToNextIcon();
		Assert.assertTrue(sortPage.isPreciousIconDisplayed());
		
	}

	@Test
	public void User_06_Display_With_12_Items_One_Page(Method method) {
		sortPage.selectToDynamicDropDown("25","input-limit");
		Assert.assertTrue(sortPage.isTwelveProduceDisplayed());
	}

	


}
