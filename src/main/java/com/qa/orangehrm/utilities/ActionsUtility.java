package com.qa.orangehrm.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.Validation.ValidationHelper;
import com.qa.orangehrm.frameworkobjects.UtilityObjects;
import com.qa.orangehrmexceptions.ElementExceptions;

public class ActionsUtility extends BaseUtility{
	public ActionsUtility(WebDriver driver) {
		super(driver);
	}
	//Basic Mouse Actions
	public void click(WebElement element) {
		ValidationHelper.validateElement(element, "click");
		try {
			UtilityObjects.actionsObject(driver).click(element).perform();	
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - click failed on element: " +element+" " +e+ "===");
		}
	}
	public void doubleClick(WebElement element) {
		ValidationHelper.validateElement(element, "doubleClick");
		try {
			UtilityObjects.actionsObject(driver).doubleClick(element).perform();	
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - doubleClick failed on element " +element+" " +e+ "===");
		}
	}
	public void rightClick(WebElement element) {
		ValidationHelper.validateElement(element, "rightClick");
		try {
			UtilityObjects.actionsObject(driver).contextClick(element).perform();	
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - rightClick failed on element " +element+" " +e+ "===");
		}
	}
	public void rightClick() {
		try {
			UtilityObjects.actionsObject(driver).contextClick().perform();	
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - rightClick failed at current mouse position "+e+"===");
		}
	}

	//Hover / Move
	public void moveToElement(WebElement element) {
		ValidationHelper.validateElement(element, "moveToElement");
		try {
			UtilityObjects.actionsObject(driver).moveToElement(element).perform();	
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - moveToElement failed on offSet " +element+" " +e+ "===");
		}
	}
	
	public void moveToElement(WebElement element, int xOffset, int yOffset) {
		ValidationHelper.validateElement(element, "moveToElement");
		try {
			UtilityObjects.actionsObject(driver).moveToElement(element,xOffset,yOffset).perform();	
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - moveToElement failed on offSet " +element+" " +e+ "===");
		}
	}
	
	//	Click & Hold
	public void clickAndHold(WebElement element) {
		ValidationHelper.validateElement(element, "clickAndHold");
		try {
			UtilityObjects.actionsObject(driver).clickAndHold(element).perform();	
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - clickAndHold failed on element " +element+" " +e+ "===");
		}
	}
	public void release(WebElement element) {
		ValidationHelper.validateElement(element, "release");
		try {
			UtilityObjects.actionsObject(driver).release(element).perform();	
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - release failed on element " +element+" " +e+ "===");
		}
	}
	
	
	//Drag and Drop
	public void dragDrop(WebElement srcElement,WebElement targetElement) {
		ValidationHelper.validateElement(srcElement, "dragDrop");
		ValidationHelper.validateElement(targetElement, "dragDrop");
		try {
			UtilityObjects.actionsObject(driver).dragAndDrop(srcElement,targetElement).perform();	
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - dragDrop failed on element " +srcElement+targetElement+" "+e+ "===");
		}
	}
	public void dragDropBy(WebElement srcElement,int xOffSet,int yOffSet) {
		ValidationHelper.validateElement(srcElement, "dragDropBy");
		try {
			UtilityObjects.actionsObject(driver).dragAndDropBy(srcElement,xOffSet,yOffSet).perform();	
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - dragDrop failed on element " +srcElement+" "+e+ "===");
		}
	}
	
	//KeyBoard Actions
	public void sendKeys(CharSequence keys) {
		ValidationHelper.validateString(keys.toString(), "sendKeys");
		try {
			UtilityObjects.actionsObject(driver).sendKeys(keys).perform();	
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - sendKeys failed" +e+ "===");
		}
	}
	public void sendKeys(WebElement element,CharSequence keys) {
		ValidationHelper.validateString(keys.toString(), "sendKeys");
		ValidationHelper.validateElement(element, "sendKeys");
		try {
			UtilityObjects.actionsObject(driver).sendKeys(element,keys).perform();	
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - sendKeys failed on element "+e+ "===");
		}
	}
	public void keyDown(CharSequence key) {
		ValidationHelper.validateString(key.toString(), "keyDown");
		try {
			UtilityObjects.actionsObject(driver).keyDown(key).perform();	
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - keyDown failed for key: "+key+" "+e+ "===");
		}
	}
	public void keyDown(WebElement element,CharSequence key) {
		ValidationHelper.validateString(key.toString(), "keyDown");
		ValidationHelper.validateElement(element, "keyDown");
		try {
			UtilityObjects.actionsObject(driver).keyDown(element,key).perform();	
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - keyDown failed for key: "+key+" "+e+ "===");
		}
	}
	public void keyUp(CharSequence key) {
		ValidationHelper.validateString(key.toString(), "keyDown");
		try {
			UtilityObjects.actionsObject(driver).keyUp(key).perform();	
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - keyUp failed for key: "+key+" "+e+ "===");
		}
	}
	public void keyUp(WebElement element,CharSequence key) {
		ValidationHelper.validateString(key.toString(), "keyDown");
		ValidationHelper.validateElement(element, "keyDown");
		try {
			UtilityObjects.actionsObject(driver).keyUp(element,key).perform();	
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - keyUp failed for key: "+key+" "+e+ "===");
		}
	}
	
//	Composite actions
	public void hoverAndClick(WebElement hoverElement,WebElement clickElement) {
		ValidationHelper.validateElement(hoverElement, "keyDown");
		ValidationHelper.validateElement(clickElement, "keyDown");
		try {
			UtilityObjects.actionsObject(driver).moveToElement(hoverElement).click(clickElement).perform();
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - hoverAndClick failed "+e+"===");
		}
	}
	public void buildAndPerform() {
		try {
			UtilityObjects.actionsObject(driver).build().perform();;
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - buildAndPerform failed "+e+"===");
		}
	}
	public void pause(Duration time) {
		try {
			UtilityObjects.actionsObject(driver).pause(time).perform();;
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - pause failed "+e+"===");
		}
	}
	
//	Scroll Actions 
	public void scrollToElement(WebElement element) {
		ValidationHelper.validateElement(element, "scrollToElement");
		try {
			UtilityObjects.actionsObject(driver).scrollToElement(element).perform();	
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - scrollToElement failed on element " +element+" "+e+ "===");
		}
	}
	
	public void scrollByAmount(int x, int y) {
		try {
			UtilityObjects.actionsObject(driver).scrollByAmount(x,y).perform();	
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[ActionsUtility] - scrollByAmount failed on axis" +x+","+y+" "+e+ "===");
		}
	}
}
