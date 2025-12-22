package com.qa.orangehrm.pagelayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage{
	private final By adminPageHeader = By.cssSelector(".oxd-topbar-header-breadcrumb h6");
	private final By userName = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	private final By seachBtn = By.xpath("//button[@type='submit']");
	private final By recordsMsg = By.xpath("//span[contains(.,'Record Found')]");
	public AdminPage(WebDriver driver) {
		super(driver);
		}
	
	public boolean verifyAdminPageHeader() {
		return bu.locateElement(adminPageHeader).isDisplayed();
//		return driver.findElement(adminPageHeader).isDisplayed();
	}
	
	public boolean searchForUser(String enteredUserName) {
		 bu.locateElement(userName).sendKeys(enteredUserName);
		 bu.locateElement(seachBtn).click();
//		driver.findElement(userName).sendKeys(enteredUserName);
//		driver.findElement(seachBtn).click();
		try {
			return  bu.locateElement(recordsMsg).isDisplayed();
			} catch (Exception e) {
			System.out.println("The records is not displayed");
			return false;
		}
	}
}
