package OpenCartPageUIs;

public class ShopCartPageUI {
	
	public static final String IFRAME = "xpath=//iframe[@title='Widget containing a Cloudflare security challenge']";
	public static final String START_CHECKBOX = "xpath=//input[@type='checkbox']";
	public static final String HOST_CHECKBOX = "css=div[style='border: 0px; margin: 0px; padding: 0px;']";
	public static final String TOTAL_PRICE_ITEM_VALUE ="xpath=//tfoot[@id='checkout-total']//tr[3]//td[@class='text-end'][2]";
	public static final String QUANTITY_TEXTBOX = "xpath=//div[@id='shopping-cart']//a[contains(text(),'%s')]/parent::td/following-sibling::td[2]//input[@name='quantity']";
	public static final String UPDATE_BUTTON = "xpath=//div[@id='shopping-cart']//a[contains(text(),'%s')]/parent::td/following-sibling::td[2]//button[@formaction='https://demo-opencart.com/index.php?route=checkout/cart.edit&language=en-gb']";
	public static final String CHECKOUT_BUTTON = "xpath=//a[text()='Checkout']";

	public static final String REMOVE_BUTTON = "xpath=//div[@id='shopping-cart']//a[contains(text(),'%s')]/parent::td/following-sibling::td[2]//button[@formaction='https://demo-opencart.com/index.php?route=checkout/cart.remove&language=en-gb']";

	


}
