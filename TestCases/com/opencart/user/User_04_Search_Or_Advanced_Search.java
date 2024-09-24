package com.opencart.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.baseTest;
import common.pageGeneratorManagerOpenCart;
import pageObjects.opencart.AddressPageObject;
import pageObjects.opencart.ChangePasswordPageObject;
import pageObjects.opencart.DesktopstPageObject;
import pageObjects.opencart.EditCustormerPageObject;
import pageObjects.opencart.HomePageObject;
import pageObjects.opencart.LoginPageObject;
import pageObjects.opencart.LogoutPageObject;
import pageObjects.opencart.MyAccountSideBarPageObject;
import pageObjects.opencart.RegisterPageObject;
import pageObjects.opencart.SearchPageObject;
import pageObjects.opencart.WishListPageObject;
import pojoData.Opencart.AddressInfo;
import pojoData.Opencart.ChangePasswordInfo;
import pojoData.Opencart.EditCustomerInfo;
import pojoData.Opencart.LoginInfo;
import pojoData.Opencart.RegisterInfo;

public class User_04_Search_Or_Advanced_Search extends baseTest {
	WebDriver driver;
	private LoginPageObject ologinPage;

	private HomePageObject ohomePage;

	private MyAccountSideBarPageObject myAccountPage;
	private RegisterPageObject oregisterPage;
	private LogoutPageObject logoutPage;
	private SearchPageObject searchPage;
	protected String updatedEmail;
	protected String passValue;

	private LoginInfo loginInfo;
	private RegisterInfo registerInfo;

	private String oemailValue;

	@Parameters({ "url", "browser" })
	@BeforeClass
	public void beforeClass(String url, String browserName) {
		driver = getBrowserDriver(url, browserName);
		loginInfo = new LoginInfo();
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
	public void User_01_Search_With_Empty_Data() {
		myAccountPage.clickToSearchBarButton();
		searchPage = pageGeneratorManagerOpenCart.getSearchPage(driver);
		searchPage.enterToDynamicTextbox("input-search", "digit");
		System.out.println(2);
		searchPage.clickToSearchButton();

		Assert.assertTrue(searchPage.isErrorSearchTextDisplayed());

	}

	@Test
	public void User_02_Search_With_Data_No_Exist(Method method) {
		searchPage.enterToDynamicTextbox("input-search", "Nokia 2050");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isErrorSearchTextDisplayed());

	}

	@Test
	public void User_03_Search_With_Product_Name_Relatively(Method method) {
		searchPage.enterToDynamicTextbox("input-search", "Samsung");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isProductNameLinkItemDisplayed("product-list", "Samsung SyncMaster 941BW"));
		Assert.assertTrue(searchPage.isProductNameLinkItemDisplayed("product-list", "Samsung Galaxy Tab 10.1"));

	}

	@Test
	public void User_04_Search_With_Product_Name_Relatively_With_Parent_Categories(Method method) {
		searchPage.enterToDynamicTextbox("input-search", "Samsung");
		searchPage.selectCategoriesDropdown("Desktops");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isProductNameLinkItemDisplayed("product-list", "Samsung SyncMaster 941BW"));
		searchPage.enterToDynamicTextbox("input-search", "Samsung");
		searchPage.selectCategoriesDropdown("Tablets");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isProductNameLinkItemDisplayed("product-list", "Samsung Galaxy Tab 10.1"));

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
