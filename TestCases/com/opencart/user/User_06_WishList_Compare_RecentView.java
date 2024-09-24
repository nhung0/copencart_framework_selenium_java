package com.opencart.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.baseTest;
import common.pageGeneratorManagerOpenCart;
import pageObjects.opencart.ComparePageObject;
import pageObjects.opencart.DesktopstPageObject;
import pageObjects.opencart.HomePageObject;
import pageObjects.opencart.LoginPageObject;
import pageObjects.opencart.LogoutPageObject;
import pageObjects.opencart.MyAccountSideBarPageObject;
import pageObjects.opencart.RegisterPageObject;
import pageObjects.opencart.ShopCartPageObject;
import pageObjects.opencart.SortAndDisplayPageObject;
import pageObjects.opencart.WishListPageObject;
import pojoData.Opencart.RegisterInfo;


public class User_06_WishList_Compare_RecentView extends baseTest{
	WebDriver driver;
	private LoginPageObject ologinPage;
	private SortAndDisplayPageObject sortPage;

	private HomePageObject ohomePage;
	private ShopCartPageObject shopCartPage;
	private MyAccountSideBarPageObject myAccountPage;
	private RegisterPageObject oregisterPage;
	private LogoutPageObject logoutPage;
	private DesktopstPageObject desktopPage;
	private WishListPageObject wishPage;
	private ComparePageObject comparePage;

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
		myAccountPage.selectDynamicMenuDropdown("Mac (2)","Desktops");
		desktopPage = pageGeneratorManagerOpenCart.getDesktopstPage(driver);
		desktopPage.clickToDynamicItemNameLink("product-list","iMac");

	}

	@Test
	public void User_01_Add_To_WishList() {
		desktopPage.clickToWishListLabelButton();
		System.out.println(2);
		Assert.assertTrue(desktopPage.isAlertErrorMessageDisplayed("alert"));
		
		
		desktopPage.clickToWishListHeaderButton();
	
		wishPage = pageGeneratorManagerOpenCart.getWishListPage(driver);
		wishPage.isMyWishlistTextDisplayed();
		
		Assert.assertTrue(wishPage.isImageItemDisplayed("wishlist","iMac"));
		Assert.assertTrue(wishPage.isProductNameLinkItemDisplayed("wishlist","iMac"));
		Assert.assertEquals(wishPage.getModelItemText("wishlist","Product 14"), "Product 14");
		Assert.assertEquals(wishPage.getWishListPriceItemText("wishlist"), "$122.00");

	}

	@Test
	public void User_02_Add_Product_To_Cart_From_WishList_Page(Method method) {
		wishPage.clickToCartLabelButton();
		desktopPage = pageGeneratorManagerOpenCart.getDesktopstPage(driver);
		desktopPage.clickToDynamicCheckBoxButtonByID("input-option-value-17");
		desktopPage.clickToViewItemButton("button-cart");
		Assert.assertTrue(desktopPage.isAlertErrorMessageDisplayed("alert"));
		Assert.assertEquals(desktopPage.getTotalPriceItemTextDisplayed("header-cart"), "$128.00");
		
		
		desktopPage.clickToTableCartButton();
		shopCartPage = pageGeneratorManagerOpenCart.getShopCartPage(driver);
		Assert.assertTrue(shopCartPage.isImageItemDisplayed("shopping-cart","iMac"));
		Assert.assertTrue(shopCartPage.isProductNameLinkItemDisplayed("shopping-cart","iMac"));
		Assert.assertEquals(shopCartPage.getModelItemText("shopping-cart","Product 14"), "Product 14");
		Assert.assertEquals(shopCartPage.getUnitPriceItemText("shopping-cart"), "$128.00");
		
	}

	@Test
	public void User_03_Remove_Product_In_WishList_Page(Method method) {
		shopCartPage.clickToWishListHeaderButton();
		wishPage = pageGeneratorManagerOpenCart.getWishListPage(driver);
		wishPage.clickToRemoveLabelButton();
		Assert.assertTrue(wishPage.isAlertErrorMessageDisplayed("alert"));
		Assert.assertTrue(wishPage.isEmptyMessageDisplayed("Your wish list is empty."));
		
	
	}
	
	@Test
	public void User_04_Add_Product_To_Compare(Method method) {
		wishPage.selectDynamicMenuDropdown("Mac (2)","Desktops");
		desktopPage = pageGeneratorManagerOpenCart.getDesktopstPage(driver);
		desktopPage.clickToDynamicItemNameLink("product-list","iMac");
		desktopPage.clickToDynamicCompareLabelButton("iMac");
		Assert.assertTrue(desktopPage.isAlertErrorMessageDisplayed("alert"));
		
		
		desktopPage.selectDynamicMenuDropdown("Monitors (2)","Components");
		desktopPage.clickToDynamicItemNameLink("product-list","Apple Cinema 30");
		desktopPage.clickToDynamicCompareLabelButton("Apple Cinema 30");
		
		Assert.assertTrue(desktopPage.isAlertErrorMessageDisplayed("alert"));
	
		
		
	}
	
	
}
