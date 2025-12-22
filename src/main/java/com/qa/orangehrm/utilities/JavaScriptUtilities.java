package com.qa.orangehrm.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.Validation.ValidationHelper;
import com.qa.orangehrmexceptions.ElementExceptions;

public class JavaScriptUtilities extends BaseUtility{
	private JavascriptExecutor jse;
	public JavaScriptUtilities(WebDriver driver) {
	super(driver);
	jse = (JavascriptExecutor)driver;
	}
	
	//pass input
	public void enterInputJSE(String input,WebElement element) {
		ValidationHelper.validateElement(element, "enterInputJse");
		jse.executeScript("arguments[0].value='"+input+"'",element);
	}

	//clear input
	public void clearInputJSE(WebElement element) {
		ValidationHelper.validateElement(element, "enterInputJse");
		jse.executeScript("arguments[0].clear();",element);
	}
	
	//scroll to element
	public void scrollToEleJSE(WebElement element) {
		ValidationHelper.validateElement(element, "enterInputJse");
		jse.executeScript("arguments[0].scrollIntoView();",element);
	}
	
	//scroll y
	public void scrollYJSE(int x,int y) {
		if(x>0 && y<0) {
			throw new ElementExceptions("===[JavaScriptUtilities] -X is greater than 0 and y lesser than 0===");
		}
		jse.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	public void scrollXJSE(int x,int y) {
		if(x<0 && y==0) {
			throw new ElementExceptions("===[JavaScriptUtilities] - X is less than 0 and y graeter than 0===");
		}
		jse.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	//scroll to bottom
	public void scrollPageBottomJSE() {
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	//scoll to top
	public void scrollPageTopJSE() {
		jse.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	//zoom the page
	public void zoomPageJSE(int zoomSize) {
		jse.executeScript("document.body.style.zoom='"+zoomSize+"%"+"'");
	}
	//highlight
	public void markElementJSE(WebElement element) {
		ValidationHelper.validateElement(element, "markElementJSE");
		jse.executeScript("arguments[0].style.border='3px solid red'",element);
	}
	
	
	
	
	





}
