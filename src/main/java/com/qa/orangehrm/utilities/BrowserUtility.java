package com.qa.orangehrm.utilities;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import com.qa.orangehrm.Validation.ValidationHelper;
import com.qa.orangehrmexceptions.ElementExceptions;
import com.qa.orangehrmexceptions.FrameworkExceptions;

import io.qameta.allure.Step;

public class BrowserUtility extends BaseUtility{
	/**
	 * The BrowserUtility is a constructor which invokes only if object is created
	 */
	public BrowserUtility(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * This method is used to enter the url using get()
	 * and also it validates for url is null or not and checks for protocol
	 * @param testUrl
	 */
	public void enterUrl(String testUrl) {
		if(testUrl==null) {
			throw new FrameworkExceptions("===[BrowserUtility] - The testurl cannot be null==");
		}
		if(!testUrl.startsWith("https")||(testUrl.indexOf("https")!=0)) {
			throw new FrameworkExceptions("===[BrowserUtility] - The testurl protocol http/https is missing==");
		}
		driver.get(testUrl);
	}
	
	
	/**
	 * It returns title of application
	 * @return
	 */
	@Step("fetchApplicationTitle")
	public String fetchApplicationTitle() {
		return driver.getTitle();
	}
	
	/**
	 * It returns the url of current page
	 * @return
	 */
	@Step("fetchCurrentPageUrl")
	public String fetchCurrentPageUrl() {
		return driver.getCurrentUrl();
	}
	
	/**
	 * It returns the source code of current page
	 * @return
	 */
	public String fetchPageSource() {
		return driver.getPageSource();
	}
	
	
	/**
	 * It closes only the tab
	 * @return
	 */
	public void closeCurrentTab() {
		driver.close();
	}
	
	/**
	 * It closes entire browser including session id and background process
	 * @return
	 */
	public void terminateBrowser() {
		driver.quit();
	}
	
	/**
	 * It is used to make the screen full
	 * @return
	 */
	public void maximizeScreen() {
		driver.manage().window().fullscreen();
	}
	
	/**
	 * It is used to minimize the browser
	 * @return
	 */
	public void minimizeBrowser() {
		driver.manage().window().minimize();
	}
	
	/**
	 * It is used to maximize the browser
	 * @return
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	
	
	/**
	 * It is used to delete browser cookies
	 * @return
	 */
	public void deleteBrowserCookies() {
		driver.manage().deleteAllCookies();
	}
	
	/**
	 * It is used to specify implicit wait for entire application
	 * @return
	 */
	public void globalWait(int minTime) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(minTime));
	}
	
	
	/**
	 * It is used to navigate to another page
	 * @return
	 */
	public void navigateToPage(String testUrl) {
		if(testUrl==null) {
			throw new FrameworkExceptions("===[BrowserUtility] - The testurl cannot be null==");
		}
		if(!testUrl.startsWith("https")|(testUrl.indexOf("https")!=0)) {
			throw new FrameworkExceptions("===[BrowserUtility] - The testurl protocol http/https is missing==");
		}
		driver.navigate().to(testUrl);
	}
	
	/**
	 * It is used to navigate to previous page
	 * @return
	 */
	public void navigatePrevoiusPage() {
		driver.navigate().back();
	}
	
	/**
	 * It is used to navigate to forward page
	 * @return
	 */
	public void navigateForwardPage() {
		driver.navigate().forward();
	}
	
	/**
	 * It is used to navigate to refresh the page
	 * @return
	 */
	public void refresThePage() {
		driver.navigate().refresh();
	}
	
	/**
	 * It is used to fetch the parent tab address
	 * @return
	 */
	public String fetchParentTabAddress() {
		return driver.getWindowHandle();
	}
	
	/**
	 * It is used to fetch the all tab address
	 * @return
	 */
	public Set<String> fetchAllTabAddress() {
		return driver.getWindowHandles();
	}
	
	/**
	 * It is used to switch to alert
	 * @return
	 */
	public Alert switchToAlert() {
		return driver.switchTo().alert();
	}
	
	
	/**
	 * It is used to switch to window
	 * @return
	 */
	public void switchToWindow(String windowAddress) {
		if(windowAddress==null) {
			throw new FrameworkExceptions("===[BrowserUtility] - The windowAddress cannot be null==");
		}
		driver.switchTo().window(windowAddress);
	}
	
	/**
	 * It is used to locate the element
	 * @param locator
	 * @return
	 */
	@Step("locateElement by using locator :{0}")
	public WebElement locateElement(By locator) {
		ValidationHelper.validateLocator(locator, "locateElement");
		try {
			return driver.findElement(locator);
			} catch (NoSuchElementException e) {
			throw new ElementExceptions("===[BrowserUtility] - The specified "+locator+" is not matching with any element in webpage===");
		}
	
	}
	
	
	
	
	
	/**
	 * This method locate and return all the matching elements in the webpage 
	 * @param locator
	 * @return
	 */
	public List<WebElement> locateElements(By locator) {
		ValidationHelper.validateLocator(locator, "locateElements");
		try {
			return driver.findElements(locator);
			} catch (NoSuchElementException e) {
			throw new ElementExceptions("===[BrowserUtility] - The specified "+locator+" is not matching with any elements in webpage===");
		}
	}
	
	
	/**
	 * This will fetch and returns position of browser
	 * @return
	 */
	public Point fetchBrowserPosition() {
		return driver.manage().window().getPosition();
	}
	public int fetchBrowserXaxis() {
		return driver.manage().window().getPosition().getX();
	}
	public int fetchBrowserYaxis() {
		return driver.manage().window().getPosition().getY();
	}
	public Dimension fetchBrowserDiemension() {
		return driver.manage().window().getSize();
	}
	public int fetchBrowserWidth() {
		return driver.manage().window().getSize().getWidth();
	}
	public int fetchBrowserHeight() {
		return driver.manage().window().getSize().getHeight();
	}
	public void changeBrowserPosition(int x,int y) {
		Point p = new Point(x, y);
		driver.manage().window().setPosition(p);
	}
	public void changeBrowserDimension(int width,int height) {
		Dimension d = new Dimension(width, height);
		driver.manage().window().setSize(d);
	}
	
	
	//frame
	public WebDriver switchToFrame(int index) {
		return driver.switchTo().frame(index);
	}
	public WebDriver switchToFrame(String nameOrId) {
		return driver.switchTo().frame(nameOrId);	
	}
	public WebDriver switchToFrame(WebElement addressOfFrame) {
		return driver.switchTo().frame(addressOfFrame);
	}
	public void openNewWindow() {
		driver.switchTo().newWindow(WindowType.WINDOW);
	}
	public void openNewTab() {
		driver.switchTo().newWindow(WindowType.TAB);
	}
}
	


