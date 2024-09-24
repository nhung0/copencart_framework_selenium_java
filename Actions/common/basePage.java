package common;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import OpenCartPageUIs.ActionPageUI;




public class basePage {
//	WebDriver driver; // biến toàn cục
// tương tác là kiểu void: click, sendkeys, accept, cancel, select,...
// các hàm để lấy dữ liêu ra là string,int, webelement, list webelement...
	// k cần khởi tao đối tượng mà vẫn vào đươc hàm này
	public static basePage getBasePage() {
		return new basePage();
	}
	
	//web browser
	public void clickToElement(WebDriver driver, String locator) {
		driver.findElement(By.xpath(locator)).click();
	}
	
	
	
	
	
	public void sendkeyToElement(WebDriver driver, String element, String value) {
		driver.findElement(By.cssSelector(element)).sendKeys(value);
		
	}
	
	
	
	

	// mở 1 url
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
		// nếu như biến toàn cục và biến cục bộ cùng tên khi lấy biến toàn cục ta sẽ goi this   vd: this.driver.get...

	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();

	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();

	}

	public String getPageSources(WebDriver driver) {
		return driver.getPageSource();

	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();

	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();

	}

	public void refeshCurentPage(WebDriver driver) {
		driver.navigate().refresh();

	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		return (Alert) explicitWait.until(ExpectedConditions.alertIsPresent());

	}
	
	        

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();

	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();

	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);

	}

	public void switchToWindowByTitle(WebDriver driver, String expectedId) {

		Set<String> allIDs =   driver.getWindowHandles(); // set string

		for (String id : allIDs) {

			driver.switchTo().window(id);

			String actualTitle = driver.getTitle();
			if (actualTitle.equals(expectedId)) {
				break;

			}
		}

	}

	public void closeAllWindowWithoutParent(WebDriver driver, String expectedParent) {
		Set<String> allIDs =  driver.getWindowHandles();
		for (String id : allIDs) {
			if (!id.equals(expectedParent)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(expectedParent);
	}
	
	
	public Set<Cookie> getBrowserCookie(WebDriver driver) {
		 return driver.manage().getCookies();
	}
	
	
	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		  for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
	}
	 public void deleteAllCookies(WebDriver driver) {
		driver.manage().deleteAllCookies();
	}
	
	 public static By getByLocator(String locatorValue) {
			By by = null;
			if (locatorValue.startsWith("xpath=") || locatorValue.startsWith("Xpath=") || locatorValue.startsWith("xPATH=") || locatorValue.startsWith("XPATH=") || locatorValue.startsWith("XPath=")) {
				by = By.xpath(locatorValue.substring(6));
			}else if (locatorValue.startsWith("css=")|| locatorValue.startsWith("CSS=") || locatorValue.startsWith("Css=") || locatorValue.startsWith("cSS=")){
				by = By.cssSelector(locatorValue.substring(4));
					
			 }else if (locatorValue.startsWith("id=")|| locatorValue.startsWith("ID=") || locatorValue.startsWith("Id=") || locatorValue.startsWith("iD=")){
				by = By.id(locatorValue.substring(3));
			
			}else if (locatorValue.startsWith("name=")|| locatorValue.startsWith("NAME=") || locatorValue.startsWith("Name=") || locatorValue.startsWith("nAME=")){
				by = By.name(locatorValue.substring(5));
			}else if (locatorValue.startsWith("class=")|| locatorValue.startsWith("CLASS=") || locatorValue.startsWith("Class=") || locatorValue.startsWith("cLASS=")){
				by = By.className(locatorValue.substring(6));
			} else if (locatorValue.startsWith("tagname=")|| locatorValue.startsWith("TAGNAME=") || locatorValue.startsWith("Tagname=") || locatorValue.startsWith("tagName=")){
				by = By.tagName(locatorValue.substring(8));
			}
			
			return by;
		}
	
	
	//web element 
	 // viết một hàm lặp 
	 public By getByXpath(String locator) {
		 return By.xpath(locator);
	 }
	 
	 public String getDynamicLocator(String locator, String... restParams) {
		 return String.format(locator, (Object[]) restParams);
	 }
	 
	 
	 
	 public WebElement getElement(WebDriver driver, String locator) {
		 return driver.findElement(getByLocator(locator));
		 
		
	}
	 public List<WebElement> getElements(WebDriver driver, String locator) {
		 return driver.findElements(getByLocator(locator));
		 
		
	}
	 public List<WebElement> getElements(WebDriver driver, String locator, String... restParams) {
		 return driver.findElements(getByLocator(getDynamicLocator(locator, restParams)));
		 
		
	}
	 
	 public void clickToElment(WebDriver driver, String locator){
		 getElement(driver, locator).click();
		
	}
	 
	 public void clickToElment(WebDriver driver, WebElement element){
		element.click();
		
	}
	 
	 public void clickToElment(WebDriver driver, String locator, String... restParams) {
		 getElement(driver, getDynamicLocator(locator, restParams)).click();
		
	}
	 
	 public void sendKeysToElment(WebDriver driver, String locator, String value) {
		 getElement(driver,locator).clear();
		 getElement(driver,locator).sendKeys(value);
		
	}
	 
	 public void sendKeysToElment(WebDriver driver, String locator, String value, String... restParams) {
		 getElement(driver, getDynamicLocator(locator, restParams)).clear();
		 getElement(driver, getDynamicLocator(locator, restParams)).sendKeys(value);
		
	}
	 
	 public void clearToElment(WebDriver driver, String locator) {
		 getElement(driver,locator).clear();
		
		
	}
	 
	 public void clearToElment(WebDriver driver, String locator,String... restParams ) {
		 getElement(driver,getDynamicLocator(locator, restParams)).clear();
		
		
	}
	 
	 public void waitForAndCheckToCheckboxInShadowDOM(WebDriver driver, String locator) {
		    WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		    // Đợi cho checkbox trong Shadow DOM hiển thị
		    WebElement checkbox = explicitWait.until(ExpectedConditions.visibilityOf((WebElement) jsExecutor.executeScript(
		        "return document.querySelector(arguments[0])", getElement(driver, locator))));
		    checkbox.click();
		}
	 
	 
	 
	 public void waitForAndCheckToCheckboxInShadowDOM2(WebDriver driver, String host1,  String locatorIframe, String locatorCheckbox) {
		 WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		
		        WebElement shadowHost = getElement(driver, host1);
		        
		        
		        // Get the shadow root
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        Object shadowRootObject = js.executeScript("return arguments[0].shadowRoot", shadowHost);
		        
		       
		        // Convert the shadowRootObject to WebElement for further manipulation
		        WebElement shadowRoot = (WebElement) shadowRootObject;
		        
		
		        
		        // Wait for the element within the shadow root to be present
		        WebElement iframe  = shadowRoot.findElement(getByLocator(locatorIframe));
		        
		        driver.switchTo().frame(iframe);
		        
		        getElement(driver, locatorIframe).click();

		        
		        
		    
	        
			
	    }
	 
	 
	
	 public void AddOptionToSelect(WebDriver driver, String locatorID, String tagName, String value, String text) {
		   
		        String script = "var selectElement = document.getElementById('"+locatorID+"');" +
		                        "var newOption = document.createElement('"+tagName+"');" +
		                        "newOption.value = '"+value+"';" +
		                        "newOption.text = '"+text+"';" +
		                        "selectElement.appendChild(newOption);";


		        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		        jsExecutor.executeScript(script);
	 
		    }
		    
		    
		  
			
	 
	 
	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String iTemValue) {
		 new Select(getElement(driver, locator)).selectByVisibleText(iTemValue);
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String iTemValue,String... restParams ) {
		 new Select(getElement(driver, getDynamicLocator(locator, restParams))).selectByVisibleText(iTemValue);
	}
	
	public String getFirstSelectedTextInDefaultDropdown(WebDriver driver, String locator, String iTemValue) {
		 return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
	}
	
	public boolean isDefaultDropdownMultiple(WebDriver driver, String locator) {
		return new Select(getElement(driver, locator)).isMultiple();
	}
	
	 
	public void selectIteminDropdown(WebDriver driver, String parentxPath, String childLocator, String expectedItemText) {
			WebElement element = getElement(driver, parentxPath);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			
			
			List<WebElement> speedDropdownItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));
			
	
			for (WebElement tempItem : speedDropdownItems) {
				
				if (tempItem.getText().trim().equals(expectedItemText)) {
					tempItem.click();
					break;
				}
			}
		}
	
	

	
	public void selectIteminDropdownByJS(WebDriver driver, String parentxPath, String childLocator, String expectedItemText) {
		
		WebElement element = getElement(driver, parentxPath);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		List<WebElement> speedDropdownItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));
	
		for (WebElement tempItem : speedDropdownItems) {
			
			if (tempItem.getText().trim().equals(expectedItemText)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", tempItem);
			
				break;
			}
		}
	}
	
