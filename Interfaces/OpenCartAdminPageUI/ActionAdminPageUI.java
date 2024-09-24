package OpenCartAdminPageUI;

public class ActionAdminPageUI {

	
	
	
	public static final String DYNAMIC_TEXAREA = "xpath=//textarea[@id='%s']";
	public static final String DYNAMIC_TITLE_LINK = "xpath=//form[@id='%s']//a[text()='%s']";


	public static final String DYNAMIC_TEXTBOX = "xpath=//input[@id='%s']";
	public static final String VIEW_ITEM_BUTTON = "xpath=//button[@id='%s']";
	public static final String DYNAMIC_BUTTON = "xpath=//button[@type='%s']";


	
	public static final String ALERT_MESSAGE = "xpath=//div[@id='%s']";
	public static final String DYNAMIC_ALERT_MESSAGE = "xpath=//div[@id='%s']/div[contains(text(),'%s')]";
	
	public static final String DYNAMIC_NAME_PRODUCE_LINK ="xpath=//div[@id='%s']//a[contains(text(),'%s')]";
	public static final String EMPTY_MESSAGE = "xpath=//div[@id='%s']//td[text()='%s']";
	
	public static final String DYNAMIC_ADMIN_BUTTON = "xpath=//div[@id='%s']//div[contains(@class,'btn-group')]/a";
	public static final String SAVE_BUTTON = "xpath=//div[@id='%s']//div[@class='float-end']/button";
	public static final String ADD_NEW_AND_BACK_BUTTON = "xpath=//div[@id='%s']//div[@class='float-end']/a";
	public static final String CUS_BACK_BUTTON = "xpath=//div[@id='%s']//div[@class='float-end']/a[2]";



	public static final String DYNAMIC_DROPDOWN_PARENT = "xpath=//select[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_ITEM = "xpath=//select[@id='%s']/option";
	public static final String DYNAMIC_ADDRESS_BUTTON = "xpath=//fieldset[@id='%s']//button";
	public static final String DYNAMIC_TITLE_ADDRESS_BUTTON = "xpath=//fieldset[@id='%s']//legend[contains(text(),'%s')]";


	public static final String DYNAMIC_BAR_MENU_DROPDOWN_PARENT = "xpath=//li[@id='%s']/a[contains(text(),'%s')]";
	public static final String DYNAMIC_BAR_MENU_DROPDOWN_ITEM = "xpath=//li[@id='%s']/a[contains(text(),'%s')]/following-sibling::ul/li/a";


	public static final String DYNAMIC_IMAGE_LINK ="xpath=//div[@id='%s']//img[contains(@alt,'%s')]";
	public static final String DYNAMIC_MODEL_ITEM_VALUE ="xpath=//div[@id='%s']//td[contains(text(),'%s')]";
	public static final String QUANTITY_VALUE ="xpath=//div[@id='%s']//span[contains(text(),'%s')]";

	public static final String DYNAMIC_PRODUCE_NAME ="xpath=//div[@id='%s']//td[contains(text(),'%s')]";
	public static final String  DYNAMIC_RADIO_AND_CHECKBOX_BUTTON_BY_ID = "xpath=//input[@id='%s']";

	
}
