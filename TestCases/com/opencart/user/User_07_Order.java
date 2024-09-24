package com.opencart.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.baseTest;
import common.pageGeneratorManagerOpenCart;
import pageObjects.opencart.CheckOutPageObject;
import pageObjects.opencart.ComparePageObject;
import pageObjects.opencart.DesktopstPageObject;
import pageObjects.opencart.HomePageObject;
import pageObjects.opencart.LoginPageObject;
import pageObjects.opencart.LogoutPageObject;
import pageObjects.opencart.MyAccountSideBarPageObject;
import pageObjects.opencart.OrderPageObject;
import pageObjects.opencart.RegisterPageObject;
import pageObjects.opencart.ShopCartPageObject;
import pageObjects.opencart.SortAndDisplayPageObject;
import pageObjects.opencart.SuccessPageObject;
import pageObjects.opencart.WishListPageObject;
import pojoData.Opencart.RegisterInfo;
import pojoData.Opencart.ShippingInfo;

public class User_07_Order extends baseTest{
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
	private String date;
	private String time;
	private ShippingInfo shippingInfor;
	private CheckOutPageObject checkPage;
	private SuccessPageObject successPage;
	private OrderPageObject orderPage;
	
	

	protected String updatedEmail;
	protected String passValue;


	private RegisterInfo registerInfo;

	private String oemailValue;

	@Parameters({ "url", "browser" })
	@BeforeClass
	public void beforeClass(String url, String browserName) {
		driver = getBrowserDriver(url, browserName);
		
		registerInfo = new RegisterInfo();
		shippingInfor = new ShippingInfo();
		
		registerInfo.setFirstName("Lucy");
		registerInfo.setLastName("Kudo");
		registerInfo.setPassword("123456");
		shippingInfor.setFirstName("Lily");
		shippingInfor.setLastName("Hole");
		shippingInfor.setAddress1("09/67 Hang Gai");
		shippingInfor.setAddress2("09/67 Hang Ma");
		shippingInfor.setCity("Madrid");
		shippingInfor.setCompany("Automation");
		shippingInfor.setPaymentMethod("Card");
		shippingInfor.setShippMethod("Train");
		shippingInfor.setPostCode("123245");
		
		

		ohomePage = pageGeneratorManagerOpenCart.getHomePage(driver);
		//ohomePage.clickToAccountLink();

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
		myAccountPage.selectDynamicMenuDropdown("Monitors (2)","Components");
		desktopPage = pageGeneratorManagerOpenCart.getDesktopstPage(driver);
		desktopPage.clickToDynamicItemNameLink("product-list", "Apple Cinema 30");
		
		

	}

	@Test
	public void User_01_Add_Produce_To_Cart() {
		
		desktopPage.clickToDynamicRadioButtonByID("input-option-value-6");
		desktopPage.clickToDynamicCheckBoxButtonByID("input-option-value-9");
		desktopPage.enterToDynamicTextbox("input-option-208", "Testing");
		desktopPage.selectToDynamicDropDown("Red","input-option-217");
		System.out.println(2);
		desktopPage.enterToTextBoxArea("input-option-209", "Automation");
		desktopPage.upLoadFile("hanoi.png");
		System.out.println(3);
		
		desktopPage.clickToAlert();
		desktopPage.enterToDynamicTextbox("input-option-219", "21/01/2024");
		date = desktopPage.getDynamicValueTexbox("input-option-219");
		desktopPage.enterToDynamicTextbox("input-option-221", "22:12");
		time = desktopPage.getDynamicValueTexbox("input-option-221");
		desktopPage.enterToDynamicTextbox("input-option-220", date.concat("").concat(date));
		
		desktopPage.clickToViewItemButton("button-cart");
		Assert.assertTrue(desktopPage.isAlertErrorMessageDisplayed("alert"));
		
		Assert.assertTrue(desktopPage.isProductNameLinkItemDisplayed("header-cart", "Apple Cinema 30"));
		desktopPage.clickToTableCartButton();
		shopCartPage = pageGeneratorManagerOpenCart.getShopCartPage(driver);
		Assert.assertTrue(shopCartPage.isImageItemDisplayed("shopping-cart","Apple Cinema 30"));
		Assert.assertTrue(shopCartPage.isProductNameLinkItemDisplayed("shopping-cart","Apple Cinema 30"));
		Assert.assertEquals(shopCartPage.getModelItemText("shopping-cart","Product 10"), "Product 10");
		Assert.assertEquals(shopCartPage.getTotalPriceItemTextDisplayed("shopping-cart"),"$323.60");
		
	}

