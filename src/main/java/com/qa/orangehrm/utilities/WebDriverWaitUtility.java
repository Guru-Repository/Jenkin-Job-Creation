package com.qa.orangehrm.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.orangehrm.Validation.ValidationHelper;
import com.qa.orangehrmexceptions.ElementExceptions;

public class WebDriverWaitUtility extends BaseUtility{
		private WebDriverWait ww;
		static final int SHORT_WAIT = 3;
		static final int MED_WAIT = 5;
		static final int LONG_WAIT = 10;
	
			public WebDriverWaitUtility(WebDriver driver) {
				super(driver);
			}
		
			public WebDriverWait driverWait() {
			ww = new WebDriverWait(driver, Duration.ofSeconds(MED_WAIT));
			return ww;
			}
			
			public WebDriverWait getDriverWait() {
				return  driverWait();
			}
			
//			Presence of element -> DOM
			public WebElement checkPresenceOfElement(By locator) {
				ValidationHelper.validateLocator(locator, "checkPresenceOfElement");
				try {
					return getDriverWait().until(ExpectedConditions.presenceOfElementLocated(locator));
				} catch (Exception e) {
					throw new ElementExceptions("===[WebDriverWaitUtility] - checkPresenceOfElement is failed=== "+e);				}
			}
//			Visibility of Element -> UI
			public WebElement checkVisibilityOfElement(By locator) {
				ValidationHelper.validateLocator(locator, "checkVisibilityOfElement");
				try {
					return getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
				} catch (Exception e) {
					throw new ElementExceptions("===[WebDriverWaitUtility] - checkVisibilityOfElement is failed=== "+e);				}
			}
//			Element clickable
			public WebElement checkElementClickable(By locator) {
				ValidationHelper.validateLocator(locator, "checkElementClickable");
				try {
					return getDriverWait().until(ExpectedConditions.elementToBeClickable(locator));
				} catch (Exception e) {
					throw new ElementExceptions("===[WebDriverWaitUtility] - checkElementClickable is failed=== "+e);				}
			}
//			Url Contains
			
			public Boolean checkExpectedUrl(String expectedUrl) {
				ValidationHelper.validateString(expectedUrl, "checkExpectedUrl");
				try {
					return getDriverWait().until(ExpectedConditions.urlContains(expectedUrl));
				} catch (Exception e) {
					throw new ElementExceptions("===[WebDriverWaitUtility] - checkExpectedUrl is failed, because it is not matching with expected one=== "+e);				}
			}
			
//		Title contains	
			public Boolean checkExpectedTitle(String expectedTitle) {
				ValidationHelper.validateString(expectedTitle, "checkExpectedTitle");
				try {
					return getDriverWait().until(ExpectedConditions.titleContains(expectedTitle));
				} catch (Exception e) {
					throw new ElementExceptions("===[WebDriverWaitUtility] - checkExpectedTitle is failed, because it is not matching with expected one=== "+e);				}
			}			
}
