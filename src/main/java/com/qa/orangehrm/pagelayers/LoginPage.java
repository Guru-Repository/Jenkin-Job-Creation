package com.qa.orangehrm.pagelayers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {
//	WebDriver driver;//null
	private static final  Logger  log =  LogManager.getLogger(LoginPage.class);

//Declaration-locators
	private final By loginPageHeading = By.xpath("//h5[.='Login']");
	private final By username = By.name("username");
	private final By password = By.name("password");
	private final By login = By.xpath("//button[@type='submit']");
	private final By forgotPsw = By.cssSelector(".orangehrm-login-forgot");
	private final By invlaidCredentials = By.cssSelector(".oxd-alert.oxd-alert--error");
	
	//Initialization
	public LoginPage(WebDriver driver)//null
	{
	super(driver);
	}

	//Utilization
	@Step("verifyLoginPageHeading")
	public boolean verifyLoginPageHeading() {
			return bu.locateElement(loginPageHeading).isDisplayed();
	}
	@Step("verifyLoginPageUrl")
	public String verifyLoginPageUrl() {
		String loginPageUrl = bu.fetchCurrentPageUrl();
		log.info("The login page url is :"+loginPageUrl);
		return loginPageUrl;
	}
	@Step("verifyLoginPageTitle")
	public String verifyLoginPageTitle() {
//		String loginPageTitle = driver.getTitle();
		String loginPageTitle = bu.fetchApplicationTitle();
		log.info("Login page title is :"+loginPageTitle);
		return loginPageTitle;
	}
	@Step("checkForgotPswExists")
	public boolean checkForgotPswExists() {
		return bu.locateElement(forgotPsw).isDisplayed();
	}
	@Step("doLogin by entering usn :{0} and psw :{1}")
	public DashboardPage doLogin(String appUsn,String appPsw) {
		WebElement usnTf = bu.locateElement(username);
		eu.doSendKeys(usnTf, appUsn);
		WebElement pswTf = bu.locateElement(password);
		eu.doSendKeys(pswTf,appPsw);
		WebElement loginBtn = bu.locateElement(login);
		eu.doClick(loginBtn);
		return new DashboardPage(driver);
	}
	@Step("doLogin by entering ivalid usn :{0} and psw :{1}")
	public boolean doInvalidLogin(String appInvalidUsn,String appInvalidPsw) {
		WebElement usnTf = bu.locateElement(username);
		eu.doSendKeys(usnTf, appInvalidUsn);
		WebElement pswTf = bu.locateElement(password);
		eu.doSendKeys(pswTf,appInvalidPsw);
		WebElement loginBtn = bu.locateElement(login);
		eu.doClick(loginBtn);
		return driver.findElement(invlaidCredentials).isDisplayed();		
	}

	@Step("clickForgotPsw")
	public void clickForgotPsw() {
		bu.locateElement(forgotPsw).click();
	}
}
