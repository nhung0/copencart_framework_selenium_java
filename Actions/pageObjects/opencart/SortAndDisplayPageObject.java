package pageObjects.opencart;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import OpenCartPageUIs.SortAndDisplayPageUI;

public class SortAndDisplayPageObject extends ActionPageObject {
	WebDriver driver;

	public SortAndDisplayPageObject(WebDriver driver) {

		super(driver);
		this.driver = driver;
	}

	public boolean isProduceNameAToZ() {

		waitForElementVisible(driver, SortAndDisplayPageUI.TEXT_PRODUCE);
		List<String> productNames = getElmentTexts(driver, SortAndDisplayPageUI.TEXT_PRODUCE);

		List<String> sortedProductNames = productNames.stream().sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList());

		System.out.println("Original List: " + productNames);
		System.out.println("Sorted List: " + sortedProductNames);

		return productNames.equals(sortedProductNames);

	}
	
	public boolean isProduceNameZToA() {

		waitForElementVisible(driver, SortAndDisplayPageUI.TEXT_PRODUCE);
		List<String> productNames = getElmentTexts(driver, SortAndDisplayPageUI.TEXT_PRODUCE);

		List<String> sortedProductNames = productNames.stream().sorted(String.CASE_INSENSITIVE_ORDER.reversed()).collect(Collectors.toList());

		System.out.println("Original List: " + productNames);
		System.out.println("Sorted List: " + sortedProductNames);

		return productNames.equals(sortedProductNames);

	}

	public boolean isProducePriceLowToHigh() {
		waitForElementVisible(driver, SortAndDisplayPageUI.PRICES_PRODUCE);
		List<Double> productPrices = getElmentTextPrice(driver, SortAndDisplayPageUI.PRICES_PRODUCE);

		List<Double> sortedProductPrices = productPrices.stream().sorted().collect(Collectors.toList());

		System.out.println("Original List: " + productPrices);
		System.out.println("Sorted List: " + sortedProductPrices);

		return productPrices.equals(sortedProductPrices);
	}

	public boolean isProducePriceHighToLow() {
		waitForElementVisible(driver, SortAndDisplayPageUI.PRICES_PRODUCE);
		List<Double> productPrices = getElmentTextPrice(driver, SortAndDisplayPageUI.PRICES_PRODUCE);

		List<Double> sortedProductPrices = productPrices.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

		System.out.println("Original List: " + productPrices);
		System.out.println("Sorted List: " + sortedProductPrices);

		return productPrices.equals(sortedProductPrices);
	}

	public boolean isTensProduceDisplayed() {
		 // Lấy danh sách các sản phẩm đang hiển thị từ trang (thay thế "productLocator" bằng locator thực tế của bạn)
	    List<WebElement> displayedProducts = getElements(driver, SortAndDisplayPageUI.PRODUCE_ON_PAGE);

	    // In ra số lượng sản phẩm hiển thị để kiểm tra
	    System.out.println("Number of products displayed: " + displayedProducts.size());

	    // Kiểm tra xem danh sách sản phẩm có đúng 10 mục hay không
	    return displayedProducts.size() == 10;
	}

	public boolean isPreciousIconDisplayed() {
		waitForElementVisible(driver, SortAndDisplayPageUI.PRECIOUS_ICON);
		return isElementDisplayed(driver, SortAndDisplayPageUI.PRECIOUS_ICON);
	}

	public boolean isNextIconDisplayed() {
		waitForElementVisible(driver, SortAndDisplayPageUI.NEXT_ICON);
		return isElementDisplayed(driver, SortAndDisplayPageUI.NEXT_ICON);
	}

	public void clickToNextIcon() {
		waitForElementClickable(driver, SortAndDisplayPageUI.NEXT_ICON);
		clickToElementByJS(driver, SortAndDisplayPageUI.NEXT_ICON);
	}

	public boolean isTwelveProduceDisplayed() {
		// Lấy danh sách các sản phẩm đang hiển thị từ trang (thay thế "productLocator" bằng locator thực tế của bạn)
	    List<WebElement> displayedProducts = getElements(driver, SortAndDisplayPageUI.PRODUCE_ON_PAGE);

	    // In ra số lượng sản phẩm hiển thị để kiểm tra
	    System.out.println("Number of products displayed: " + displayedProducts.size());

	    // Kiểm tra xem danh sách sản phẩm có đúng 10 mục hay không
	    return displayedProducts.size() == 13;
	}

}
