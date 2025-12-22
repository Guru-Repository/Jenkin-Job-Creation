package com.qa.orangehrm.frameworkobjects;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.qa.orangehrmexceptions.FrameworkExceptions;

public class UtilityObjects {

	public static Actions actionsObject(WebDriver driver) {
		return new Actions(driver);
	}
	
	public static Select selectObject(WebElement element) {
	return new Select(element);	
	}
	
	public static Robot robotObject() {
		try {
			return new Robot();
		} catch (AWTException e) {
			throw new FrameworkExceptions("===Robotclass Object is not returned===");
		}
	}
}
