package com.qa.orangehrm.pagelayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIM_Page extends BasePage{
	//PimPage
	By addEmp = By.xpath("//a[.='Add Employee']");
	
	//Add emp Page
	By fnTf = By.name("firstName");
	By mnTf = By.name("middleName");
	By lnTf = By.name("lastName");
	By save = By.xpath("//button[@type='submit']");
	By cancel = By.xpath("//button[.=' Cancel ']");
	
	public PIM_Page(WebDriver driver){
		super(driver);
	}
	
	public void clickOnAddEmp() {
		driver.findElement(addEmp).click();
	}
	
	public void addEmployeeDetails(String fn,String mn,String ln) throws InterruptedException {
		driver.findElement(fnTf).sendKeys(fn);
		driver.findElement(mnTf).sendKeys(mn);
		driver.findElement(lnTf).sendKeys(ln);
		driver.findElement(save).click();
		Thread.sleep(2000);
		clickOnAddEmp();
	}
}
