package com.qa.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.orangehrm.basetest.BaseTest;
import com.qa.orangehrm.pagelayers.AdminPage;

	public class AdminPageTest extends BaseTest{
		@BeforeClass
		public void AdminPageSetup() {
		dbp = lp.doLogin(prop.getProperty("usn"),prop.getProperty("psw"));
		ap = (AdminPage) dbp.selectMenu("Admin");
 
	}
	//Testcases
	@Test(priority = 1)
	public void checkAdminPage() {
		boolean res = ap.verifyAdminPageHeader();
		Assert.assertTrue(res);
	}
	@Test(priority = 2)
	public void searchUsers() {
		boolean res = ap.searchForUser("admin");
		Assert.assertTrue(res);
	}
	
}
