package OpenCartPageUIs;

public class DesktopsUI {
	
	public static final String IFRAME = "xpath=//iframe[@title='Widget containing a Cloudflare security challenge']";
	public static final String MAC_IMAGE = "xpath=//div[@id='product-list']//img";
	public static final String WISHLIST_LABEL_BUTTON = "xpath=//h1[text()='iMac']/parent::div//button[@formaction='https://demo-opencart.com/index.php?route=account/wishlist.add&language=en-gb']";
	public static final String MAC_COMPARE_LABEL_BUTTON = "xpath=//h1[text()='iMac']/parent::div//button[@formaction='https://demo.opencart.com/en-gb?route=product/compare.add";
	public static final String TEXTBOX_AREA = "xpath=//textarea[@id='%s']";
	public static final String CINEMA_IMAGE = "xpath=//a[contains(text(),'Apple Cinema 30')]/parent::h4/parent::div/parent::div/preceding-sibling::div//img";
	public static final String COMPARE_LINK = "xpath=//div[@id='alert']//a[contains(text(), 'product comparison')]";
	public static final String DATE_AND_TIME_TEXTBOX = "xpath=//input[@id='input-option-220']";
	public static final String DATE_AND_TIME_CHILD = "xpath=//div[contains(@class,'daterangepicker ltr single opensright show-calenda')]/following-sibling::div//div[@class='drp-calendar left single']//tbody//tr//td";

	public static final String DATE_CHILD = "xpath=//div[contains(@class,'daterangepicker ltr auto-apply single opensright show-calendar')]//div[@class='drp-calendar left single']//tbody//tr//td";
	public static final String DATE_TEXTBOX = "xpath=//input[@id='input-option-219']";
	
	public static final String TIME_TEXBOX = "xpath=//input[@id='input-option-221']";
	public static final String HOUR_ITEM_PARENT = "xpath=//div[contains(@class,'daterangepicker ltr single opensright show-calendar')]//div[@class='drp-calendar left single']//div[@class='calendar-time']/select[@class='hourselect']";
	public static final String HOUR_ITEM_CHILD = "xpath=//div[contains(@class,'daterangepicker ltr single opensright show-calendar')]//div[@class='drp-calendar left single']//div[@class='calendar-time']/select[@class='hourselect']/option";
	public static final String SECOND_ITEM_PARENT = "xpath=//div[contains(@class,'daterangepicker ltr single opensright show-calendar')]//div[@class='drp-calendar left single']//div[@class='calendar-time']/select[@class='minuteselect']";
	
	public static final String SECOND_ITEM_CHILD = "xpath=//div[contains(@class,'daterangepicker ltr single opensright show-calendar')]//div[@class='drp-calendar left single']//div[@class='calendar-time']/select[@class='minuteselect']/option";
	public static final String APPLY_BUTTON = "xpath=//div[contains(@class,'daterangepicker ltr single opensright show-calendar')]//div[@class='drp-buttons']//button[text()='Apply']";
	
	
	public static final String DATETIME_HOUR_ITEM_PARENT = "xpath=//div[contains(@class,'daterangepicker ltr single opensright show-calendar')]/following-sibling::div//div[@class='drp-calendar left single']//div[@class='calendar-time']/select[@class='hourselect']";
	public static final String DATETIME_HOUR_ITEM_CHILD = "xpath=//div[contains(@class,'daterangepicker ltr single opensright show-calendar')]/following-sibling::div//div[@class='drp-calendar left single']//div[@class='calendar-time']/select[@class='hourselect']/option";
	public static final String DATETIME_SECOND_ITEM_PARENT = "xpath=//div[contains(@class,'daterangepicker ltr single opensright show-calendar')]/following-sibling::div//div[@class='drp-calendar left single']//div[@class='calendar-time']/select[@class='minuteselect']";
	
	public static final String DATETIME_SECOND_ITEM_CHILD = "xpath=//div[contains(@class,'daterangepicker ltr single opensright show-calendar')]/following-sibling::div//div[@class='drp-calendar left single']//div[@class='calendar-time']/select[@class='minuteselect']/option";
	public static final String DATETIME_APPLY_BUTTON = "xpath=//div[contains(@class,'daterangepicker ltr single opensright show-calendar')]/following-sibling::div//div[@class='drp-buttons']//button[text()='Apply']";
	
	public static final String CART_VIEW_BUTTON = "xpath=//div[@id='header-cart']//a[@class='check_out1']";
	public static final String REQUIRY_BUTTON = "xpath=//button[text()='Enquire about product']";
	public static final String REQUIRY_MESSAGE = "xpath=//div[@id='thankyouModal']//p[text()='Thanks for enquiry']";
	public static final String CLOSE_BUTTON = "xpath=//b/div[@class='modal-footer']/button";



}
