package com.opencart.admin;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.baseTest;
import common.globalConstants;
import common.pageGeneratorManagerOpenCart;
import pageObject.opencard.admin.CustomerAdminPageObject;
import pageObject.opencard.admin.DashboardAdminPageObject;
import pageObject.opencard.admin.ProductAdminPageObject;
import pageObject.opencard.admin.StartAdminPageObject;

import pageObjects.opencart.HomePageObject;
import pageObjects.opencart.LoginPageObject;
import pageObjects.opencart.RegisterPageObject;
import pojoData.Opencart.AdminInfo;
import pojoData.Opencart.RegisterInfo;

public class User_08_Total_Admin extends baseTest {
	WebDriver driver;
	private StartAdminPageObject startPage;
	private DashboardAdminPageObject dashboardPage;
	private AdminInfo adminInfo;
	private ProductAdminPageObject productPage;
	private CustomerAdminPageObject cusPage;
	private String fullName;

	@Parameters({ "url", "browser" })
	@BeforeClass
	public void beforeClass(String url, String browserName) {
		driver = getBrowserDriver(url, browserName);
		adminInfo = new AdminInfo();
		adminInfo.setProduceName("Apple Cinema 30");
		adminInfo.setProduceModel("Product 10");
		adminInfo.setProducePrice("10");
		adminInfo.setProduceQuantity("10");
		adminInfo.setCusFirstName("May");
		adminInfo.setCusLastName("Mike");
		adminInfo.setCusEmail("mayqaaaaaaaaa@gmail.com");
		adminInfo.setCusPhoneNumber("0908765766");
		adminInfo.setCusPassword("1234");

		adminInfo.setEditCusFirstName("May11");
		adminInfo.setEditCusLastName("Mike11");
		adminInfo.setEditCusEmail("may222222222@gmail.com");
		adminInfo.setEditCusPhoneNumber("01908765761");
		adminInfo.setEditCusPassword("12345");

		adminInfo.setFirstCusCompany("Local");
		adminInfo.setFirstCusAddress1("345 Hang Trong");
		adminInfo.setFirstCusAddress2("321 Hang Ma");
		adminInfo.setFirstCusCity("Ha Noi");
		adminInfo.setFirstPostcode("HN1010");

		startPage = pageGeneratorManagerOpenCart.getStartAdminPage(driver);
		startPage.enterToDynamicTextbox("input-username", globalConstants.ADMIN_OPENCART_USERNAME);
		startPage.enterToDynamicTextbox("input-password", globalConstants.ADMIN_OPENCART_PASSWORD);
		startPage.clickToDynamicButton("submit");

	}

	@Test
	public void User_01_Search_With_Product_Name() {
		dashboardPage = pageGeneratorManagerOpenCart.getDashboardAdminPage(driver);
		dashboardPage.clickRemovePopupButton();
		dashboardPage.selectToBarDynamicDropDown("Products", "menu-catalog", "Catalog");
		System.out.println("a");

		productPage = pageGeneratorManagerOpenCart.getProductAdminPage(driver);
		productPage.enterToDynamicTextbox("input-name", adminInfo.getProduceName());
		productPage.clickToViewItemButton("button-filter");
		Assert.assertTrue(productPage.isImageItemDisplayed("product", "Apple Cinema 30"));
		Assert.assertTrue(productPage.isProductNameDisplayed("product", "Apple Cinema 30"));
		Assert.assertEquals(productPage.getModelItemText("product", "Product 10"), "Product 10");
		Assert.assertTrue(productPage.isProductQuantityDisplayed("product", "10"));
		System.out.println("b");

	}

	@Test
	public void User_02_Search_With_Product_Name_And_Correct_Model_And_Incorrect_Model(Method method) {
		productPage.enterToDynamicTextbox("input-name", adminInfo.getProduceName());
		productPage.enterToDynamicTextbox("input-model", adminInfo.getProduceModel());
		productPage.clickToViewItemButton("button-filter");
		Assert.assertTrue(productPage.isImageItemDisplayed("product", "Apple Cinema 30"));
		Assert.assertTrue(productPage.isProductNameDisplayed("product", "Apple Cinema 30"));
		Assert.assertEquals(productPage.getModelItemText("product", "Product 1"), "Product 1");
		Assert.assertTrue(productPage.isProductQuantityDisplayed("product", "1"));
		productPage.enterToDynamicTextbox("input-name", adminInfo.getProduceName());
		productPage.enterToDynamicTextbox("input-model", "Product 17");
		productPage.clickToViewItemButton("button-filter");
		Assert.assertTrue(productPage.isErrorMessageDisplayed("product", "No results!"));

	}

	@Test
	public void User_03_Search_With_Product_Name_Incorrect_Price(Method method) {
		productPage.enterToDynamicTextbox("input-name", adminInfo.getProduceName());
		productPage.enterToDynamicTextbox("input-price", "2");
		productPage.clickToViewItemButton("button-filter");
		Assert.assertTrue(productPage.isErrorMessageDisplayed("product", "No results!"));

	}