public void selectIteminDropdownByJS(WebDriver driver, String parentxPath, String childLocator, String expectedItemText, String... restParams) {
		
		WebElement element = getElement(driver, getDynamicLocator(parentxPath, restParams));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		
		List<WebElement> speedDropdownItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(getDynamicLocator(childLocator, restParams))));
		

		for (WebElement tempItem : speedDropdownItems) {
			
			
			if (tempItem.getText().trim().equals(expectedItemText)) {
				tempItem.click();
				
				break;
			}
		}
	}


public void selectIteminDropdownByJS2(WebDriver driver, String parentxPath, String childLocator, String expectedItemText, String... restParams) {
	
	WebElement element = getElement(driver, getDynamicLocator(parentxPath, restParams));
	
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	
	
	List<WebElement> speedDropdownItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(getDynamicLocator(childLocator, restParams))));
	
	
	for (WebElement tempItem : speedDropdownItems) {
	
		
		if (tempItem.getText().contains(expectedItemText)) {
			
			tempItem.click();
			
		
			break;
		}
	}
}


	
	
	public void selectIteminDropdown(WebDriver driver, String parentxPath, String childLocator, String expectedItemText, String... restParams) {
		
		getElement(driver, getDynamicLocator(parentxPath, restParams)).click();
		
		
		List<WebElement> speedDropdownItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(getDynamicLocator(childLocator, restParams))));
		

		for (WebElement tempItem : speedDropdownItems) {
			
			
			if (tempItem.getText().trim().equals(expectedItemText)) {
				tempItem.click();
			
				break;
			}
		}
	}
	public String getElmentText(WebDriver driver, String locator) {
		 return getElement(driver, locator).getText();
		 
		
	}
	
	public List<String> getElmentTexts(WebDriver driver, String locator) {
		List<WebElement> textItems = getElements(driver, locator);
		return textItems.stream()
                .map(WebElement::getText) 
                .collect(Collectors.toList());
		 
		
	}
	
	public List<Double> getElmentTextPrice(WebDriver driver, String locator) {
		// Lấy danh sách các phần tử giá từ trang 
	    List<WebElement> priceElements = getElements(driver, locator);

	    // Chuyển đổi các giá từ String sang Double và thêm vào danh sách
	    return priceElements.stream()
	            .map(element -> element.getText().replace("$", "").replace(",", "")) // Remove $ and commas
	            .map(Double::parseDouble) // Convert to Double
	            .collect(Collectors.toList());
		
	}
	
	
	
	
	public String getElmentText(WebDriver driver, String locator, String... restParams) {
		 return getElement(driver, getDynamicLocator(locator, restParams)).getText();
		 
		
	}
		
	public String getElmentAttribute(WebDriver driver, String locator, String attributeName) {
		 return getElement(driver, locator).getAttribute(attributeName);
		 
		
	}
	
	public String getElmentAttribute(WebDriver driver, String locator, String attributeName, String restParams) {
		 return getElement(driver, getDynamicLocator(locator, restParams)).getAttribute(attributeName);
		 
		
	}
	
	public String getElmentCssValue(WebDriver driver, String locator, String cssPropertyName) {
		 return getElement(driver, locator).getCssValue(cssPropertyName);
		 
		
	}
	
	public String convertRgbaToHexaColor(WebDriver driver, String locator, String cssPropertyName) {
		
		return Color.fromString(getElmentCssValue(driver, locator, "background-color")).asHex();
		
	}
	
	public int getListElmentSize(WebDriver driver, String locator, String... restParams) {
		  return getElements(driver, getDynamicLocator(locator, restParams)).size();
		 
		
	}
	
	public int getListElmentSize(WebDriver driver, String locator) {
		  return getElements(driver, locator).size();
		 
		
	}
		
	/** apply for checkbox and radio button
	 * @param driver
	 * @param locator
	 */
	
	// default checkbox
	public void checkToElement(WebDriver driver, String locator) {
		 if (!getElement(driver, locator).isSelected()) {
			 getElement(driver, locator).click();
			
		}
		
	}
	
	// default checkbox
	
	
	
	public void checkToElement(WebDriver driver, String locator,String... restParams ) {
		 if (!getElement(driver, getDynamicLocator(locator, restParams)).isSelected()) {
			 getElement(driver, getDynamicLocator(locator, restParams)).click();
			
		}
		
	}
	
	/** only apply for checkbox 
	 * @param driver
	 * @param locator
	 */
	public void uncheckToElement(WebDriver driver, String locator) {
		 if (getElement(driver, locator).isSelected()) {
			 getElement(driver, locator).click();
			
		}
	 
	}
	// case 1 hiển thị và có trong html
	// case 2 k hiển thị và có trong html
	public boolean isElementDisplayed(WebDriver driver, String locator) {
	
			return getElement(driver, locator).isDisplayed();
	}
	
	
	public boolean isElementDisplayed(WebDriver driver, String locator, String... restParams ) {
		return getElement(driver, getDynamicLocator(locator, restParams)).isDisplayed();
	}
	
	public void setImplicitWayLongTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		
		
	}
	
	
	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		setImplicitWayLongTimeout(driver, shortTimeout);
		
		List<WebElement> elements = getElements(driver, locator);
		setImplicitWayLongTimeout(driver, longTimeout);
		if (elements.size() == 0) {
			//element có trong UI và có trong DOM-> false
			return true;
		} else if(elements.size() > 1 && !elements.get(0).isDisplayed()) {
			//element có trong UI và k có trong DOM-> true
			return true;
		} else {
			return false;
		}
		
	
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locator,String... restParams ) {
		setImplicitWayLongTimeout(driver, shortTimeout);
		
		List<WebElement> elements = getElements(driver, getDynamicLocator(locator, restParams));
		setImplicitWayLongTimeout(driver, longTimeout);
		if (elements.size() == 0) {
			//element có trong UI và có trong DOM-> false
			return true;
		} else if(elements.size() > 1 && !elements.get(0).isDisplayed()) {
			//element có trong UI và k có trong DOM-> true
			return true;
		} else {
			return false;
		}
		
	
	}
	
	
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator,String... restParams) {
		return getElement(driver, getDynamicLocator(locator, restParams)).isSelected();
	}
	
	
	
	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}
	
	public void switchToIframe(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByLocator(locator)));
		
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		 driver.switchTo().defaultContent();
	}
	
	public void hoverToElement(WebDriver driver, String locator) {
		new Actions(driver).moveToElement(getElement(driver, locator)).perform();
	}
	
	public void doubleClickToElement(WebDriver driver, String locator) {
	 new Actions(driver).doubleClick(getElement(driver, locator)).perform();
	}
	
	public void rightClickToElement(WebDriver driver, String locator) {
		 new Actions(driver).contextClick(getElement(driver, locator)).perform();
		}
	
	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		 new Actions(driver).dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)) ;
		}
	
	
	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		 new Actions(driver).sendKeys(getElement(driver, locator),key ).perform();
		}
	
	public Object executeForBrowser(WebDriver driver,String javaScript) {
		return  ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	public boolean isExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
		sleepInSecond(3);
	}

	public void hightlightElement(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(2);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
	
	}
	
	

	public void clickToElementByJS(WebDriver driver, String locator, String... restParams) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, getDynamicLocator(locator, restParams)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, getDynamicLocator(locator, restParams)));
		sleepInSecond(3);
	}

	public void scrollToElementOnTop(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	
	public void scrollToElementOnTop(WebDriver driver, String locator, String... restParams) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, getDynamicLocator(locator, restParams)));
	}
	
	
	public void scrollToElementOnDown(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
	}
	
	
	public void scrollToElementOnDown(WebDriver driver, String locator,String... restParams) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, getDynamicLocator(locator, restParams)));
	}
	

	public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute(', " + attributeRemove + "');", getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value, String...restParams) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, getDynamicLocator(locator, restParams)));
	}
	
	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public String getAttributeInDOM(WebDriver driver, String locator, String attributeName,String...restParams ) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, getDynamicLocator(locator, restParams)));
	}
	
	
	public String getAttributeInDOM(WebDriver driver, String locator, String attributeName) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
	}
	
	
	
	public String getElementValidationMessage(WebDriver driver, String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		return (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(driver, locator));
		
	}
	
	
	
	
	
	public void  checkToShadowElement(WebDriver driver, String baseElementId, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(baseElementId)));
	    WebElement baseElement = getElement(driver, baseElementId);	
	    
	    WebElement shadowRoot = (WebElement) ((JavascriptExecutor) driver)
	        .executeScript("return arguments[0].shadowRoot", baseElement);
	    
	   ((basePage) shadowRoot).getElement(driver, locator);
	    if (!getElement(driver, locator).isSelected()) {
			 getElement(driver, locator).click();
			
		}
	    
	   
	}
	
	
	
	
	
	
	public String getEmailAddress () {
		Random rand = new Random();
		return "nhung" + rand.nextInt(99999) + "@gmail.net";
	}
	
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
		
		
	}
	
	
	
	public void waitForElementVisible1(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
		
		
	}
	
	
	public void waitForElementVisible1(WebDriver driver, String locator, String... restParams) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.presenceOfElementLocated(getByLocator( getDynamicLocator(locator, restParams))));
		
		
	}
	
	
	public void waitForElementVisible(WebDriver driver, String locator, String... restParams) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator( getDynamicLocator(locator, restParams))));
		
		
	}
	public void waitForElementVisibleLong(WebDriver driver, String locator, String... restParams) {
		new WebDriverWait(driver, Duration.ofSeconds(longgTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator( getDynamicLocator(locator, restParams))));
		
		
	}
	
	public void waitForListElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfAllElements(getElements(driver, locator)));
		
		
	}
	
	public boolean waitForElementInVisible(WebDriver driver, String locator, String... restParams) {
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicLocator(locator, restParams))));
		
		
	}
	
	public boolean waitForElementInVisible(WebDriver driver, String locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
		
		
	}
	
	
	public boolean  waitForListElementInVisible(WebDriver driver, String locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfAllElements(getElements(driver, locator)));
		
		
	}
	
	public void waitForElementClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getElement(driver, locator)));

		
	}
	
	public void waitForLinkElementClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(shortTimeout)).until(ExpectedConditions.elementToBeClickable(getElement(driver, locator)));

		
	}
	
	public void waitForElementClickable(WebDriver driver, 	WebElement  element) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(element));

		
	}
	
	public void waitForElementClickable(WebDriver driver, String locator, String... restParams) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getElement(driver,getDynamicLocator(locator, restParams))));
		
		
	}
	
	
	
	
	
	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		String filePath = globalConstants.UPLOAD_PATH;
		String fullFileName = "";
		
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file +"\n";
			System.out.println(fullFileName);
		}
		
		fullFileName = fullFileName.trim();
		System.out.println(fullFileName);
		
		getElement(driver, ActionPageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
		System.out.println(7);
	}
	
	public void uploadMultipleFiless(WebDriver driver, String... fileNames) {
		String filePath = globalConstants.UPLOAD_PATH;
		String fullFileName = "";
		
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file +"\n";
			System.out.println(fullFileName);
			
			
		}
		
		fullFileName = fullFileName.trim();
		
		getElement(driver, ActionPageUI.UPLOAD_FILE_TYPE).click();
		sleepInSecond(3);
		// Khởi tạo Robot class
		  Robot rb = null;
		  try {
		    rb = new Robot();
		  } catch (AWTException e) {
		    e.printStackTrace();
		  }

		  StringSelection str = new StringSelection(fullFileName);
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		  // Nhấn Control+V để dán
		  rb.keyPress(KeyEvent.VK_CONTROL);
		  rb.keyPress(KeyEvent.VK_V);
		  sleepInSecond(3);

		  // Xác nhận Control V trên
		  rb.keyRelease(KeyEvent.VK_CONTROL);
		  rb.keyRelease(KeyEvent.VK_V);
		  sleepInSecond(3);
		  
		  // Nhấn Enter
		  rb.keyPress(KeyEvent.VK_ENTER);
		  rb.keyRelease(KeyEvent.VK_ENTER);
		  sleepInSecond(3);


		
		
	}

	public void uploadSingleFile(WebDriver driver, String fileName) {
//		String filePath = globalConstants.UPLOAD_PATH;
		String fullFileName = globalConstants.RELATIVE_PROJECT_PATH + File.separator +"uploadFiles" + File.separator + fileName;
		System.out.println(fullFileName);
		
		getElement(driver, ActionPageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
		System.out.println(4);
	}
	
	public String getDirectorySlash(String folderName) {
		String separator = System.getProperty("file.separator");
		return separator + folderName + separator;
	}
	
	public String String (String folderName) {
		String separator = System.getProperty("file.separator");
		return separator + folderName + separator;
	}
	
	
	
	
	protected String getCurrentDay() {
		DateTime nowUTC = new DateTime(DateTimeZone.UTC);
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return day + "";
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthValue = "0" + month;
			return monthValue;
		}
		return month + "";
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		return now.getYear() + "";
	}

	protected String getToday() {
		return getCurrentYear() + "-" + getCurrentMonth() + "-" + getCurrentDay();
	}
	
	
	
	private long longTimeout = globalConstants.LONG_TIMEOUT;
	private long shortTimeout = globalConstants.SHORT_TIMEOUT;
	private long longgTimeout = globalConstants.LONGG_TIMEOUT;
	
	
	
	

	
	

}