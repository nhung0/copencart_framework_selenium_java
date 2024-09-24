package common;

import org.openqa.selenium.WebDriver;

import OpenCartPageUIs.SuccessPageUI;
import pageObject.opencard.admin.CustomerAdminPageObject;
import pageObject.opencard.admin.DashboardAdminPageObject;
import pageObject.opencard.admin.ProductAdminPageObject;
import pageObject.opencard.admin.StartAdminPageObject;
import pageObjects.opencart.AddressPageObject;
import pageObjects.opencart.ChangePasswordPageObject;
import pageObjects.opencart.CheckOutPageObject;
import pageObjects.opencart.ComparePageObject;
import pageObjects.opencart.DesktopstPageObject;
import pageObjects.opencart.EditCustormerPageObject;
import pageObjects.opencart.HomePageObject;
import pageObjects.opencart.LoginPageObject;
import pageObjects.opencart.LogoutPageObject;
import pageObjects.opencart.MyAccountSideBarPageObject;
import pageObjects.opencart.OrderPageObject;
import pageObjects.opencart.RegisterPageObject;
import pageObjects.opencart.SearchPageObject;
import pageObjects.opencart.ShopCartPageObject;
import pageObjects.opencart.SortAndDisplayPageObject;

import pageObjects.opencart.SuccessPageObject;
import pageObjects.opencart.WishListPageObject;


public class pageGeneratorManagerOpenCart extends basePage {
	
	

	public  static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
		
		
	}
	

	public  static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
		
		
	}
	

	public  static MyAccountSideBarPageObject getMyAccountSideBarPage(WebDriver driver) {
		return new MyAccountSideBarPageObject(driver);
		
		
	}
	
	public  static CheckOutPageObject getCheckOutPage(WebDriver driver) {
		return new CheckOutPageObject(driver);
		
		
	}
	
	public  static ProductAdminPageObject getProductAdminPage(WebDriver driver) {
		return new ProductAdminPageObject(driver);
		
		
	}
	
	public  static CustomerAdminPageObject getCustomserAdminPage(WebDriver driver) {
		return new CustomerAdminPageObject(driver);
		
		
	}
	
	
	
	public  static SuccessPageObject getSuccessPage(WebDriver driver) {
		return new SuccessPageObject(driver);
		
		
	}
	
	
	

	public  static OrderPageObject getOrderPage(WebDriver driver) {
		return new OrderPageObject(driver);
		
		
	}
	

	public  static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
		
		
	}
	
	
	public  static StartAdminPageObject getStartAdminPage(WebDriver driver) {
		return new StartAdminPageObject(driver);
		
		
	}
	
	
	public  static ComparePageObject ComparePage(WebDriver driver) {
		return new ComparePageObject(driver);
		
		
	}
	
	public  static DesktopstPageObject getDesktopstPage(WebDriver driver) {
		return new DesktopstPageObject(driver);
		
		
	}
	
	public  static SearchPageObject getSearchPage(WebDriver driver) {
		return new SearchPageObject(driver);
		
		
	}
	
	public  static SortAndDisplayPageObject getSortAndDisplayPage(WebDriver driver) {
		return new SortAndDisplayPageObject(driver);
		
		
	}
	
	public  static WishListPageObject getWishListPage(WebDriver driver) {
		return new WishListPageObject(driver);
		
		
	}
	
	public  static DashboardAdminPageObject getDashboardAdminPage(WebDriver driver) {
		return new DashboardAdminPageObject(driver);
		
		
	}
	
	public  static ShopCartPageObject getShopCartPage(WebDriver driver) {
		return new ShopCartPageObject(driver);
		
		
	}
	
	
	public  static LogoutPageObject getLogoutPage(WebDriver driver) {
		return new LogoutPageObject(driver);
		
		
	}
	public  static EditCustormerPageObject getEditCustormerPage(WebDriver driver) {
		return new EditCustormerPageObject(driver);
		
		
	}
	
	public  static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
		
		
	}
	
	public  static AddressPageObject getAddressPage(WebDriver driver) {
		return new AddressPageObject(driver);
		
		
	}




	
	
	
	
	
	
	
}
