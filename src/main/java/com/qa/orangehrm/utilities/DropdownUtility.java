package com.qa.orangehrm.utilities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.Validation.ValidationHelper;
import com.qa.orangehrm.frameworkobjects.UtilityObjects;
import com.qa.orangehrmexceptions.ElementExceptions;

public class DropdownUtility extends BaseUtility {
	public DropdownUtility(WebDriver driver) {
	super(driver);
	}
//Select the options
	public void selectByValue(WebElement dropdown, String value) {
		ValidationHelper.validateElement(dropdown, "selectByValue");
		ValidationHelper.validateString(value,"selectByValue");
		try {
			UtilityObjects.selectObject(dropdown).selectByValue(value);
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[DropdownUtility] -selectByValue is failed ===");
		}
	}
	public void selectByVisibletext(WebElement dropdown, String visibleText) {
		ValidationHelper.validateElement(dropdown, "selectByVisibletext");
		ValidationHelper.validateString(visibleText,"selectByVisibletext");
		try {
			UtilityObjects.selectObject(dropdown).selectByVisibleText(visibleText);
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[DropdownUtility] -selectByVisibletext is failed ===");
		}
	}
	public void selectByContainsVisibletext(WebElement dropdown, String cotainsVisibleText ) {
		ValidationHelper.validateElement(dropdown, "selectByContainsVisibletext");
		ValidationHelper.validateString(cotainsVisibleText,"selectByContainsVisibletext");
		try {
			UtilityObjects.selectObject(dropdown).selectByContainsVisibleText(cotainsVisibleText);
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[DropdownUtility] -selectByContainsVisibletext is failed ===");
		}
	}
	public void selectByIndex(WebElement dropdown,int index) {
		ValidationHelper.validateElement(dropdown, "selectByValue");
		if(index<0) {
		throw new ElementExceptions("===[DropdownUtility]- === index cannot be less than 0");	
		}
		try {
			UtilityObjects.selectObject(dropdown).selectByIndex(index);
			} catch (RuntimeException e) {
			throw new ElementExceptions("===[DropdownUtility]- selectByIndex is failed=== ");	
			}
	}
	
//Deselect options
	
	public void deselectByValue(WebElement dropdown, String value) {
		ValidationHelper.validateElement(dropdown, "deselectByValue");
		ValidationHelper.validateString(value,"deselectByValue");
		try {
			UtilityObjects.selectObject(dropdown).deselectByValue(value);
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[DropdownUtility] -deselectByValue is failed ==="+e);
		}
	}
	public void deselectByVisibletext(WebElement dropdown, String visibleText) {
		ValidationHelper.validateElement(dropdown, "deselectByVisibletext");
		ValidationHelper.validateString(visibleText,"deselectByVisibletext");
		try {
			UtilityObjects.selectObject(dropdown).deselectByVisibleText(visibleText);
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[DropdownUtility] -deselectByVisibletext is failed ==="+e);
		}
	}
	public void deselectByContainsVisibletext(WebElement dropdown, String cotainsVisibleText ) {
		ValidationHelper.validateElement(dropdown, "deselectByContainsVisibletext");
		ValidationHelper.validateString(cotainsVisibleText,"deselectByContainsVisibletext");
		try {
			UtilityObjects.selectObject(dropdown).deSelectByContainsVisibleText(cotainsVisibleText);
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[DropdownUtility] -deselectByContainsVisibletext is failed ==="+e);
		}
	}
	public void deselectByIndex(WebElement dropdown,int index) {
		ValidationHelper.validateElement(dropdown, "deselectByIndex");
		if(index<0) {
		throw new ElementExceptions("===[DropdownUtility]- === index cannot be less than 0");	
		}
		try {
			UtilityObjects.selectObject(dropdown).deselectByIndex(index);
			} catch (RuntimeException e) {
			throw new ElementExceptions("===[DropdownUtility]- deselectByIndex is failed=== "+e);	
			}
	}
	
	public void deselectAll(WebElement dropdown) {
		ValidationHelper.validateElement(dropdown, "deselectAll");
		try {
			UtilityObjects.selectObject(dropdown).deselectAll();
			} catch (RuntimeException e) {
			throw new ElementExceptions("===[DropdownUtility]- deselectAll is failed=== "+e);	
			}
	}
	
	public WebElement fetchFirstSelectedOption(WebElement dropdown) {
		ValidationHelper.validateElement(dropdown, "fetchFirstSelectedOption");
		try {
			WebElement option = UtilityObjects.selectObject(dropdown).getFirstSelectedOption();
			System.out.println("The first selected option of dropdown is :"+option.getText());
			return option;
			} catch (RuntimeException e) {
			throw new ElementExceptions("===[DropdownUtility]- fetchFirstSelectedOption is failed=== "+e);	
			}

	}
	public List<WebElement> fetchAllSelectedOptions(WebElement dropdown) {
		ValidationHelper.validateElement(dropdown, "fetchAllSelectedOptions");
		try {
			List<WebElement> options = UtilityObjects.selectObject(dropdown).getAllSelectedOptions();
			for(WebElement option:options) {
				System.out.println("The selected options of dropdown is :"+option.getText());
			}
			return options;
			} catch (RuntimeException e) {
			throw new ElementExceptions("===[DropdownUtility]- fetchAllSelectedOptions is failed=== "+e);	
			}
	}
	public List<WebElement> fetchOptions(WebElement dropdown) {
	ValidationHelper.validateElement(dropdown, "fetchOptions");
	try {
		List<WebElement> options = UtilityObjects.selectObject(dropdown).getOptions();
		for(WebElement option:options) {
			System.out.println("The selected options of dropdown is :"+option.getText());
		}
		return options;
		} catch (RuntimeException e) {
		throw new ElementExceptions("===[DropdownUtility]- fetchOptions is failed=== "+e);	
		}
	}
	
	public boolean checkMultiple(WebElement dropdown) {
		ValidationHelper.validateElement(dropdown, "checkMultiple");
		try {
			return UtilityObjects.selectObject(dropdown).isMultiple();
		} catch (RuntimeException e) {
			throw new ElementExceptions("===[DropdownUtility]- checkMultiple - It is single select dropdown=== "+e);	
		}
		
	}
	
	
	
	
	
	
	
}
