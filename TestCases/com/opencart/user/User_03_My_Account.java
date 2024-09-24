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
import pageObjects.opencart.WishListPageObject;
import pojoData.Opencart.AddressInfo;
import pojoData.Opencart.ChangePasswordInfo;
import pojoData.Opencart.EditCustomerInfo;
import pojoData.Opencart.LoginInfo;
import pojoData.Opencart.RegisterInfo;

public class User_03_My_Account extends baseTest {
	WebDriver driver;
	private LoginPageObject ologinPage;

	private HomePageObject ohomePage;
	private LoginInfo loginInfo;
	private RegisterInfo registerInfo;
	private MyAccountSideBarPageObject myAccountPage;
	private RegisterPageObject oregisterPage;
	private LogoutPageObject logoutPage;
	private String oemailValue;
	private EditCustomerInfo editCusInfo;
	private EditCustormerPageObject editCusPage;
	private AddressPageObject addressPage;
	private AddressInfo addressInfo;
	private ChangePasswordInfo passInfo;
	private ChangePasswordPageObject passPage;
	private DesktopstPageObject desktopPage;
	private WishListPageObject wishPage;
	protected String passValue;

	protected String updatedEmail;

	@Parameters({ "url", "browser" })
	@BeforeClass
	public void beforeClass(String url, String browserName) {
		driver = getBrowserDriver(url, browserName);
		loginInfo = new LoginInfo();
		registerInfo = new RegisterInfo();
		editCusInfo = new EditCustomerInfo();
		addressInfo = new AddressInfo();
		passInfo = new ChangePasswordInfo();

		registerInfo.setFirstName("Lucy");
		registerInfo.setLastName("Kudo");
		registerInfo.setPassword("123456");
		registerInfo.setEmail("pham12345@gmail.com");

		editCusInfo.setFirstName("Alex");
		editCusInfo.setLastName("Nguyen");
		editCusInfo.setEmail("alex12345@gmail.com");

		addressInfo.setCompany("Automation");
		addressInfo.setCity("Hanoi");
		addressInfo.setAddress1("123/04 Hang Dao");
		addressInfo.setAddress2("234/09 Hang Chuoi");
		addressInfo.setPostCode("550000");

		passInfo.setPassword("112233");

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
		System.out.println(1);
		ologinPage = pageGeneratorManagerOpenCart.getLoginPage(driver);
		ologinPage.enterToDynamicTextbox("input-email", oemailValue);
		ologinPage.enterToDynamicTextbox("input-password", registerInfo.getPassword());
		passValue = ologinPage.getEmailDynamicValueTexbox("input-password");
		ologinPage.clickToDynamicButton("submit");
		myAccountPage = pageGeneratorManagerOpenCart.getMyAccountSideBarPage(driver);

	}

	@Test
	public void User_01_Update_Customer_Info() {
		myAccountPage.clickToDynamicPageLink("Edit Account");
		editCusPage = pageGeneratorManagerOpenCart.getEditCustormerPage(driver);
		editCusPage.enterToDynamicTextbox("input-firstname", editCusInfo.getFirstName());
		editCusPage.enterToDynamicTextbox("input-lastname", editCusInfo.getLastName());
		editCusPage.enterToDynamicTextbox("input-email", randomEmail());
		updatedEmail = editCusPage.getEmailDynamicValueTexbox("input-email");

		editCusPage.clickToDynamicButton("submit");
		myAccountPage = pageGeneratorManagerOpenCart.getMyAccountSideBarPage(driver);
		Assert.assertTrue(myAccountPage.isSuccessfullyUpdatedAccountDisplayed());

	}