	@Test
	public void User_04_Search_With_Product_Name_Incorrect_Quantity(Method method) {
		productPage.enterToDynamicTextbox("input-name", adminInfo.getProduceName());
		productPage.enterToDynamicTextbox("input-quantity", "2");
		productPage.clickToViewItemButton("button-filter");
		Assert.assertTrue(productPage.isErrorMessageDisplayed("product", "No results!"));

	}

	@Test
	public void User_05_Search_With_Product_Name_Incorrect_Status(Method method) {
		productPage.enterToDynamicTextbox("input-name", adminInfo.getProduceName());
		productPage.selectToDynamicDropDown("Disabled", "input-status");
		productPage.clickToViewItemButton("button-filter");
		Assert.assertTrue(productPage.isErrorMessageDisplayed("product", "No results!"));

	}

	@Test
	public void User_06_Search_With_Correct_Full_Info(Method method) {
		productPage.enterToDynamicTextbox("input-name", adminInfo.getProduceName());
		productPage.enterToDynamicTextbox("input-model", adminInfo.getProduceModel());
		productPage.enterToDynamicTextbox("input-price", adminInfo.getProducePrice());
		productPage.enterToDynamicTextbox("input-quantity", adminInfo.getProduceQuantity());
		productPage.selectToDynamicDropDown("Enabled", "input-status");
		productPage.clickToViewItemButton("button-filter");
		Assert.assertTrue(productPage.isImageItemDisplayed("product", "Apple Cinema 30"));
		Assert.assertTrue(productPage.isProductNameDisplayed("product", "Apple Cinema 30"));
		Assert.assertEquals(productPage.getModelItemText("product", "Product 1"), "Product 1");
		Assert.assertTrue(productPage.isProductQuantityDisplayed("product", "1"));

	}

	@Test
	public void User_07_Edit_Product_By_Changing_Data(Method method) {
		productPage.clickToEditAdminButton("product");
		productPage.clickToDynamicTitleLink("form-product", "Data");
		productPage.enterToDynamicTextbox("input-model", "Product 10");

		productPage.enterToDynamicTextbox("input-price", "10");
		productPage.enterToDynamicTextbox("input-quantity", "10");
		productPage.clickToSaveAdminButton("content");
		Assert.assertTrue(productPage.isAlertMessageDisplayed("alert", "Success: You have modified products!"));

		productPage.clickToAddNewAndBackButton("content");

		productPage.enterToDynamicTextbox("input-name", adminInfo.getProduceName());
		productPage.enterToDynamicTextbox("input-model", "Product 10");
		productPage.enterToDynamicTextbox("input-price", "10");
		productPage.enterToDynamicTextbox("input-quantity", "10");
		productPage.selectToDynamicDropDown("Enabled", "input-status");
		productPage.clickToViewItemButton("button-filter");

		Assert.assertTrue(productPage.isImageItemDisplayed("product", "Apple Cinema 30"));
		Assert.assertTrue(productPage.isProductNameDisplayed("product", "Apple Cinema 30"));
		Assert.assertEquals(productPage.getModelItemText("product", "Product 10"), "Product 10");
		Assert.assertTrue(productPage.isProductQuantityDisplayed("product", "10"));

	}

	@Test
	public void User_08_Create_New_Customer(Method method) {
		productPage.clickToDashboardLink();
		dashboardPage = pageGeneratorManagerOpenCart.getDashboardAdminPage(driver);
		dashboardPage.clickRemovePopupButton();

		dashboardPage.selectToBarDynamicDropDown("Customers", "menu-customer", "Customers");
		cusPage = pageGeneratorManagerOpenCart.getCustomserAdminPage(driver);
		System.out.println("c");

		cusPage.clickToAddNewAndBackButton("content");
		cusPage.selectToDynamicDropDown("Default", "input-store");
		cusPage.selectToDynamicDropDown("Default", "input-customer-group");
		cusPage.enterToDynamicTextbox("input-firstname", adminInfo.getCusFirstName());
		cusPage.enterToDynamicTextbox("input-lastname", adminInfo.getCusLastName());
		cusPage.enterToDynamicTextbox("input-email", adminInfo.getCusEmail());
		cusPage.enterToDynamicTextbox("input-telephone", adminInfo.getCusPhoneNumber());
		cusPage.enterToDynamicTextbox("input-password", adminInfo.getCusPassword());
		cusPage.enterToDynamicTextbox("input-confirm", adminInfo.getCusPassword());

		cusPage.clickToToggleButton("input-status");
		cusPage.clickToSaveAdminButton("content");
		Assert.assertTrue(cusPage.isAlertMessageDisplayed("alert", "Success: You have modified customers!"));

	}

	@Test
	public void User_09_Search_New_Customer_With_Email(Method method) {
		cusPage.clickToAddNewAndBackButton("content");
		cusPage.enterToDynamicTextbox("input-name", adminInfo.getCusFirstName() + " " + adminInfo.getCusLastName());
		fullName = adminInfo.getCusFirstName() + " " + adminInfo.getCusLastName();
		System.out.println(fullName);
		cusPage.enterToDynamicTextbox("input-email", adminInfo.getCusEmail());
		cusPage.clickToViewItemButton("button-filter");
		Assert.assertEquals(cusPage.getDynamicCustomerValue(adminInfo.getCusEmail()), adminInfo.getCusEmail());
		Assert.assertEquals(cusPage.getDynamicCustomerValue("Default"), "Default");

	}

