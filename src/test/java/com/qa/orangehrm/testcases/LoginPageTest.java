package com.qa.orangehrm.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.orangehrm.basetest.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("CRS-101")
@Feature("SRS-101:LoginFunctionality")
@Story("FS-101:TestOfLogin")
//@Listeners(ChainTestListener.class)
public class LoginPageTest extends BaseTest{
	private static final  Logger  log =  LogManager.getLogger(LoginPageTest.class);

	@Owner("Test001")
	@Severity(SeverityLevel.MINOR)
	@Description("Verify-checkLoginPageHeading")
	@Test
	public void checkLoginPageHeading() {
	boolean heading = lp.verifyLoginPageHeading();
	Assert.assertTrue(heading);
	log.info("Verifird checkLoginPageHeading");//Testng report
	ChainTestListener.log("Verifird checkLoginPageHeading");//chaintest report
	}
	@Owner("Test001")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify-checkLoginPageUrl")
	@Test
	public void checkLoginPageUrl() {
		String loginPageUrl = lp.verifyLoginPageUrl();
		boolean res = loginPageUrl.contains("/auth/login");
		Assert.assertTrue(res);
		log.info("checkLoginPageUrl is success");
		ChainTestListener.log("checkLoginPageUrl is success");//chaintest report
	}
	@Owner("Test001")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify-checkLoginPageTitle")
	@Test
	public void checkLoginPageTitle() {
		String actualLoginPageTitle = lp.verifyLoginPageTitle();
		Assert.assertEquals(actualLoginPageTitle, "OrangeHRM");
		log.info("checkLoginPageTitle is success");
		ChainTestListener.log("checkLoginPageTitle is success");//chaintest report
	}
	@Owner("Test001")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify-checkForgotPsw")
	@Test
	public void checkForgotPsw() {
		Assert.assertTrue(lp.checkForgotPswExists()); 
		log.info("checkForgotPsw is success");
		ChainTestListener.log("checkForgotPsw is success");//chaintest report
	}
	@Owner("Test001")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify-doLoginApp")
	@Test
	public void doLoginApp() {
//		dbp = lp.doLogin("Admin", "admin123");
		
		dbp = lp.doLogin(prop.getProperty("usn"),prop.getProperty("psw"));
		log.info("doLoginApp is success");
		ChainTestListener.log("doLoginApp is success");//chaintest report
//		Assert.fail();
	}
	
	
	@Test
	public void TestLoginApp() {
		log.info("Test code added");
	}
	
	

}