	@Test
	public void User_02_Add_Info_In_Equiry_Form(Method method) {
		shopCartPage.clickToDynamicItemNameLink("shopping-cart","Apple Cinema 30");
		desktopPage = pageGeneratorManagerOpenCart.getDesktopstPage(driver);
		desktopPage.clickToRequiryButton();

		desktopPage.enterToDynamicTextbox("customer", "Alex");
		desktopPage.enterToDynamicTextbox("mobile", "0989765443");
		desktopPage.enterToDynamicTextbox("email", "lycy@gmail.com");
		desktopPage.enterToDynamicTexareaBox("message", "thanks");
		
		desktopPage.clickToViewItemButton("submitEnquiry");
		Assert.assertTrue(desktopPage.isRequiryMessageDisplayed());
		desktopPage.clickToCloseButton();
	
		
	}

	@Test
	public void User_03_Remove_From_Cart(Method method) {
		
		desktopPage.selectDynamicMenuDropdown("Monitors (2)","Components");
		
		desktopPage.clickToDynamicItemNameLink("product-list","Samsung SyncMaster 941BW");
		desktopPage.clickToViewItemButton("button-cart");
		Assert.assertTrue(desktopPage.isAlertErrorMessageDisplayed("alert"));
		Assert.assertTrue(desktopPage.isProductNameLinkItemDisplayed("header-cart", "Samsung SyncMaster 941BW"));
		desktopPage.clickToTableCartButton();
		shopCartPage = pageGeneratorManagerOpenCart.getShopCartPage(driver);
		shopCartPage.clickToRemoveButton("Samsung SyncMaster 941BW");
		Assert.assertTrue(shopCartPage.isAlertErrorMessageDisplayed("alert"));
	}
	
	@Test
	public void User_04_Update_Shopping_Cart(Method method) {
		shopCartPage.enterToQuantityTexbox("Apple Cinema 30","3");
		shopCartPage.clickToUpdateButton("Apple Cinema 30");
		Assert.assertEquals(shopCartPage.getTotalPriceItemTextDisplayed("shopping-cart"),"$484.40");
	}
	
	@Test
	public void User_05_Checkout_Order_With_New_Address(Method method) {
		shopCartPage.clickToCheckOutButton();
		checkPage = pageGeneratorManagerOpenCart.getCheckOutPage(driver);
		checkPage.enterToDynamicTextbox("input-shipping-firstname", shippingInfor.getFirstName());
		checkPage.enterToDynamicTextbox("input-shipping-lastname", shippingInfor.getLastName());
		checkPage.enterToDynamicTextbox("input-shipping-company", shippingInfor.getCompany());
		checkPage.enterToDynamicTextbox("input-shipping-address-1", shippingInfor.getAddress1());
		checkPage.enterToDynamicTextbox("input-shipping-address-2", shippingInfor.getAddress2());
		checkPage.enterToDynamicTextbox("input-shipping-city", shippingInfor.getCity());
		checkPage.enterToDynamicTextbox("input-shipping-postcode", shippingInfor.getPostCode());
		checkPage.selectToShippingNationalityDropdown("Viet Nam");
		checkPage.selectToShippingStateDropdown("Da Nang");
		checkPage.clickToViewItemButton("button-shipping-address");
		Assert.assertTrue(checkPage.isAlertErrorMessageDisplayed("alert"));
		Assert.assertEquals(checkPage.getTotalPriceCheckOutWithoutShippingTextDisplayed(),"$361.80");
	}
	