	@Test
	public void User_02_Add_Book_Address(Method method) {
		myAccountPage.clickToDynamicPageLink("Address Book");
		addressPage = pageGeneratorManagerOpenCart.getAddressPage(driver);
		addressPage.clickAddressButton();

		addressPage.enterToDynamicTextbox("input-firstname", registerInfo.getFirstName());
		addressPage.enterToDynamicTextbox("input-lastname", registerInfo.getLastName());
		addressPage.enterToDynamicTextbox("input-company", addressInfo.getCompany());
		addressPage.enterToDynamicTextbox("input-address-1", addressInfo.getAddress1());
		addressPage.enterToDynamicTextbox("input-address-2", addressInfo.getAddress2());
		addressPage.enterToDynamicTextbox("input-city", addressInfo.getCity());
		addressPage.enterToDynamicTextbox("input-postcode", addressInfo.getPostCode());

		addressPage.selectToNationalityDropdown("Viet Nam");
		addressPage.selectToStateDropdown("Ha Noi");
		addressPage.clickToDynamicRadioButtonByID("input-default-no");
		addressPage.clickToDynamicButton("submit");
		Assert.assertTrue(addressPage.isSuccessfullyAddressTextDisplayed());

	}

	@Test
	public void User_03_Change_Password(Method method) {
		addressPage.clickToDynamicPageLink("Password");

		passPage = pageGeneratorManagerOpenCart.getChangePasswordPage(driver);

		passPage.enterToDynamicTextbox("input-password", passInfo.getPassword());
		passPage.enterToDynamicTextbox("input-confirm", passInfo.getPassword());

		passPage.clickToDynamicButton("submit");
		myAccountPage = pageGeneratorManagerOpenCart.getMyAccountSideBarPage(driver);

		Assert.assertTrue(myAccountPage.isSuccessfullyChangePasswordDisplayed());

		myAccountPage.selectToMyAccountDropdown("Logout");
		logoutPage = pageGeneratorManagerOpenCart.getLogoutPage(driver);
		logoutPage.selectToMyAccountDropdown("Login");
		ologinPage = pageGeneratorManagerOpenCart.getLoginPage(driver);
		ologinPage.enterToDynamicTextbox("input-email", updatedEmail);
		ologinPage.enterToDynamicTextbox("input-password", registerInfo.getPassword());
		ologinPage.clickToDynamicButton("submit");
		Assert.assertTrue(ologinPage.isAlertErrorMessageDisplayed("alert"));
		ologinPage.selectToMyAccountDropdown("Login");
		ologinPage.enterToDynamicTextbox("input-email", updatedEmail);
		ologinPage.enterToDynamicTextbox("input-password", passInfo.getPassword());
		ologinPage.clickToDynamicButton("submit");
		myAccountPage = pageGeneratorManagerOpenCart.getMyAccountSideBarPage(driver);
		Assert.assertTrue(myAccountPage.isMyAccountTextDisplayed());

	}

	@Test
	public void User_04_WishList_Page(Method method) {
		myAccountPage.selectDynamicMenuDropdown("Mac (2)", "Desktops");
		desktopPage = pageGeneratorManagerOpenCart.getDesktopstPage(driver);
		desktopPage.clickToDynamicItemNameLink("product-list", "iMac");
		desktopPage.clickToOptionLabelButton("wishlist");
		System.out.println(2);
		Assert.assertTrue(desktopPage.isAlertErrorMessageDisplayed("alert"));
	
		
		System.out.println(3);
		desktopPage.selectToMyAccountDropdown("My Account");
		myAccountPage = pageGeneratorManagerOpenCart.getMyAccountSideBarPage(driver);
		System.out.println(5);
		myAccountPage.clickToDynamicPageLink("Wish List");
		System.out.println(4);
		wishPage = pageGeneratorManagerOpenCart.getWishListPage(driver);
		wishPage.isMyWishlistTextDisplayed();

		Assert.assertTrue(wishPage.isImageItemDisplayed("account-wishlist", "iMac"));
		Assert.assertTrue(wishPage.isProductNameLinkItemDisplayed("account-wishlist", "iMac"));
		Assert.assertEquals(wishPage.getModelItemText("account-wishlist", "Product 14"), "Product 14");
		Assert.assertEquals(wishPage.getUnitPriceItemText("account-wishlist"), "$122.00");

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
