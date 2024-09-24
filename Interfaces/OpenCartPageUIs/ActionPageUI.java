package OpenCartPageUIs;

public class ActionPageUI {

	
	public static final String UPLOAD_FILE_TYPE = "css=button#button-upload-222";
	public static final String DYNAMIC_HEADER_LINKS_BY_NAME = "xpath=//div[@id='content']/following-sibling::aside//a[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_PARENT = "xpath=//select[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_ITEM = "xpath=//select[@id='%s']/option";
	public static final String ITEM_IMAGE_LINK = "xpath=//div[@id='%s']//a[contains(text(),'%s')]";
	public static final String CHECKBOX_BUTTON = "xpath=//a[contains(text(),'%s')]";
	public static final String DYNAMIC_TEXAREA = "xpath=//textarea[@id='%s']";

	public static final String DYNAMIC_COMPARE_LABEL_BUTTON = "xpath=//h1[contains(text(),'%s')]/parent::div/form//button[2]";

	public static final String MYACCOUNT_DROPDOWN_PARENT = "xpath=//span[contains(text(),'My Account')]/parent::a";
	public static final String MYACCOUNT_DROPDOWN_REGISTER_ITEM = "xpath=//span[contains(text(),'My Account')]/parent::a/following-sibling::ul/li/a";
	public static final String DYNAMIC_CART_LABEL_BUTTON_WITHOUT_CLICKING_LINK = "xpath=//a[contains(text(),'%s')]/parent::h4/parent::div/following-sibling::form//button[@formaction='https://demo.opencart.com/en-gb?route=checkout/cart.add']";
	public static final String SHOPPING_CART_BUTTON ="xpath=//a[@title='Shopping Cart']";
	public static final String DYNAMIC_TEXTBOX_ERRORMASSAGE_BY_ID = "xpath=//div[@id='%s']";
	public static final String DYNAMIC_TEXTBOX = "xpath=//input[@id='%s']";
	public static final String VIEW_ITEM_BUTTON = "xpath=//button[@id='%s']";
	public static final String DYNAMIC_BUTTON = "xpath=//button[@type='%s']";
	
	public static final String DYNAMIC_OPTION_LABEL_BUTTON = "xpath=//button[@formaction='https://demo-opencart.com/index.php?route=account/%s.add&language=en-gb']";
	
	public static final String ALERT_MESSAGE = "xpath=//div[@id='%s']";
	public static final String  DYNAMIC_RADIO_AND_CHECKBOX_BUTTON_BY_ID = "xpath=//input[@id='%s']";
	
	public static final String EMAIL_TEXTBOX = "xpath=//input[@id='input-email']";
	public static final String DYNAMIC_MENU_DROPDOWN_PARENT = "xpath=//div[@id='narbar-menu']//a[text()='%s']";
	public static final String DYNAMIC_MENU_DROPDOWN_ITEM = "xpath=//div[@id='narbar-menu']//a[text()='%s']/following-sibling::div//li";
	public static final String DYNAMIC_MENU_DROPDOWN_ALL_ITEM = "xpath=//div[@id='narbar-menu']//a[text()='Desktops']/following-sibling::div/a";
	
	
	public static final String DYNAMIC_PRICE_ITEM_VALUE ="xpath=//div[@id='%s']//div//tbody/tr/td[@class='text-end'][2]";
	public static final String DYNAMIC_TOTAL_PRICE_ITEM_VALUE ="xpath=//div[@id='%s']//tbody//td[@class='text-end'][2]";

	public static final String WISHLIST_HEADER_BUTTON = "xpath=//a[@id='wishlist-total']";

	public static final String DYNAMIC_IMAGE_LINK ="xpath=//div[@id='%s']//img[contains(@title,'%s')]";
	public static final String DYNAMIC_NAME_PRODUCE_LINK ="xpath=//div[@id='%s']//a[contains(text(),'%s')]";
	public static final String DYNAMIC_MODEL_ITEM_VALUE ="xpath=//div[@id='%s']//td[contains(text(),'%s')]";
	public static final String EMPTY_MESSAGE = "xpath=//div[@id='content']//p[text()='%s']";

	

	
	
}
