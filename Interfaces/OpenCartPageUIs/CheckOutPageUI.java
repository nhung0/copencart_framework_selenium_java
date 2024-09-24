package OpenCartPageUIs;

public class CheckOutPageUI {
	public static final String SHIP_NATIONALITY_DROPDOWN_PARENT ="xpath=//select[@id='input-shipping-country']";
	public static final String SHIP_NATIONALITY_DROPDOWN_CHILD_ITEM ="xpath=//select[@id='input-shipping-country']//option";
	
	public static final String SHIP_STATE_DROPDOWN_PARENT ="xpath=//select[@id='input-shipping-zone']";
	public static final String SHIP_STATE_DROPDOWN_CHILD_ITEM ="xpath=//select[@id='input-shipping-zone']//option";

	public static final String METHOD_BUTTON ="xpath=//div[@id='%s']//button[@id='%s']";
	public static final String METHOD_RADIO_BUTTON ="xpath=//input[@id='%s']";
	public static final String TOTAL_PRICE_CHECKOUT_VALUE ="xpath=//div[@id='checkout-confirm']//tfoot//tr[4]//td[@class='text-end'][2]";
	public static final String TOTAL_PRICE_CHECKOUT_VALUE_WITHOUT_SHIPPING ="xpath=//div[@id='checkout-confirm']//tfoot//tr[3]//td[@class='text-end'][2]";

}
