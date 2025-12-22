package com.qa.orangehrm.pagelayers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrmexceptions.FrameworkExceptions;

public class DashboardPage extends BasePage {
	
	private final By dashboardPageHeading = By.cssSelector(".oxd-topbar-header-breadcrumb>h6");
	private final By menuList = By.xpath("//*[local-name()='svg']/following-sibling::span");
	private final By profileMenu = By.cssSelector(".oxd-userdropdown-tab");
	private final By logoutOption = By.xpath("//a[.='Logout']");
	
	public DashboardPage(WebDriver driver) {
		super(driver); 
	}
	
	public String verifyDashboardPageHeading() {
		String headingText =  bu.locateElement(dashboardPageHeading).getText();
		System.out.println("The dashboard page header text is :"+headingText);
		return headingText;
	}
	
	public int verifyListCountOfMenuList() {
		List<WebElement> menuListOptions =  bu.locateElements(menuList);
		int actualMenuListCount = menuListOptions.size();
		return actualMenuListCount;
	}
	
	public void fetchMenuListOptions() {
		List<WebElement> menuListOptions = bu.locateElements(menuList);
		for(WebElement menuListOption:menuListOptions) {
			String options = menuListOption.getText();
			System.out.println(options);
		}
	}
	
	public BasePage selectMenu(String expactedMenuName) {
		List<WebElement> listOfmenu = bu.locateElements(menuList);
		int totalMenuCount = listOfmenu.size();
		System.out.println("Total no of menu list is :"+totalMenuCount);
		for(WebElement menu:listOfmenu) {
			String actualMenuText = menu.getText();
			if(actualMenuText.equals(expactedMenuName)) {
			menu.click();			
			switch(expactedMenuName) {
			case "Admin":return new AdminPage(driver);
			case "PIM":return new PIM_Page(driver);
			case "Leave":return new LeavePage(driver);
			case "Recruitment":return new RecruitmentPage(driver);
			case "TimePage":return new TimePage(driver);
			default:System.out.println("Invalid Menu");
			throw new FrameworkExceptions("===Invalid Menu List Expected===");
			}
			}
		}
		throw new FrameworkExceptions("===Invalid Menu List Expected===");
	}

	public void logoutApplication() {
		bu.locateElement(profileMenu).click();
		bu.locateElement(logoutOption).click();
	}
}
