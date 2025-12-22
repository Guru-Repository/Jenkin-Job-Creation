package com.qa.orangehrm.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

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
public class InvalidLoginPageTest extends BaseTest{
	private static final  Logger  log =  LogManager.getLogger(LoginPageTest.class);
	@Owner("Test001")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify-checkInvalidCredentials")
	
	@Test
	public void checkInvalidCredentials() {
		Assert.assertTrue(lp.doInvalidLogin("Admin12344", "admin123")); ;
		log.info("TestClass[InvalidLoginPageTest]- TestMethod[checkInvalidCredentials] is Passed");
	}
}
