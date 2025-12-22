package com.qa.orangehrm.Validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.orangehrmexceptions.ElementExceptions;

public class ValidationHelper {
	
	public static void validateLocator(By locatorName,String methodName) {
		if(locatorName==null) {
			throw new ElementExceptions("===[ValidationHelper]-- locator cannot be null ,The entered locator name is : "+locatorName);
		}
		if(methodName==null) {
			throw new ElementExceptions("===[ValidationHelper]-- methodName cannot be null==\n"
					+ "The entered method name is :"+methodName);
		}
	}
	public static void validateElement(WebElement elementName, String methodName) {
		if(elementName==null) {
			throw new ElementExceptions("===[ValidationHelper]-- element name cannot be null==\n "
					+ "The entered element name is :"+elementName);
		}
		if(methodName==null) {
			throw new ElementExceptions("===[ValidationHelper]-- methodName cannot be null==\n"
					+ "The entered method name is :"+methodName);
		}
	}
		
	public static void validateString(String enteredInput,String methodName) {
		if(enteredInput==null) {
			throw new ElementExceptions("===[ValidationHelper]-- enteredInput is null,The entered input is :"+enteredInput+"===");
		}
		if(methodName==null) {
			throw new ElementExceptions("===[ValidationHelper]-- methodName cannot be null==\n"
					+ "The entered method name is :"+methodName);
		}
	}
}