	@Test
	public void User_06_Checkout_Order_With_Shipping_And_Payment_By_Card(Method method) {
		checkPage.clickToDynamicRadioButtonByID("input-shipping-existing");
		Assert.assertTrue(checkPage.isAlertErrorMessageDisplayed("alert"));
		checkPage.clickToShippingAndPaymentMethodButton("checkout-shipping-method","button-shipping-methods","input-shipping-method-flat-flat");
		checkPage.clickToViewItemButton("button-shipping-method");
		Assert.assertTrue(checkPage.isAlertErrorMessageDisplayed("alert"));
		checkPage.clickToShippingAndPaymentMethodButton("checkout-payment-method","button-payment-methods","input-payment-method-bank_transfer-bank-transfer");
		checkPage.clickToViewItemButton("button-payment-method");
		checkPage.enterToDynamicTexareaBox("input-comment", "thank you");
		Assert.assertEquals(shopCartPage.getTotalPriceCheckOutTextDisplayed(),"$366.80");
		checkPage.clickToViewItemButton("button-confirm");
		Assert.assertTrue(checkPage.isAlertErrorMessageDisplayed("alert"));
		successPage = pageGeneratorManagerOpenCart.getSuccessPage(driver);
		Assert.assertTrue(successPage.isOrderMessageDisplayed());
		
		
		
	}
	
	
	
	
	@Test
	public void User_07_Checkout_Order_With_Shipping_And_Payment_By_Cash(Method method) {
	
		successPage.selectDynamicMenuDropdown("Monitors (2)","Components");
		desktopPage = pageGeneratorManagerOpenCart.getDesktopstPage(driver);
		desktopPage.clickToDynamicItemNameLink("product-list", "Apple Cinema 30");
		desktopPage.clickToDynamicRadioButtonByID("input-option-value-6");
		desktopPage.clickToDynamicCheckBoxButtonByID("input-option-value-9");
		desktopPage.enterToDynamicTextbox("input-option-208", "Testing");
		desktopPage.selectToDynamicDropDown("Red","input-option-217");
		
		desktopPage.enterToTextBoxArea("input-option-209", "Automation");
		desktopPage.upLoadFile("hanoi.png");
	
		
		desktopPage.clickToAlert();
		desktopPage.enterToDynamicTextbox("input-option-219", "21/01/2024");
		date = desktopPage.getDynamicValueTexbox("input-option-219");
		desktopPage.enterToDynamicTextbox("input-option-221", "22:12");
		time = desktopPage.getDynamicValueTexbox("input-option-221");
		desktopPage.enterToDynamicTextbox("input-option-220", date.concat("").concat(date));
		
		desktopPage.clickToViewItemButton("button-cart");
		Assert.assertTrue(desktopPage.isAlertErrorMessageDisplayed("alert"));
		
		Assert.assertTrue(desktopPage.isProductNameLinkItemDisplayed("header-cart", "Apple Cinema 30"));
		desktopPage.clickToTableCartButton();
		shopCartPage = pageGeneratorManagerOpenCart.getShopCartPage(driver);
		shopCartPage.clickToCheckOutButton();
		checkPage = pageGeneratorManagerOpenCart.getCheckOutPage(driver);
		
		checkPage.clickToDynamicRadioButtonByID("input-shipping-existing");
		Assert.assertTrue(checkPage.isAlertErrorMessageDisplayed("alert"));
		checkPage.clickToShippingAndPaymentMethodButton("checkout-shipping-method","button-shipping-methods","input-shipping-method-flat-flat");
		checkPage.clickToViewItemButton("button-shipping-method");
		Assert.assertTrue(checkPage.isAlertErrorMessageDisplayed("alert"));
		checkPage.clickToShippingAndPaymentMethodButton("checkout-payment-method","button-payment-methods","input-payment-method-cod-cod");
		checkPage.clickToViewItemButton("button-payment-method");
		checkPage.enterToDynamicTexareaBox("input-comment", "thank you");
		Assert.assertEquals(shopCartPage.getTotalPriceCheckOutTextDisplayed(),"$246.20");
		checkPage.clickToViewItemButton("button-confirm");
		Assert.assertTrue(checkPage.isAlertErrorMessageDisplayed("alert"));
		successPage = pageGeneratorManagerOpenCart.getSuccessPage(driver);
		Assert.assertTrue(successPage.isOrderMessageDisplayed());
		
	}
	
	@Test
	public void User_08_Re_Order(Method method) {
		successPage.selectToMyAccountDropdown("Order History");
		orderPage = pageGeneratorManagerOpenCart.getOrderPage(driver);
		orderPage.clickToViewButton("$366.80");
		orderPage.clickReorderButton();
		Assert.assertTrue(orderPage.isOrderInfoDisplayed("3 item(s) - $361.80"));
		
		successPage.selectToMyAccountDropdown("Order History");
		orderPage = pageGeneratorManagerOpenCart.getOrderPage(driver);
		orderPage.clickToViewButton("$246.20");
		orderPage.clickReorderButton();
		Assert.assertTrue(orderPage.isOrderInfoDisplayed("5 item(s) - $603.00"));
	}
}
