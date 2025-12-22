package com.qa.orangehrm.utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.Validation.ValidationHelper;
import com.qa.orangehrmexceptions.ElementExceptions;

import io.qameta.allure.Step;

public class ElementUtilities extends BaseUtility{
	public ElementUtilities(WebDriver driver){
		super(driver);
	}
	@Step("doClick on element :{0}")
	public void doClick(WebElement elementName) {
		ValidationHelper.validateElement(elementName, "doClick");
		try {
			elementName.click();
		} catch (Exception e) {
			throw new ElementExceptions("===[ElementUtilities] - doClick is not performed on element "+elementName+"===");
		}
	}
	public void doClear(WebElement elementName) {
		ValidationHelper.validateElement(elementName, "doClear");
		try {
			elementName.clear();
		} catch (Exception e) {
			throw new ElementExceptions("===[ElementUtilities] - doClear is not performed on element "+elementName+"===");
		}
	}
	@Step("doSendKeys with elementName :{0} and enter value :{1}")
	public void doSendKeys(WebElement elementName,String value) {
		ValidationHelper.validateElement(elementName, "doClear");
		ValidationHelper.validateString(value, "doSendKeys");
		try {
			elementName.sendKeys(value);
		} catch (Exception e) {
			throw new ElementExceptions("===[ElementUtilities] - doSendKeys is not performed on element "+elementName+"===");
		}
	}
	public String fetchInnerText(WebElement elementName) {
		ValidationHelper.validateElement(elementName, "doClear");
		System.out.println("The inner text is "+elementName.getText());
		try {
			return elementName.getText();
		} catch (Exception e) {
			throw new ElementExceptions("===[ElementUtilities] - fetchInnerText is not performed on element "+elementName+"===");
		}
	}
	
	
	
	//*
	public Dimension fetchElementSize(WebElement elementName) {
		ValidationHelper.validateElement(elementName, "fetchElementSize");
		System.out.println("The ElementSize is "+elementName.getSize());
		try {
			return elementName.getSize();
		} catch (Exception e) {
			throw new ElementExceptions("===[ElementUtilities] - fetchElementSize is not performed on element "+elementName+"===");
		}
}
	public int fetchElementWidth(WebElement elementName) {
		ValidationHelper.validateElement(elementName, "fetchElementWidth");
		System.out.println("The ElementWidth is "+elementName.getSize().getWidth());
		try {
			return elementName.getSize().getWidth();
		} catch (Exception e) {
			throw new ElementExceptions("===[ElementUtilities] - fetchElementWidth is not performed on element "+elementName+"===");
		}
	}
	public int fetchElementHeight(WebElement elementName) {
		ValidationHelper.validateElement(elementName, "fetchElementHeight");
		System.out.println("The ElementHeight is "+elementName.getSize().getHeight());
		try {
			return elementName.getSize().getHeight();
		} catch (Exception e) {
			throw new ElementExceptions("===[ElementUtilities] - fetchElementHeight is not performed on element "+elementName+"===");
		}
	}
	public Point fetchElementLocation(WebElement elementName) {
		ValidationHelper.validateElement(elementName, "fetchElementLocation");
		System.out.println("The ElementLocation is "+elementName.getLocation());
		try {
			return elementName.getLocation();
		} catch (Exception e) {
			throw new ElementExceptions("===[ElementUtilities] - fetchElementHeight is not performed on element "+elementName+"===");
		}
	}
	public int fetchElementXaxis(WebElement elementName) {
		ValidationHelper.validateElement(elementName, "fetchElementXaxis");
		System.out.println("The ElementXaxis is "+elementName.getLocation().getX());
		try {
			return elementName.getLocation().getX();
		} catch (Exception e) {
			throw new ElementExceptions("===[ElementUtilities] - fetchElementXaxis is not performed on element "+elementName+"===");
		}
	}
	public int fetchElementYaxis(WebElement elementName) {
		ValidationHelper.validateElement(elementName, "fetchElementYaxis");
		System.out.println("The ElementYaxis is "+elementName.getLocation().getY());
		try {
			return elementName.getLocation().getY();
		} catch (Exception e) {
			throw new ElementExceptions("===[ElementUtilities] - fetchElementYaxis is not performed on element "+elementName+"===");
		}
	}
	
	public boolean checkElementIsDisplayed(WebElement elementName) {
		ValidationHelper.validateElement(elementName, "checkElementIsDisplayed");
		try {
			return elementName.isDisplayed();
		} catch (Exception e) {
			throw new ElementExceptions("===[ElementUtilities] - checkElementIsDisplayed is not performed on element "+elementName+"===");
		}
	}
	public boolean checkElementIsEnabled(WebElement elementName) {
		ValidationHelper.validateElement(elementName, "checkElementIsEnabled");
		try {
			return elementName.isEnabled();
		} catch (Exception e) {
			throw new ElementExceptions("===[ElementUtilities] - checkElementIsEnabled is not performed on element "+elementName+"===");
		}
	}
	public boolean checkElementIsSelected(WebElement elementName) {
		ValidationHelper.validateElement(elementName, "checkElementIsSelected");
		try {
			return elementName.isSelected();
		} catch (Exception e) {
			throw new ElementExceptions("===[ElementUtilities] - checkElementIsSelected is not performed on element "+elementName+"===");
		}
	}
	
	public String fetchElementTagName(WebElement elementName) {
		ValidationHelper.validateElement(elementName, "fetchElementTagName");
		System.out.println("The ElementTagName is "+elementName.getTagName());
		try {
			return elementName.getTagName();
		} catch (Exception e) {
			throw new ElementExceptions("===[ElementUtilities] - fetchElementTagName is not performed on element "+elementName+"===");
		}
	}
	public String fetchElementAttributeValue(WebElement elementName,String attributeName) {
		ValidationHelper.validateElement(elementName, "fetchElementTagName");
		ValidationHelper.validateString(attributeName, "fetchElementAttributeValue");
		System.out.println("The ElementAttributeValue is "+elementName.getAttribute(attributeName));
		try {
			return elementName.getAttribute(attributeName);
		} catch (Exception e) {
			throw new ElementExceptions("===[ElementUtilities] - fetchElementAttributeValue is not performed on element "+elementName+"===");
		}
	}
	
	public String fetchElementCssValue(WebElement elementName,String elementKey) {
		ValidationHelper.validateElement(elementName, "fetchElementCssValue");
		ValidationHelper.validateString(elementKey, "fetchElementCssValue");
		System.out.println("The ElementCssValue is "+elementName.getCssValue(elementKey));
		try {
			return elementName.getCssValue(elementKey);
		} catch (Exception e) {
			throw new ElementExceptions("===[ElementUtilities] - fetchElementAttributeValue is not performed on element "+elementName+"===");
		}
	}
}
/*
 * click
 * clear
 * sendkeys
 * submit
 * findelement
 * findelements
 * gettext
 * getsize
 * getlocation
 * isdisplayed
 * isenabled
 * isselected
 * gettagname
 * 
 * 
 * 
 * getattribute
 * getcssvalue
 * 
 * 
 * getdomproperty
 * getdomattribute
 * getrect
 * getscreenshot
 * getshadowroot
 * getaccessiblename
 * getarearole
 * 
 */