	@Test
	public void User_10_Search_New_Customer_With_Name_And_Status(Method method) {
		cusPage.enterToDynamicTextbox("input-name", adminInfo.getCusFirstName() + " " + adminInfo.getCusLastName());
		cusPage.selectToDynamicDropDown("Enabled", "input-status");
		cusPage.clickToViewItemButton("button-filter");
		Assert.assertEquals(cusPage.getDynamicStatusText(adminInfo.getCusEmail(), "Enabled"), "Enabled");

	}

	@Test
	public void User_11_Search_New_Customer_With_Full_Data(Method method) {
		cusPage.enterToDynamicTextbox("input-name", adminInfo.getCusFirstName() + " " + adminInfo.getCusLastName());
		cusPage.enterToDynamicTextbox("input-email", adminInfo.getCusEmail());
		cusPage.selectToDynamicDropDown("Default", "input-customer-group");
		cusPage.selectToDynamicDropDown("Enabled", "input-status");
		cusPage.clickToViewItemButton("button-filter");

		Assert.assertEquals(cusPage.getDynamicCustomerValue(adminInfo.getCusEmail()), adminInfo.getCusEmail());
		Assert.assertEquals(cusPage.getDynamicCustomerValue("Default"), "Default");

	}

	@Test
	public void User_12_Edit_Customer(Method method) {
		cusPage.clickToEditAdminButton("customer");

		cusPage.selectToDynamicDropDown("Default", "input-store");
		cusPage.selectToDynamicDropDown("Default", "input-customer-group");
		cusPage.enterToDynamicTextbox("input-firstname", adminInfo.getEditCusFirstName());
		cusPage.enterToDynamicTextbox("input-lastname", adminInfo.getEditCusLastName());
		cusPage.enterToDynamicTextbox("input-email", adminInfo.getEditCusEmail());
		cusPage.enterToDynamicTextbox("input-telephone", adminInfo.getEditCusPhoneNumber());
		cusPage.enterToDynamicTextbox("input-password", adminInfo.getEditCusPassword());
		cusPage.enterToDynamicTextbox("input-confirm", adminInfo.getEditCusPassword());

		cusPage.clickToToggleButton("input-status");
		cusPage.clickToSaveAdminButton("content");
		Assert.assertTrue(cusPage.isAlertMessageDisplayed("alert", "Success: You have modified customers!"));
		cusPage.clickToCusBackButton("content");

		cusPage.enterToDynamicTextbox("input-name",
				adminInfo.getEditCusFirstName() + " " + adminInfo.getEditCusLastName());
		cusPage.enterToDynamicTextbox("input-email", adminInfo.getEditCusEmail());
		cusPage.clickToViewItemButton("button-filter");

		Assert.assertEquals(cusPage.getDynamicCustomerValue(adminInfo.getEditCusEmail()), adminInfo.getEditCusEmail());
		Assert.assertEquals(cusPage.getDynamicCustomerValue("Default"), "Default");

	}

	@Test
	public void User_13_Add_New_Address_In_Customer_Detail(Method method) {
		cusPage.clickToEditAdminButton("customer");
		cusPage.clickToDynamicTitleLink("form-customer", "Addresses");
		cusPage.clickToViewItemButton("button-address");
		cusPage.enterToDynamicTextbox("input-address-0-firstname", adminInfo.getEditCusFirstName());
		cusPage.enterToDynamicTextbox("input-address-0-lastname", adminInfo.getEditCusLastName());

		cusPage.enterToDynamicTextbox("input-address-0-company", adminInfo.getFirstCusCompany());
		cusPage.enterToDynamicTextbox("input-address-0-address-1", adminInfo.getFirstCusAddress1());
		cusPage.enterToDynamicTextbox("input-address-0-address-2", adminInfo.getFirstCusAddress2());
		cusPage.enterToDynamicTextbox("input-address-0-city", adminInfo.getFirstCusCity());
		cusPage.enterToDynamicTextbox("input-address-0-postcode", adminInfo.getFirstPostcode());

		cusPage.selectToDynamicDropDown("Viet Nam", "input-address-0-country");
		cusPage.selectToDynamicDropDown("Ha Noi", "input-address-0-zone");
		cusPage.clickToDynamicRadioButtonByID("input-address-0-default");
		cusPage.clickToSaveAdminButton("content");
		Assert.assertTrue(cusPage.isAlertMessageDisplayed("alert", "Success: You have modified customers!"));

	}

	@Test
	public void User_14_Delete_Address_In_Customer_Detail(Method method) {
		cusPage.clickToDynamiAddressButton("address-row-0", "Remove");
		Assert.assertTrue(cusPage.isTitleMessageDisplayed("address-row-0", "Address 1"));

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
